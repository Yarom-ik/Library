package by.yarom.library.Exceptions;

import org.hibernate.exception.JDBCConnectionException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class GlobalExceptions extends Exception {

    @ExceptionHandler(JDBCConnectionException.class)
    public String handleError(JDBCConnectionException e, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("message", "Ошибка подключения к базе данных " + e.getMessage());
        return "redirect:/error";
    }
}
