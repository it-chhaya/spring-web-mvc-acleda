package co.istad.mvc.dto;

public record CreateBookRequest(
        String title,
        String description,
        String thumbnail
) {
}
