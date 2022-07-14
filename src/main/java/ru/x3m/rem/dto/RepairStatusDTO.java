package ru.x3m.rem.dto;


import ru.x3m.rem.entity.RepairStatuses;

import javax.validation.constraints.NotEmpty;

public class RepairStatusDTO {

    private Long statusId;

    @NotEmpty
    private String statusName;

    public RepairStatusDTO(){
    }

    public RepairStatusDTO(Long statusId, String statusName) {
        this.statusId = statusId;
        this.statusName = statusName;
    }

        public RepairStatusDTO(RepairStatuses repairStatuses){
        this.statusId = repairStatuses.getStatusId();
        this.statusName = repairStatuses.getStatusName();
    }

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }
}
