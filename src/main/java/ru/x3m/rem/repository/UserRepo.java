package ru.x3m.rem.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.x3m.rem.entity.User;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {


    boolean existsByUsername(String username);

    User findByUsername(String username);

    User findByUserId(Long id);
}
