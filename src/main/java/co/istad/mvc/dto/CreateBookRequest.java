package co.istad.mvc.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateBookRequest(

        @NotBlank
        @Size(min = 5, max = 255)
        String title,

        String description,

        @NotBlank
        @Size(max = 150)
        String thumbnail
) {
}
