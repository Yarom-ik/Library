package by.yarom.library.Controller;


import by.yarom.library.Entity.CatalogBooks;
import by.yarom.library.Entity.Reader;
import by.yarom.library.Entity.Users;
import by.yarom.library.Service.ReaderService;
import by.yarom.library.Service.RoleService;
import by.yarom.library.Service.UsersService;
import by.yarom.library.validator.ReaderValidator;
import by.yarom.library.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

@Controller
public class AuthController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private ReaderService readerService;

    @Autowired
    @Qualifier(value = "userValidator")
    private UserValidator userValidator;

    @Autowired
    @Qualifier(value = "readerValidator")
    private ReaderValidator readerValidator;

    @RequestMapping("/editPassword")
    public String editPass(){

        return "/editPassword";
    }

    @GetMapping("/")
    public String redirectPage(){
        return "redirect:/books";
    }

    @GetMapping("/sign_up")
    public String getSignUp(Model model) {
        model.addAttribute("user", new Users());

        return "/sign_up";
    }

    @Transactional
    @PostMapping("/sign_up")
    public String signUp(@ModelAttribute @Valid Users user, BindingResult bindingResultUser,
                         @ModelAttribute @Valid Reader reader, BindingResult bindingResultReader,
                         Model model) {
        userValidator.validate(user, bindingResultUser);
//        readerValidator.validate(reader, bindingResultReader);
        System.out.println(bindingResultUser.getAllErrors());
        if (bindingResultUser.hasErrors() || bindingResultReader.hasErrors()){
            Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResultUser);
            errorsMap.putAll(ControllerUtils.getErrors(bindingResultReader));
            model.mergeAttributes(errorsMap);
            model.addAttribute("userNew",user);
            model.addAttribute("readerNew", reader);
            return "/sign_up";
        }
        model.addAttribute("userNew",user);
        model.addAttribute("readerNew", reader);
        Reader readerInBase = readerService.getReaderByFIO(reader.getFirstName(), reader.getLastName(), reader.getMiddleName());
        if (readerInBase != null && readerInBase.getUsers() == null ){
            user.setRole(roleService.getRoleById(3));
            readerInBase.setActive(true);
            readerInBase.setUsers(user);
            usersService.addUser(user);
            readerService.updateReader(readerInBase);
            model.addAttribute("registationMessage", "Регистрация прошла успешно");
            return "/sign_up";
        }
        if (readerInBase != null && readerInBase.getUsers().getLogin() != null) {
            model.addAttribute("registationMessage", "Вы уже зарегистрированы в системе");
            return "/sign_up";
        }else {
            user.setRole(roleService.getRoleById(3));
            reader.setActive(true);
            reader.setUsers(user);
            usersService.addUser(user);
            readerService.addReader(reader);
            model.addAttribute("registationMessage", "Регистрация прошла успешно");
            return "/sign_up";

        }

    }

    @RequestMapping("/login")
    public String login(@RequestParam(name = "error", required = false) Boolean error,
                        Model model) {
        if (Boolean.TRUE.equals(error)) {
            model.addAttribute("error", true);
        }
        return "/sign_in";
    }

}
