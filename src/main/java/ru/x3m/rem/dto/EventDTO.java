package ru.x3m.rem.dto;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class EventDTO {
    private  Long id;
    private  String title;
    private  String start;
    private  String end;
    private  Boolean allDay;
    private  Long groupId;
}
