package by.yarom.library.validator;

import by.yarom.library.Entity.Reader;
import by.yarom.library.Service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component ("readerValidator")
public class ReaderValidator implements Validator {

    @Autowired
    private ReaderService readerService;

    @Override
    public boolean supports(Class<?> aClass) {
        return Reader.class.equals(aClass);
    }

    @Override
    public void validate(@Nullable Object o, Errors errors) {
        Reader reader = (Reader) o;
        if ((readerService.getReaderByFirsName(reader.getFirstName()) != null)
                &&(readerService.getReaderByLastName(reader.getLastName()) != null)
                &&(readerService.getReaderByMiddleName(reader.getMiddleName()) != null)){
            errors.rejectValue("firstName","","Такой читатель уже существует!");
            errors.rejectValue("lastName","","Такой читатель уже существует!");
            errors.rejectValue("middleName","","Такой читатель уже существует!");
        }

    }
}
