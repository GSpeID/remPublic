package ru.x3m.rem.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.validation.annotation.Validated;


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

}
