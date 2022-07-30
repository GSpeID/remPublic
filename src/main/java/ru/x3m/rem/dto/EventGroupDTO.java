package ru.x3m.rem.dto;

import lombok.*;
import ru.x3m.rem.entity.EventGroup;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class EventGroupDTO {
    private  Long groupId;
    private  String groupName;
    private String backgroundColor;

    public EventGroupDTO(EventGroup eventGroup) {
        this.groupId = eventGroup.getGroupId();
        this.groupName = eventGroup.getGroupName();
        this.backgroundColor = eventGroup.getBackgroundColor();
    }
}
