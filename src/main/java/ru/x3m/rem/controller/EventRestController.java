package ru.x3m.rem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.x3m.rem.dto.EventDTO;
import ru.x3m.rem.dto.EventGroupDTO;
import ru.x3m.rem.entity.Event;
import ru.x3m.rem.entity.EventGroup;
import ru.x3m.rem.service.EventService;

import java.util.List;

@RestController
public class EventRestController {

    private final EventService eventService;

    @Autowired
    public EventRestController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping(value = "/events")
    public String eventPage(Model model){
        List<Event> eventList = eventService.findAllEvents();
        model.addAttribute("eventList", eventList);
        List<EventGroup> eventGroupList = eventService.findAllGroups();
        model.addAttribute("groupList", eventGroupList);
        model.addAttribute("eventDTO", new EventDTO());
        model.addAttribute("groupDTO", new EventGroupDTO());
        return "event";
    }
}
