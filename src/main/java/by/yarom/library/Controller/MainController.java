package by.yarom.library.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping(value = "/checkReadersBooks")
    public String checkReadersBooks(){
        return "/checkReadersBooks";
    }

    @RequestMapping(value = "/error")
    public String error(){
        return "/error";
    }

}
