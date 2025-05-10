package se.lexicon.marketplace_api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.marketplace_api.entity.User;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    // This interface will automatically provide CRUD operations for the User entity
    Optional<User> findByEmail(String email);
}
