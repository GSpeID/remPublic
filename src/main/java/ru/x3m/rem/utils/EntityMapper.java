package ru.x3m.rem.utils;

import org.modelmapper.ModelMapper;
import ru.x3m.rem.dto.EventDTO;
import ru.x3m.rem.entity.Event;


public class EntityMapper {

    private final ModelMapper modelMapper;

    public EntityMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    //--- entity to DTO
    public EventDTO convertToDto(Event event) {
        return modelMapper.map(event, EventDTO.class);
    }

    //--- DTO to entity
    public Event convertToEntity(EventDTO eventDTO) {
        return modelMapper.map(eventDTO, Event.class);
    }

}
