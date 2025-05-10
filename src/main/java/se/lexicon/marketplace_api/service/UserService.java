package se.lexicon.marketplace_api.service;

import se.lexicon.marketplace_api.dto.AdvertisementDto;
import se.lexicon.marketplace_api.dto.UserDto;

public interface UserService {

    public void createAdvertisement(AdvertisementDto advertisementDto, UserDto userDto);
}
