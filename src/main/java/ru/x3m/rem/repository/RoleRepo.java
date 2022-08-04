package ru.x3m.rem.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.x3m.rem.entity.Role;


@Repository
public interface RoleRepo extends CrudRepository<Role, Long> {

    Role findByRoleId(Long id);

}
