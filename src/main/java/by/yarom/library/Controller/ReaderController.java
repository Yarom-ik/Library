package by.yarom.library.Controller;

import by.yarom.library.Entity.Give;
import by.yarom.library.Service.GiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.LinkedList;
import java.util.List;

@Controller
public class ReaderController {

    @Autowired
    private GiveService giveService;

    @RequestMapping(value = "/checkReadersBooks")
    public String checkReadersBooks(@RequestParam (value = "fio", required = false) String fio,
                                    Model model){
        if (fio != null) {
            String firstName;
            String lastName;
            String middleName;
            List<String> list = new LinkedList<>();
            for (String name : fio.split(" ")) {
                list.add(name);
            }
            if (list.size()!=3){
                model.addAttribute("fioError","Некоректный ввод");
                model.addAttribute("fio", fio);
                return "/readers/checkReadersBooks";
            }else {
                firstName = list.get(0);
                lastName = list.get(1);
                middleName = list.get(2);
            }

            List<Give> listBook = giveService.giveListByReaderByBooksNotFinished(firstName,lastName,middleName);
            if (listBook.isEmpty()) {
                System.out.println("error input");
                model.addAttribute("status", "Ничего не найдено");
            }else {
                model.addAttribute("booksNotFinish", listBook);
            }
            model.addAttribute("fio", fio);
        }

        return "/readers/checkReadersBooks";
    }

}
