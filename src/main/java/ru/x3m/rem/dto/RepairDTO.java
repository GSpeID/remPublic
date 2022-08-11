package ru.x3m.rem.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;


@NoArgsConstructor

public class RepairDTO {

    @Getter
    @Setter
    private Long repairId;

    @Getter
    @Setter
    @Valid
    @NotEmpty(message = "Укажите адрес")
    @Size(min = 3, max = 255, message = "Минимум min{min}, максимум max{max} символов")
    private String repairAddress;

    @Getter
    @Setter
    @Valid
    @NotEmpty(message = "Укажите адрес")
    @Size(min = 3, max = 255, message = "Минимум min{min}, максимум max{max} символов")
    private String repairDescription;

    @Getter
    @Setter
    @Valid
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate repairDate;

    @Getter
    @Setter
    @Valid
    @NotNull(message = "укажите суммму(или 0)")
    @DecimalMin(value = "0", message = "точночть 1 копейка: 0.01")
    @Digits(integer = 10, fraction = 2)
//    @Positive(message = "не может быть отрицательным")
    private Double fullCost;

    @Getter
    @Setter
    @Valid
    @NotNull(message = "укажите суммму(или 0)")
    @DecimalMin(value = "0", message = "точночть 1 копейка: 0.01")
    @Digits(integer = 10, fraction = 2)
//    @Positive(message = "не может быть отрицательным")
    private Double paid;

    @Getter
    @Setter
    @Valid
    @NotNull(message = "укажите суммму(или 0)")
    @DecimalMin(value = "0", message = "точночть 1 копейка: 0.01")
    @Digits(integer = 10, fraction = 2)
//    @Positive(message = "не может быть отрицательным")
    private Double outlay;

    @Getter
    private Double arrears;

    @Getter
    private Double profit;

    @Getter
    @Setter
    @NotNull(message = "Выберите способ расчёта")
    private Boolean cash;

    @Getter
    @Setter
    @Valid
    @NotNull(message = "необходимо выбрать из списка")
    private Long clientId;

    @Getter
    @Setter
    private String clientName;

    @Getter
    @Setter
    private String clientPhone;

    @Getter
    @Setter
    @Valid
    @NotNull(message = "необходимо выбрать из списка")
    private Long deviceId;

    @Getter
    @Setter
    private String deviceName;

    @Getter
    @Setter
    @Valid
    @NotNull(message = "необходимо выбрать из списка")
    private Long repairTypeId;

    @Getter
    @Setter
    private String repairTypeName;

    @Getter
    @Setter
    private Long clientTypeId;

    @Getter
    @Setter
    private String clientTypeName;

    @Getter
    @Setter
    @Valid
    @NotNull(message = "необходимо выбрать из списка")
    private Long statusId;

    @Getter
    @Setter
    private String statusName;

//    public Double calcArrears() {
//        arrears = fullCost - paid;
//        return arrears;
//    }
//
//    public Double calcProfit() {
//        profit = fullCost - outlay;
//        return profit;
//    }

    public void setArrears() {
        this.arrears = fullCost - paid;
    }

    public void setProfit() {
        this.profit = fullCost - outlay;
    }
}
