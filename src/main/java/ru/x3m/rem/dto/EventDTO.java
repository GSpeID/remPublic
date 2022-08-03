package ru.x3m.rem.dto;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
public class EventDTO {

    public interface TestFull {
    }

    public interface TestCut {
    }

    @JsonView({TestFull.class})
    private Long id;

    @JsonView({TestFull.class, TestCut.class})

    private String title;

    @JsonView({TestFull.class})
    private String start;

    @JsonView({TestFull.class})
    private String end;

    @JsonView({TestFull.class})
    private Boolean allDay;

    @JsonView({TestFull.class})
    private Long groupId;

    private String groupName;

    @JsonView({TestFull.class})
    private String backgroundColor;

    @JsonView({TestFull.class})
    private String url;


}
