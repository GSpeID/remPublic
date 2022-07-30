package ru.x3m.rem.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "events")
@Getter
@Setter
@NoArgsConstructor
public class Event {

    @Column(name = "event_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "start_date")
    private String start;

    @Column(name = "end_date")
    private String end;

    @Column(name = "all_day")
    private Boolean allDay;

    @Column(name = "group_id")
    private Long groupId;

    @Column(name = "background_color")
    private String backgroundColor;

    @ManyToOne
    @JoinColumn(name = "group_id", insertable = false, updatable = false)
    private EventGroup eventGroup;

}
