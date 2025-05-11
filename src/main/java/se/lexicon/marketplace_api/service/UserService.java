package se.lexicon.marketplace_api.service;

import se.lexicon.marketplace_api.dto.AdvertisementDto;
import se.lexicon.marketplace_api.dto.UserDto;

import java.util.List;

public interface UserService {

    void createAdvertisement(AdvertisementDto advertisementDto, UserDto userDto);
    List<AdvertisementDto> findAdvertisementByUser(UserDto userDto);
}
