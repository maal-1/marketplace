package se.lexicon.marketplace_api.controller;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import se.lexicon.marketplace_api.dto.AdvertisementDto;
import se.lexicon.marketplace_api.service.AdvertisementService;

import java.util.List;

@RestController
public class AdvertisementController {

    private AdvertisementService advertisementService;

    public AdvertisementController(AdvertisementService advertisementService) {
        this.advertisementService = advertisementService;
    }

    @GetMapping("/api/ads")
    @ResponseStatus(HttpStatus.OK)
    public List<AdvertisementDto> findAll() {
        return advertisementService.findAll();
    }
}
