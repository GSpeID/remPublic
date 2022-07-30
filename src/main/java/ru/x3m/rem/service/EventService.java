package ru.x3m.rem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.x3m.rem.dto.EventDTO;
import ru.x3m.rem.dto.EventGroupDTO;
import ru.x3m.rem.entity.Event;
import ru.x3m.rem.entity.EventGroup;
import ru.x3m.rem.repository.EventGroupRepo;
import ru.x3m.rem.repository.EventRepo;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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

    public Optional<EventDTO> findEventById(Long id){
        return eventRepo.findById(id)
                .map(EventDTO::new);
    }

    public void saveEvent(EventDTO eventDTO){
        Event event = new Event();
        event.setId(eventDTO.getId());
        event.setTitle(eventDTO.getTitle());
        event.setStart(eventDTO.getStart());
        event.setEnd(eventDTO.getEnd());
        event.setAllDay(eventDTO.getAllDay());
        event.setGroupId(eventDTO.getGroupId());
        eventRepo.save(event);
    }

    public Event saveEventRest(Event event){
        event.setId(event.getId());
        event.setTitle(event.getTitle());
        event.setStart(event.getStart());
        event.setEnd(event.getEnd());
        event.setAllDay(event.getAllDay());
        event.setGroupId(event.getGroupId());
        eventRepo.save(event);
        return event;
    }

    public void deleteEvent(Long id){
        eventRepo.findById(id)
                .ifPresent(eventRepo::delete);
    }

    //--Groups
    public List<EventGroup> findAllGroups(){
        return (List<EventGroup>) eventGroupRepo.findAll();
    }

    public Optional<EventGroupDTO> findGroupById(Long id){
        return eventGroupRepo.findById(id)
                .map(EventGroupDTO::new);
    }

}
