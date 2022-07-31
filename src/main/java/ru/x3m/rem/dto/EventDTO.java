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
    private  String title;
    private  String start;
    private  String end;
    private  Boolean allDay;
    private  Long groupId;
    private String backgroundColor;

    private String url;

    public EventDTO(Event event) {
        this.id = event.getId();
        this.title = event.getTitle();
        this.start = event.getStart();
        this.end = event.getEnd();
        this.allDay = event.getAllDay();
        this.groupId = event.getGroupId();
        this.backgroundColor = event.getBackgroundColor();
        this.url = event.getUrl();
    }
}
