package ru.x3m.rem.dto;

import org.springframework.format.annotation.DateTimeFormat;
import ru.x3m.rem.entity.Repair;

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
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate repair_date;

    public RepairDTO(){
    }

    public RepairDTO(Long repair_id, @NotEmpty String repair_name, @NotEmpty String repair_description, @NotEmpty float repair_cost, @NotNull LocalDate repair_date) {
        this.repair_id = repair_id;
        this.repair_name = repair_name;
        this.repair_description = repair_description;
        this.repair_cost = repair_cost;
        this.repair_date = repair_date;
    }

    public RepairDTO(Repair repair){
        this.repair_id=repair.getRepair_id();
        this.repair_name = repair.getRepair_name();
        this.repair_description = repair.getRepair_description();
        this.repair_cost = repair.getRepair_cost();
        this.repair_date = repair.getRepair_date();
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
}
