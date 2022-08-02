package ru.x3m.rem.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.x3m.rem.entity.Outlay;

import java.util.List;

@Repository
public interface OutlayRepo extends CrudRepository<Outlay, Long> {

    Outlay findByOutlayId(Long id);

    List<Outlay> findAllByItemsItemId(Long id);

    List<Outlay> findAllBySubitemsSubitemId(Long id);

}
