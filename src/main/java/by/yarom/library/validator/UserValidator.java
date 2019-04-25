package by.yarom.library.validator;

import by.yarom.library.Entity.Users;
import by.yarom.library.Service.UsersService;
import by.yarom.library.Service.impl.UsersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;




@Component("userValidator")
public class UserValidator implements Validator {

    @Autowired
    private UsersService usersService;

    @Override
    public boolean supports(Class<?> aClass) {
        return Users.class.equals(aClass);
    }

    @Override
    public void validate(@Nullable Object o, Errors errors) {
        Users users = (Users) o;
        if (usersService.getUserByLogin(users.getLogin()) != null){
            errors.rejectValue("login","","Этот логин уже используется!");
        }

        if (usersService.getUserByEmail(users.getEmail()) != null){
            errors.rejectValue("email","","Этот email уже используется!");
        }

    }

//    @Override
//    public void validate(Object target,Errors errors) {
//        Users users = (Users) target;
//        if (usersService.getUserByLogin(users.getName()) !=null){
//            errors.rejectValue("name","","This name is already!");
//        }
//
//    }
}
