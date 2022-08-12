package ru.x3m.rem.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;


@NoArgsConstructor
@Getter
@Setter
public class RepairDTO {

    private Long repairId;

    @Valid
    @NotEmpty(message = "Укажите адрес")
    @Size(min = 3, max = 255, message = "Минимум min{min}, максимум max{max} символов")
    private String repairAddress;

    @Valid
    @NotEmpty(message = "Укажите адрес")
    @Size(min = 3, max = 255, message = "Минимум min{min}, максимум max{max} символов")
    private String repairDescription;

    @Valid
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate repairDate;

    @Valid
    @NotNull(message = "укажите суммму(или 0)")
    @DecimalMin(value = "0", message = "точночть 1 копейка: 0.01")
    @Digits(integer = 10, fraction = 2)
//    @Positive(message = "не может быть отрицательным")
    private Double fullCost;

    @Valid
    @NotNull(message = "укажите суммму(или 0)")
    @DecimalMin(value = "0", message = "точночть 1 копейка: 0.01")
    @Digits(integer = 10, fraction = 2)
//    @Positive(message = "не может быть отрицательным")
    private Double paid;

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

    @NotNull(message = "Выберите способ расчёта")
    private Boolean cash;

    @Valid
    @NotNull(message = "необходимо выбрать из списка")
    private Long clientId;

    private String clientName;

    private String clientPhone;

    @Valid
    @NotNull(message = "необходимо выбрать из списка")
    private Long deviceId;

    private String deviceName;

    @Valid
    @NotNull(message = "необходимо выбрать из списка")
    private Long repairTypeId;

    private String repairTypeName;

    private Long clientTypeId;

    private String clientTypeName;

    @Valid
    @NotNull(message = "необходимо выбрать из списка")
    private Long statusId;

    private String statusName;

    public Double calcArrears() {
        arrears = fullCost - paid;
        return arrears;
    }

    public Double calcProfit() {
        profit = fullCost - outlay;
        return profit;
    }

}
