package ru.x3m.rem.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.x3m.rem.entity.Item;

@Repository
public interface ItemRepo extends CrudRepository<Item, Long> {
    Item findByItemId(Long id);
}
