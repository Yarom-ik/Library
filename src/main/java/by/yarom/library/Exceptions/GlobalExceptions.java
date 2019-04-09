package by.yarom.library.Exceptions;

import org.apache.log4j.Logger;
import org.hibernate.exception.JDBCConnectionException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.ParseException;

@ControllerAdvice
public class GlobalExceptions extends Exception {

    final static Logger logger = Logger.getLogger(GlobalExceptions.class);

    @ExceptionHandler(JDBCConnectionException.class)
    public String handleError(JDBCConnectionException e, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("message", "Ошибка подключения к базе данных " + e.getMessage());
        return "redirect:/error";
    }

    @ExceptionHandler(ParseException.class)
    public String handleError(ParseException e, RedirectAttributes redirectAttributes) {
        logger.error("Ошибка преобразования даты " + e.getMessage());
        redirectAttributes.addFlashAttribute("message", "Ошибка преобразования даты " + e.getMessage());
        return "redirect:/error";
    }

    @ExceptionHandler(NullPointerException.class)
    public String handleError(NullPointerException e, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("message", "Запись не найдена " + e.getMessage());
        return "redirect:/error";
    }
}
