package co.istad.mvc.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
public record UpdateBookRequest(
        @NotBlank
        @Size(min = 5, max = 255)
        String title,

        String description
) {
}
