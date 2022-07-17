package ru.x3m.rem.dto;


import ru.x3m.rem.entity.RepairStatuses;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RepairStatusDTO {

    private Long statusId;

    @NotNull(message = "Не должно быть пустым")
    @Size(min = 2, max = 45, message = "Миинимум {min}, максимум {max} символов")
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
