package se.lexicon.marketplace_api.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import se.lexicon.marketplace_api.dto.AdvertisementDto;
import se.lexicon.marketplace_api.service.AdvertisementService;

import java.util.List;

@RestController
public class AdvertisementContoller {

    private AdvertisementService advertisementService;

    public AdvertisementContoller(AdvertisementService advertisementService) {
        this.advertisementService = advertisementService;
    }

    @GetMapping("/advertisements")
    public List<AdvertisementDto> findAll() {
        return advertisementService.findAll();
    }
}
