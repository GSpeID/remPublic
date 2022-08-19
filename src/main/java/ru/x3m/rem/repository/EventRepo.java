package ru.x3m.rem.repository;

import org.springframework.data.repository.CrudRepository;
import ru.x3m.rem.entity.Event;

import java.util.List;

public interface EventRepo extends CrudRepository<Event, Long> {
    Event findEventById(Long id);

    List<Event> findAllByStartAfterAndEndBefore(String start, String end);

}

