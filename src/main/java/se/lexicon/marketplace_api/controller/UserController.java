package se.lexicon.marketplace_api.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import se.lexicon.marketplace_api.dto.AdvertisementDto;
import se.lexicon.marketplace_api.dto.UserDto;
import se.lexicon.marketplace_api.service.UserService;

import java.util.List;

@RestController
@Validated
public class UserController {
    // Injecting UserService to handle business logic
    private final UserService userService;
    // Constructor injection for UserService
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/api/ads")
    @ResponseStatus(HttpStatus.CREATED)
    public void CreateAdvertisement(
            @RequestBody @Valid AdvertisementDto advertisementDto,
            @RequestParam @Email String email,
            @RequestParam @NotBlank(message = "Password should not be blank.") String password) {
        userService.createAdvertisement(advertisementDto, new UserDto(email, password));

    }

    @PostMapping("/api/ads/my-ads")
    @ResponseStatus(HttpStatus.OK)
    public List<AdvertisementDto> findAdvertisementByUser(
            @RequestParam @Email String email,
            @RequestParam @NotBlank(message = "Password should not be blank.") String password) {

        return userService.findAdvertisementByUser(new UserDto(email, password));
    }

}
