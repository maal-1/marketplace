package se.lexicon.marketplace_api.controller;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import se.lexicon.marketplace_api.dto.AdvertisementDto;
import se.lexicon.marketplace_api.dto.UserDto;
import se.lexicon.marketplace_api.service.UserService;

@RestController
public class UserController {
    // Injecting UserService to handle business logic
    private final UserService userService;
    // Constructor injection for UserService
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/api/ads")
    @ResponseStatus(HttpStatus.CREATED)
    public void CreateAdvertisement(@RequestBody AdvertisementDto advertisementDto,
                                    @RequestParam String email,
                                    @RequestParam String password){
        userService.createAdvertisement(advertisementDto, new UserDto(email, password));

    }

}
