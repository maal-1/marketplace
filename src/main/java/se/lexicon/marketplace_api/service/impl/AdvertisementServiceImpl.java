package se.lexicon.marketplace_api.service.impl;

import org.springframework.stereotype.Service;
import se.lexicon.marketplace_api.dto.AdvertisementDto;
import se.lexicon.marketplace_api.entity.Advertisement;
import se.lexicon.marketplace_api.repository.AdvertisementRepository;
import se.lexicon.marketplace_api.service.AdvertisementService;

import java.time.LocalDate;
import java.util.List;

@Service
public class AdvertisementServiceImpl implements AdvertisementService {

    private AdvertisementRepository advertisementRepository;

    public AdvertisementServiceImpl(AdvertisementRepository advertisementRepository) {
        this.advertisementRepository = advertisementRepository;
    }

    @Override
    public List<AdvertisementDto> findAll() {
        return advertisementRepository.findAll()
                .stream()
                .filter(advertisement -> advertisement.getExpirationDate().isAfter(LocalDate.now()))
                .map(advertisement -> new AdvertisementDto(
                        advertisement.getId(),
                        advertisement.getTitle(),
                        advertisement.getDescription(),
                        advertisement.getExpirationDate()))
                .toList();
    }

}
