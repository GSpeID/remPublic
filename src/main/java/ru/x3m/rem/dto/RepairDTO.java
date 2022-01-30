package ru.x3m.rem.dto;

import org.springframework.format.annotation.DateTimeFormat;
import ru.x3m.rem.entity.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class RepairDTO {


    private Long repair_id;

    @NotEmpty
    private String repair_address;

    @NotEmpty
    private String repair_description;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate repair_date;

    //----------------------------
    private Long client_id;
    private Long device_id;
    private Long repair_type_id;
    private Long status_id;
    private Long payment_id;
    private String client_name;
    private String device_name;
    private String client_type_name;
    private String repair_type_name;
    //---------------------------

    public RepairDTO() {
    }


    public RepairDTO(Long repair_id, @NotEmpty String repair_address,
                     @NotEmpty String repair_description,
                     @NotNull LocalDate repair_date, Long client_id,
                     Long device_id, Long repair_type_id, Long status_id,
                     Long payment_id, String client_name, String device_name,
                     String client_type_name, String repair_type_name) {
        this.repair_id = repair_id;
        this.repair_address = repair_address;
        this.repair_description = repair_description;
        this.repair_date = repair_date;
        this.client_id = client_id;
        this.device_id = device_id;
        this.repair_type_id = repair_type_id;
        this.status_id = status_id;
        this.payment_id = payment_id;
        this.client_name = client_name;
        this.device_name = device_name;
        this.client_type_name = client_type_name;
        this.repair_type_name = repair_type_name;
    }

    public RepairDTO(Repair repair) {
        this.repair_id = repair.getRepair_id();
        this.repair_address = repair.getRepair_address();
        this.repair_description = repair.getRepair_description();
        this.repair_date = repair.getRepair_date();
        this.client_id = repair.getClient_id();
        this.device_id = repair.getDevice_id();
        this.repair_type_id = repair.getRepair_type_id();
        this.status_id = repair.getStatus_id();
        this.payment_id = repair.getPayment_id();
        this.client_name = repair.getClient().getClient_name();
        this.device_name = repair.getDevice().getDevice_name();
        this.repair_type_name = repair.getRepairType().getRepair_type_name();
    }

    public Long getRepair_id() {
        return repair_id;
    }

    public void setRepair_id(Long repair_id) {
        this.repair_id = repair_id;
    }

    public String getRepair_address() {
        return repair_address;
    }

    public void setRepair_address(String repair_address) {
        this.repair_address = repair_address;
    }

    public String getRepair_description() {
        return repair_description;
    }

    public void setRepair_description(String repair_description) {
        this.repair_description = repair_description;
    }

    public LocalDate getRepair_date() {
        return repair_date;
    }

    public void setRepair_date(LocalDate repair_date) {
        this.repair_date = repair_date;
    }

    public Long getClient_id() {
        return client_id;
    }

    public void setClient_id(Long client_id) {
        this.client_id = client_id;
    }

    public Long getDevice_id() {
        return device_id;
    }

    public void setDevice_id(Long device_id) {
        this.device_id = device_id;
    }

    public Long getRepair_type_id() {
        return repair_type_id;
    }

    public void setRepair_type_id(Long repair_type_id) {
        this.repair_type_id = repair_type_id;
    }

    public Long getStatus_id() {
        return status_id;
    }

    public void setStatus_id(Long status_id) {
        this.status_id = status_id;
    }

    public Long getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(Long payment_id) {
        this.payment_id = payment_id;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public String getDevice_name() {
        return device_name;
    }

    public void setDevice_name(String device_name) {
        this.device_name = device_name;
    }

    public String getClient_type_name() {
        return client_type_name;
    }

    public void setClient_type_name(String client_type_name) {
        this.client_type_name = client_type_name;
    }

    public String getRepair_type_name() {
        return repair_type_name;
    }

    public void setRepair_type_name(String repair_type_name) {
        this.repair_type_name = repair_type_name;
    }
}
