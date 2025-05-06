package se.lexicon.marketplace_api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.marketplace_api.entity.Advertisement;

@Repository
public interface AdvertisementRepository extends CrudRepository<Advertisement, Integer> {
    // This interface will automatically provide CRUD operations for the Advertisement entity
}
