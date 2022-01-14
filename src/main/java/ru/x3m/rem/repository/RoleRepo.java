package ru.x3m.rem.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.x3m.rem.entity.Role;
import ru.x3m.rem.entity.User;

import java.util.Optional;

@Repository
public interface RoleRepo extends CrudRepository<Role, Long> {

}
