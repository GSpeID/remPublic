package ru.x3m.rem.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.x3m.rem.dto.RepairDTO;
import ru.x3m.rem.entity.Repair;

import java.util.List;


@Repository
public interface RepairRepo extends CrudRepository<Repair, Long> {

}
