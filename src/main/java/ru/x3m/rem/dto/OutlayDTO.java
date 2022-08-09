package ru.x3m.rem.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public class OutlayDTO {

    private Long outlayId;
    @Valid
    @NotNull
    @Size(min = 3, max = 250, message = "DTO минимум 3 символа")
    private  String  description;

    @Valid
    @NotNull(message = "Укажите потраченную суммму")
    @DecimalMin(value = "0.01", message = "Минимум 1 копейка: 0.01")
    @Digits(integer = 10, fraction = 2, message = "Формат 0.00 , целых {integer} и дробных {fraction} цифр")
    private Double price;

    @Valid
    @NotNull(message = "Укажите дату")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @NotNull(message = "Выберите подстатю")
    private Long subitemsSubitemId;

    @NotNull(message = "Выберите статью")
    private Long itemsItemId;

    private String subitemName;

    private String itemName;

}
