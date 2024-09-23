package co.istad.mvc.dto;

public record BookResponse(
        String code,
        String title,
        String description,
        String thumbnail,
        Boolean status
) {
}
