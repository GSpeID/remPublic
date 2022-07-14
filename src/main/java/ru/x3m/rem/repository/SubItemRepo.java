package ru.x3m.rem.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.x3m.rem.entity.SubItem;

import java.util.List;

@Repository
public interface SubItemRepo extends CrudRepository<SubItem, Long> {

    List<SubItem> findAllByItemsItemId(Long itemsItemId);

}
