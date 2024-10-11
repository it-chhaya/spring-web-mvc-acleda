package co.istad.mvc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Map;

@RestControllerAdvice
public class WebException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse<?> handleValidationException(MethodArgumentNotValidException e) {
        return ErrorResponse.builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .message(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .requestedTime(LocalDateTime.now())
                .reason("Validation Error")
                .build();
    }

    @ExceptionHandler(RuntimeException.class)
    public Map<String, String> handleRuntimeEx(RuntimeException e) {
        return Map.of("message", e.getMessage());
    }

}
