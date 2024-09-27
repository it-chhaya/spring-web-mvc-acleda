package co.istad.mvc.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class WebException {

    @ExceptionHandler(RuntimeException.class)
    public Map<String, String> handleRuntimeEx(RuntimeException e) {
        return Map.of("message", e.getMessage());
    }

}
