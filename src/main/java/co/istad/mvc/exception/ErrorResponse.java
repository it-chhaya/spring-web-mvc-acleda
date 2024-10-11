package co.istad.mvc.exception;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ErrorResponse<T>(
        Integer code,
        String message,
        LocalDateTime requestedTime,
        T reason
) {
}
