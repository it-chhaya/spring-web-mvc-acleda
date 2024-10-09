package co.istad.mvc.dto;

import lombok.Builder;

@Builder
public record BookResponse(
        String code,
        String title,
        String description,
        String thumbnail,
        Boolean status
) {
}
