package by.yarom.library.validator;


import by.yarom.library.Entity.CatalogBooks;
import by.yarom.library.Service.CatalogBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;

@Component("bookValidator")
public class BookValidator implements Validator {

    @Autowired
    private CatalogBooksService catalogBooksService;

    @Override
    public boolean supports(Class<?> aClass) {
        return CatalogBooks.class.equals(aClass);
    }

    @Override
    public void validate(@NotBlank Object o, Errors errors) {

        CatalogBooks catalogBooks = (CatalogBooks) o;
//        if (catalogBooksService.getCatalogBookByInvNum(catalogBooks.getInvNum()) != null){
        if (catalogBooksService.getCatalogBookByInvNum(catalogBooks.getInvNum()) != null){
            errors.rejectValue("invNum","","Книга с таким инвентарным номером уже существует!");
        }
    }
}
