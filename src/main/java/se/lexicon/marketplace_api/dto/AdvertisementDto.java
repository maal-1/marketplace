package se.lexicon.marketplace_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record AdvertisementDto(int id,
                               @NotBlank(message = "title must not be blank.")
                               @Size(min=1, max = 100, message = "title must be between 1 and 100 characters")
                               String title,
                               @NotBlank(message = "description must not be blank.")
                               @Size(min=5, message = "description must be at least 5 characters")
                               String description,
                               LocalDate expirationDate) {

}
