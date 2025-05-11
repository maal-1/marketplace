package se.lexicon.marketplace_api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserDto(@Email(message = "Invalid email format")
                      @NotBlank(message = "email must not be blank.")
                      @Size(min=5, max = 75, message = "email must be between 5 and 75 characters")
                      String email,
                      @NotBlank(message = "Password must not be blank.")
                      @Size(min=5, max = 100, message = "Password must be between 5 and 100 characters")
                      String password) {

}
