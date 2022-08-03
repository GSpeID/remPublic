package ru.x3m.rem.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.x3m.rem.entity.EventGroup;

@NoArgsConstructor
@Getter
@Setter
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
