package se.lexicon.marketplace_api.service;

import se.lexicon.marketplace_api.dto.AdvertisementDto;

import java.util.List;

public interface AdvertisementService {
    List<AdvertisementDto> findAll();
}
