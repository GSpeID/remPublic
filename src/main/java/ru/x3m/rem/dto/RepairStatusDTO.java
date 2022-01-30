package ru.x3m.rem.dto;

import ru.x3m.rem.entity.RepairStatuses;

import javax.validation.constraints.NotEmpty;

public class RepairStatusDTO {

    private Long status_id;

    @NotEmpty
    private String status_name;

    public RepairStatusDTO(){
    }

    public RepairStatusDTO(Long status_id, String status_name) {
        this.status_id = status_id;
        this.status_name = status_name;
    }

    public RepairStatusDTO(RepairStatuses repairStatuses){
        this.status_id = repairStatuses.getStatus_id();
        this.status_name = repairStatuses.getStatus_name();
    }


    public Long getStatus_id() {
        return status_id;
    }

    public void setStatus_id(Long status_id) {
        this.status_id = status_id;
    }

    public String getStatus_name() {
        return status_name;
    }

    public void setStatus_name(String status_name) {
        this.status_name = status_name;
    }
}
