package se.lexicon.marketplace_api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.marketplace_api.entity.Advertisement;

import java.util.List;

@Repository
public interface AdvertisementRepository extends CrudRepository<Advertisement, Integer> {
    // This interface will automatically provide CRUD operations for the Advertisement entity
    @Override
    List<Advertisement> findAll();
    List<Advertisement> findByUser_id(int userId);

}
