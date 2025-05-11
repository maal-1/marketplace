package se.lexicon.marketplace_api.service.impl;

import org.springframework.stereotype.Service;
import se.lexicon.marketplace_api.dto.AdvertisementDto;
import se.lexicon.marketplace_api.dto.UserDto;
import se.lexicon.marketplace_api.entity.Advertisement;
import se.lexicon.marketplace_api.entity.User;
import se.lexicon.marketplace_api.repository.AdvertisementRepository;
import se.lexicon.marketplace_api.repository.UserRepository;
import se.lexicon.marketplace_api.service.UserService;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
     private AdvertisementRepository advertisementRepository;
     private UserRepository userRepository;

     public UserServiceImpl(AdvertisementRepository advertisementRepository, UserRepository userRepository) {
         this.advertisementRepository = advertisementRepository;
         this.userRepository = userRepository;
     }

    @Override
    public void createAdvertisement(AdvertisementDto advertisementDto, UserDto userDto) {
        Optional<User> retrievedUser = userRepository.findByEmail(userDto.email());

        retrievedUser.ifPresentOrElse(
                //check if user is present
                user -> {
                    if(user.getPassword().equals(userDto.password())){
                        saveAd(user, advertisementDto);
                    } else {
                        //todo: return 401 Unauthorized
                        throw new IllegalArgumentException("Password is invalid");
                    }

                },
                //if user is not present, create new user
                () -> {
                    User user = userRepository.save(new User(userDto.email(), userDto.password()));
                    saveAd(user, advertisementDto);
                }
        );
    }

    @Override
    public List<AdvertisementDto> findAdvertisementByUser(UserDto userDto) {
        Optional<User> retrievedUser = userRepository.findByEmail(userDto.email());

        if(retrievedUser.isPresent() & retrievedUser.get().getPassword().equals(userDto.password())) {
            return advertisementRepository.findByUser_id(retrievedUser.get().getId())
                    .stream()
                    .map(ad -> new AdvertisementDto(
                            ad.getId(),
                            ad.getTitle(),
                            ad.getDescription(),
                            ad.getExpirationDate()))
                    .toList();
        } else {
            //todo: return 401 Unauthorized
            throw new IllegalArgumentException("Password is invalid");
        }
    }


    private void saveAd(User userRepository, AdvertisementDto advertisementDto) {
        advertisementRepository.save(
                new Advertisement(
                        userRepository,
                        advertisementDto.title(), advertisementDto.description(),
                        advertisementDto.expirationDate()));
    }
}
