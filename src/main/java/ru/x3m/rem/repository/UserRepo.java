package ru.x3m.rem.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.x3m.rem.entity.User;

import java.util.Optional;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {

    boolean existsUserByUsername(String username);

    Optional<User>getUserByUsername(String username);
}
