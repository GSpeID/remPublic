package ru.x3m.rem.dto;

import org.springframework.format.annotation.DateTimeFormat;
import ru.x3m.rem.entity.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class RepairDTO {

    private Long repair_id;

    @NotEmpty
    private String repair_name;

    @NotEmpty
    private String repair_description;

    @NotEmpty
    private float repair_cost;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate repair_date;

    //----------------------------
    private Long client_id;
    private Long client_type_id;
    private Long devise_id;
    private Long repair_type_id;
    //---------------------------

    public RepairDTO(){
    }

//    public RepairDTO(Long repair_id, @NotEmpty String repair_name, @NotEmpty String repair_description,
//                     @NotEmpty float repair_cost, @NotNull LocalDate repair_date) {
//        this.repair_id = repair_id;
//        this.repair_name = repair_name;
//        this.repair_description = repair_description;
//        this.repair_cost = repair_cost;
//        this.repair_date = repair_date;
//
//    }


    public RepairDTO(Long repair_id, @NotEmpty String repair_name, @NotEmpty String repair_description,
                     @NotEmpty float repair_cost, @NotNull LocalDate repair_date, Long client_id,
                     Long client_type_id, Long devise_id, Long repair_type_id) {
        this.repair_id = repair_id;
        this.repair_name = repair_name;
        this.repair_description = repair_description;
        this.repair_cost = repair_cost;
        this.repair_date = repair_date;
        this.client_id = client_id;
        this.client_type_id = client_type_id;
        this.devise_id = devise_id;
        this.repair_type_id = repair_type_id;
    }

    public RepairDTO(@org.jetbrains.annotations.NotNull Repair repair){
        this.repair_id=repair.getRepair_id();
        this.repair_name = repair.getRepair_name();
        this.repair_description = repair.getRepair_description();
        this.repair_cost = repair.getRepair_cost();
        this.repair_date = repair.getRepair_date();
        //----------------------------------------
        this.client_id = repair.getClient().getClient_id();
        this.client_type_id = repair.getClientType().getClient_type_id();
        this.devise_id = repair.getDevice().getDevice_id();
        this.repair_type_id = repair.getRepairType().getRepair_type_id();
        //------------------------------------------

    }

    public Long getRepair_id() {
        return repair_id;
    }

    public void setRepair_id(Long repair_id) {
        this.repair_id = repair_id;
    }

    public String getRepair_name() {
        return repair_name;
    }

    public void setRepair_name(String repair_name) {
        this.repair_name = repair_name;
    }

    public String getRepair_description() {
        return repair_description;
    }

    public void setRepair_description(String repair_description) {
        this.repair_description = repair_description;
    }

    public float getRepair_cost() {
        return repair_cost;
    }

    public void setRepair_cost(float repair_cost) {
        this.repair_cost = repair_cost;
    }

    public LocalDate getRepair_date() {
        return repair_date;
    }

    public void setRepair_date(LocalDate repair_date) {
        this.repair_date = repair_date;
    }


    //---------------------------


    public Long getClient_id() {
        return client_id;
    }

    public void setClient_id(Long client_id) {
        this.client_id = client_id;
    }

    public Long getClient_type_id() {
        return client_type_id;
    }

    public void setClient_type_id(Long client_type_id) {
        this.client_type_id = client_type_id;
    }

    public Long getDevise_id() {
        return devise_id;
    }

    public void setDevise_id(Long devise_id) {
        this.devise_id = devise_id;
    }

    public Long getRepair_type_id() {
        return repair_type_id;
    }

    public void setRepair_type_id(Long repair_type_id) {
        this.repair_type_id = repair_type_id;
    }
}
