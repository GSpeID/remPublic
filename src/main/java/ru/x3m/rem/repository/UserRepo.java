package ru.x3m.rem.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.x3m.rem.entity.User;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {

    boolean existsUserByUsername(String user_name);

    User getUserByUsername(String user_name);
}
