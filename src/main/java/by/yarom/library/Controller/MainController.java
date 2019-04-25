package by.yarom.library.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping(value = "/error")
    public String error(){
        return "/error";
    }

    @RequestMapping(value = "/errorAccess")
    public String errorAccess(){
        return "/errorAccess";
    }

}
