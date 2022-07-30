package ru.x3m.rem.dto;

import lombok.*;
import org.springframework.validation.annotation.Validated;
import ru.x3m.rem.entity.Event;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Validated
public class EventDTO {

    private  Long id;
    @NotNull(message = "Необходимо заполнить")
    private  String title;
    private  String start;
    private  String end;
    @NotNull(message = "Необходимо выбрать")
    private  Boolean allDay;
    @NotNull(message = "Необходимо выбрать")
    private  Long groupId;

    public EventDTO(Event event) {
        this.id = event.getId();
        this.title = event.getTitle();
        this.start = event.getStart();
        this.end = event.getEnd();
        this.allDay = event.getAllDay();
//        this.groupId = event.getGroupId();
    }
}
