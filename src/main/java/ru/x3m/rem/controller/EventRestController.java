package ru.x3m.rem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.x3m.rem.dto.EventDTO;
import ru.x3m.rem.service.EventService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/events/api")
public class EventRestController {

    private final EventService eventService;

    @Autowired
    public EventRestController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/findAllEvents")
//    @JsonView(EventDTO.TestFull.class)
    public List<EventDTO> getEvents(){
        return eventService.findAllEvents();
    }

    @GetMapping("/findEventById/{id}")
    public EventDTO findEvent(@PathVariable("id") Long id) {
        return eventService.findEventById(id);
    }

    @PostMapping("/findInDateRange")
    public List<EventDTO> findInDateRange(@RequestParam("start") String start, @RequestParam("end") String end) {
        return eventService.findEventsInDateRange(start, end);

    }

    @PostMapping("/saveEvent")
    @ResponseStatus(HttpStatus.CREATED)
    public EventDTO createEvent(@RequestBody @Valid EventDTO eventDTO, BindingResult result) {
        return eventService.saveEventRest(eventDTO);
    }

    @DeleteMapping("/deleteEvent/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EventDTO deleteEvent(@PathVariable("id") Long id) {
        eventService.deleteEvent(id);
        return null;
    }

}
