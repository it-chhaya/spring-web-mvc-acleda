package co.istad.mvc.exception;

import lombok.Builder;

@Builder
public record ValidationResponse(
        String field,
        String description
) {
}
