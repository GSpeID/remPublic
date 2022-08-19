package ru.x3m.rem.repository;

import org.springframework.data.repository.CrudRepository;
import ru.x3m.rem.entity.EventGroup;

public interface EventGroupRepo extends CrudRepository<EventGroup, Long> {
    EventGroup findByGroupId(Long id);
}


