package ru.x3m.rem.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.x3m.rem.entity.RepairStatuses;

@Repository
public interface RepairStatusesRepo extends CrudRepository<RepairStatuses, Long> {
}
