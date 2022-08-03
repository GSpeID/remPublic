package ru.x3m.rem.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.x3m.rem.dto.EventDTO;
import ru.x3m.rem.entity.Event;
import ru.x3m.rem.service.EventService;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/events/api")
public class EventRestController {

    private final ModelMapper modelMapper;
    private final EventService eventService;

    @Autowired
    public EventRestController(ModelMapper modelMapper, EventService eventService) {
        this.modelMapper = modelMapper;
        this.eventService = eventService;
    }

    @GetMapping("/findAllEvents")
    @ResponseBody
//    @JsonView(EventDTO.TestFull.class)
    public List<EventDTO> getEvents(){
        List<Event> events = eventService.findAllEvents();
        return events.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/findEventById/{id}")
    @ResponseBody
    public EventDTO findEvent(@PathVariable("id") Long id) {
        return convertToDto(eventService.findEventById(id));
    }

    @PostMapping("/findInDateRange")
    @ResponseBody
    public List<EventDTO> findInDateRange(@RequestParam("start") String start, @RequestParam("end") String end) {
        List<Event> events = eventService.findEventsInDateRange(start, end);
        return events.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/saveEvent")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public EventDTO createEvent(@RequestBody @Valid EventDTO eventDTO, BindingResult result) throws ParseException {
        Event event = convertToEntity(eventDTO);
        Event eventCreated = eventService.saveEventRest(event);
        return convertToDto(eventCreated);
    }

    @DeleteMapping("/deleteEvent/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public EventDTO deleteEvent(@PathVariable("id") Long id) {
        eventService.deleteEvent(id);
        return null;
    }

    //--- entity to DTO
    private EventDTO convertToDto(Event event) {
        return modelMapper.map(event, EventDTO.class);
    }

    //--- DTO to entity
    private Event convertToEntity(EventDTO eventDTO) throws ParseException {
        return modelMapper.map(eventDTO, Event.class);
    }

}
