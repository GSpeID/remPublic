package ru.x3m.rem.entity;


import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Table(name = "outlays", schema = "rem_db")
@Data
public class Outlay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long outlayId;

    @Valid
    @NotNull(message = "необходимо заполнить поле")
    @Size(min = 3, max = 250, message = "минимум 3 символа")
    private String description;

    @Valid
    @NotNull(message = "укажите потраченную суммму")
    @DecimalMin(value = "0.01", message = "минимум 1 копейка: 0.01")
    @Digits(integer = 10, fraction = 2)
    @Positive(message = "не может быть отрицательным")
    private Double price;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "items_item_id", insertable = false, updatable = false)
    private Item item;

    @ManyToOne
    @JoinColumn(name = "subitems_subitem_id", insertable = false, updatable = false)
    private SubItem subItem;

    @Valid
    @NotNull(message = "Выберите статью расходов")
    @Column(name = "items_item_id")
    private Long itemsItemId;

    @Valid
    @NotNull(message = "Выберите подстатью расходов")
    @Column(name = "subitems_subitem_id")
    private Long subitemsSubitemId;

}
