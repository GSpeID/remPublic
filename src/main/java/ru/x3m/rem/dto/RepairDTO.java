package ru.x3m.rem.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@NoArgsConstructor
@Getter
@Setter
public class RepairDTO {


    private Long repairId;

    @NotEmpty
    private String repairAddress;

    @NotEmpty
    private String repairDescription;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate repairDate;

    @NotNull
    private Float fullCost;

    @NotNull
    private Float paid;

    @NotNull
    private Float outlay;

    @NotNull
    private Float arrears;

    @NotNull
    private Float profit;

    private Boolean cash;

    private Long clientId;
    private String clientName;
    private Long deviceId;
    private String deviceName;
    private Long repairTypeId;
    private String repairTypeName;
    private Long clientTypeId;
    private String clientTypeName;
    private Long statusId;
    private String statusName;

    public float calcArrears(){
        arrears=fullCost-paid;
        return arrears;
    }

    public float calcProfit(){
        profit=fullCost-outlay;
        return profit;
    }

}
