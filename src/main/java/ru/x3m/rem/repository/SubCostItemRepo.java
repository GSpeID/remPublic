package ru.x3m.rem.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.x3m.rem.entity.SubCostItem;

@Repository
public interface SubCostItemRepo extends CrudRepository<SubCostItem, Long> {
}
