package ru.x3m.rem.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.x3m.rem.entity.RepairStatus;

@Repository
public interface RepairStatusRepo extends CrudRepository<RepairStatus, Long> {

    RepairStatus findByStatusId(Long id);

    boolean existsByStatusName(String statusName);

}
