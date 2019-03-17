package by.yarom.library.Controller;


import by.yarom.library.Entity.Users;
import by.yarom.library.Service.RoleService;
import by.yarom.library.Service.UsersService;
import by.yarom.library.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private RoleService roleService;


    @Autowired
    @Qualifier(value = "userValidator")
    private UserValidator userValidator;

    @GetMapping("/")
    public String redirectPage(){
        return "redirect:/books";
    }

    @GetMapping("/sign_up")
    public String getSignUp(Model model) {
        model.addAttribute("user", new Users());

        return "/sign_up";
    }

    @PostMapping("/sign_up")
    public String signUp(@ModelAttribute Users user, BindingResult result) {
        userValidator.validate(user, result);
        System.out.println(result.getAllErrors());
        if (result.hasErrors()) {
            return "/sign_up";
        }

        user.setRole(roleService.getRoleById(2));
        usersService.addUser(user);
        return "redirect:/users";
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
