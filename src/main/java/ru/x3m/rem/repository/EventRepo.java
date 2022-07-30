package ru.x3m.rem.repository;

import org.springframework.data.repository.CrudRepository;
import ru.x3m.rem.entity.Event;

public interface EventRepo extends CrudRepository<Event, Long> {
    public Event findEventById(Long id);
}