package ru.x3m.rem.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import ru.x3m.rem.entity.*;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Getter
@Setter
public class OutlayDTO {

    private Long outlayId;
    @Valid
    @NotNull
    @Size(min = 3, max = 250, message = "DTO минимум 3 символа")
    private  String  description;

    @Valid
    @NotNull(message = "DTO укажите потраченную суммму")
    @DecimalMin(value = "0.01", message = "DTO минимум 1 копейка: 0.01")
    @Digits(integer = 10, fraction = 2, message = "DTO формат 0.00 , целых {integer} и дробных {fraction} цифр")
    private Double price;

    @Valid
    @NotNull(message = "DTO укажите дату")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @NotNull(message = "DTO выберите подстатю")
    private Long subitemsSubitemId;

    @NotNull(message = "DTO выберите статью")
    private Long itemsItemId;

    private String subitemName;

    private String itemName;


    public OutlayDTO() {
    }

    public OutlayDTO(Long outlayId, String description, Double price,
                     LocalDate date, Long subitemsSubitemId, Long itemsItemId,
                     String subitemName, String itemName) {
        this.outlayId = outlayId;
        this.description = description;
        this.price = price;
        this.date = date;
        this.subitemsSubitemId = subitemsSubitemId;
        this.itemsItemId = itemsItemId;
        this.subitemName = subitemName;
        this.itemName = itemName;
    }

    public OutlayDTO(Outlay outlay) {
        this.outlayId = outlay.getOutlayId();
        this.description = outlay.getDescription();
        this.price = outlay.getPrice();
        this.date = outlay.getDate();
        this.subitemsSubitemId = outlay.getSubitemsSubitemId();
        this.itemsItemId = outlay.getItemsItemId();
        this.subitemName = outlay.getSubItem().getSubitemName();
        this.itemName = outlay.getItem().getItemName();
    }

}
