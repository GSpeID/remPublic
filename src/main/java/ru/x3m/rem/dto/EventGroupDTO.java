package ru.x3m.rem.dto;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class EventGroupDTO {
    private  Long groupId;
    private  String groupName;
}
