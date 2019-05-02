package by.yarom.library.Controller;

import by.yarom.library.Entity.Users;
import by.yarom.library.Service.RoleService;
import by.yarom.library.Service.UsersService;
import by.yarom.library.backup.Backup;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@PropertySource("classpath:application.properties")
public class AdminController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private RoleService roleService;

    @Value("${file.directory}")
    private String fileDirectory;

    private String nameSaveFile = "backup.sql";

    final static Logger logger = Logger.getLogger(AdminController.class);

    @RequestMapping(value = "/admin", method = RequestMethod.POST)
    public String restoreBackup(@RequestParam("file") MultipartFile file,
                                HttpServletRequest request,
                                Model model) throws IOException, InterruptedException {

        if (file != null && !file.getOriginalFilename().isEmpty()) {
            String rootDirectory = request.getSession().getServletContext().getRealPath("/");
            Path path = Paths.get(rootDirectory + fileDirectory + nameSaveFile);
            File uploadDir = new File(rootDirectory + fileDirectory);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            file.transferTo(new File(path.toString()));
            Backup.backupRestoneSQL(model, path.toString());
        }else {
            logger.error("error load backup file ");
            throw new IOException("Ошибка файла");
        }
        return "/admin";
    }

    @RequestMapping(value = "/backup")
    public void backup(HttpServletRequest request,
                         HttpServletResponse response) throws IOException, InterruptedException {
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        Path path = Paths.get(rootDirectory + fileDirectory + nameSaveFile);
        File uploadDir = new File(rootDirectory + fileDirectory);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        Backup.backupSQL(path.toString());

        if (Files.exists(path)) {
            response.setContentType("application/sql");
            response.addHeader("Content-Disposition", "attachment; filename="+ nameSaveFile);
            Files.copy(path, response.getOutputStream());
            response.getOutputStream().flush();
        }
    }

    @ExceptionHandler(value = InterruptedException.class)
    public ModelAndView handleIOException(InterruptedException exception) {
        ModelAndView modelAndView = new ModelAndView("/error");
        logger.error("error backup " + exception.getLocalizedMessage());
        modelAndView.addObject("message", exception.getMessage());
        return modelAndView;
    }

    @ExceptionHandler(value = IOException.class)
    public ModelAndView handleIOException(IOException exception) {
        ModelAndView modelAndView = new ModelAndView("/error");
        logger.error(exception.getMessage());
        modelAndView.addObject("message", exception.getMessage());
        return modelAndView;
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(@RequestParam(value = "page", defaultValue = "1", required = false) Integer page,
                        Model model){


        model.addAttribute("usersAndRole", usersService.listUsers(page));
        Long count = usersService.countFindUsers();
        model.addAttribute("count", count);
        Long pageCount = Long.valueOf(0);
        for (int itr = 0; itr < count; itr += 10) {
            pageCount++;
        }
        model.addAttribute("countFindReaders", pageCount);
        model.addAttribute("activePage", page);

        return "/admin";
    }

    @RequestMapping(value = "/admin/del/", method = RequestMethod.GET)
    public String admin(@RequestParam (value = "id_User") int idUser){
        usersService.deleteUser(idUser);

        return "redirect:/admin";
    }

    @PostMapping(value = "/admin/edit")
    public String userEdit(@ModelAttribute ("idRole") int idRole,
                           @ModelAttribute ("login") String login,
                           HttpServletRequest request){
        Users user = usersService.getUserByLogin(login);
        user.setRole(roleService.getRoleById(idRole));
        usersService.updateUser(user);
        return "redirect:" + request.getHeader("referer");
    }

}
