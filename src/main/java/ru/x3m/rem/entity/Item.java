package ru.x3m.rem.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "items", schema = "rem_db")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;

    @Valid
    @NotNull(message = "не может быть пустым")
    @Size(min = 2, max = 16, message = "Название минимум {min}, максимум {max} символов")
    private String itemName;

    @OneToMany(
            mappedBy = "item",
            cascade = CascadeType.ALL
    )
    private List<SubItem> subItems;

    @OneToMany(
            mappedBy = "subItem",
            cascade = CascadeType.ALL
    )
    private List<Outlay> outlays;

}
