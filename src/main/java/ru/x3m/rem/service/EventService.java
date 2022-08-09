package ru.x3m.rem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.x3m.rem.dto.EventDTO;
import ru.x3m.rem.dto.EventGroupDTO;
import ru.x3m.rem.entity.Event;
import ru.x3m.rem.entity.EventGroup;
import ru.x3m.rem.repository.EventGroupRepo;
import ru.x3m.rem.repository.EventRepo;
import ru.x3m.rem.utils.ObjectMapperUtils;

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
    public List<EventDTO> findAllEvents() {
        List<Event> events = (List<Event>) eventRepo.findAll();
        return ObjectMapperUtils.mapAll(events, EventDTO.class);
    }

    public EventDTO findEventById(Long id) {
        Event event = eventRepo.findEventById(id);
        return ObjectMapperUtils.map(event, EventDTO.class);
    }

    public EventDTO saveEventRest(EventDTO eventDTO) {
        Event event = ObjectMapperUtils.map(eventDTO, Event.class);
        eventRepo.save(event);
        return eventDTO;
    }

    public void deleteEvent(Long id) {
        eventRepo.findById(id)
                .ifPresent(eventRepo::delete);
    }


    public List<EventDTO> findEventsInDateRange(String start, String end) {
        List<Event> events = eventRepo.findAllByStartAfterAndEndBefore(start, end);
        return ObjectMapperUtils.mapAll(events, EventDTO.class);
    }

    //--Groups
    public List<EventGroupDTO> findAllGroups() {
        List<EventGroup> eventGroups = (List<EventGroup>) eventGroupRepo.findAll();
        return ObjectMapperUtils.mapAll(eventGroups, EventGroupDTO.class);
    }

    public EventGroup findGroupById(Long id) {
        return eventGroupRepo.findByGroupId(id);
    }

}
