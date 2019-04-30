package by.yarom.library.Controller;

import by.yarom.library.Entity.Give;
import by.yarom.library.Entity.Users;
import by.yarom.library.Service.GiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@PreAuthorize("hasAuthority('reader')")
@Controller
public class ReaderController {

    @Autowired
    private GiveService giveService;

    @RequestMapping(value = "/checkReadersBooks")
    public String checkReadersBooks(Model model,
                                    @AuthenticationPrincipal Users user){


            List<Give> listBook = giveService.giveListByReaderByBooksNotFinished(
                    user.getReader().getFirstName(),
                    user.getReader().getLastName(),
                    user.getReader().getMiddleName());
            if (listBook.isEmpty()) {
                model.addAttribute("status", "Нет задолженностей по книгам");
            }else {
                model.addAttribute("booksNotFinish", listBook);
            }



        return "/readers/checkReadersBooks";
    }

}
