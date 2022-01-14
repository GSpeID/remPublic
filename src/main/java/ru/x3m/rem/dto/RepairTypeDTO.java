package ru.x3m.rem.dto;


import ru.x3m.rem.entity.RepairType;

import javax.validation.constraints.NotEmpty;

public class RepairTypeDTO {

    private Long repair_type_id;

    @NotEmpty
    private String repair_type_name;

    public RepairTypeDTO(){
    }

    public RepairTypeDTO(Long repair_type_id, @NotEmpty String repair_type_name) {
        this.repair_type_id = repair_type_id;
        this.repair_type_name = repair_type_name;
    }

    public RepairTypeDTO(RepairType repairType) {
        this.repair_type_id = repairType.getRepair_type_id();
        this.repair_type_name = repairType.getRepair_type_name();
    }

    public Long getRepair_type_id() {
        return repair_type_id;
    }

    public void setRepair_type_id(Long repair_type_id) {
        this.repair_type_id = repair_type_id;
    }

    public String getRepair_type_name() {
        return repair_type_name;
    }

    public void setRepair_type_name(String repair_type_name) {
        this.repair_type_name = repair_type_name;
    }

    public String getRepairTypNameById(Long repair_type_id){
        return repair_type_name;
    }

}
