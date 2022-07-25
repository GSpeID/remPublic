package ru.x3m.rem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.x3m.rem.entity.Event;
import ru.x3m.rem.entity.EventGroup;
import ru.x3m.rem.repository.EventGroupRepo;
import ru.x3m.rem.repository.EventRepo;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EventService {

    private final EventRepo eventRepo;
    private final EventGroupRepo eventGroupRepo;

    @Autowired
    public EventService(EventRepo eventRepo, EventGroupRepo eventGroupRepo) {
        this.eventRepo = eventRepo;
        this.eventGroupRepo = eventGroupRepo;
    }

    //--- Events
    public List<Event> findAllEvents(){
        return (List<Event>) eventRepo.findAll();
    }

    //--Groups
    public List<EventGroup> findAllGroups(){
        return (List<EventGroup>) eventGroupRepo.findAll();
    }

}
