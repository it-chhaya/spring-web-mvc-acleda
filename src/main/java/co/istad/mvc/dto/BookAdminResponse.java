package co.istad.mvc.dto;

public record BookAdminResponse(
        String code,
        String title,
        String description,
        String thumbnail,
        Boolean status
) {
}
