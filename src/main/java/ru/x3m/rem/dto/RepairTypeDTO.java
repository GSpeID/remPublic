package ru.x3m.rem.dto;

import ru.x3m.rem.entity.RepairType;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RepairTypeDTO {

    private Long repairTypeId;

    @NotNull(message = "Не должно быть пустым")
    @Size(min = 2, max = 45, message = "Миинимум {min}, максимум {max} символов")
    private String repairTypeName;

    public RepairTypeDTO(){
    }

    public RepairTypeDTO(Long repairTypeId, String repairTypeName) {
        this.repairTypeId = repairTypeId;
        this.repairTypeName = repairTypeName;
    }

    public RepairTypeDTO(RepairType repairType) {
        this.repairTypeId = repairType.getRepairTypeId();
        this.repairTypeName = repairType.getRepairTypeName();
    }

    public Long getRepairTypeId() {
        return repairTypeId;
    }

    public void setRepairTypeId(Long repairTypeId) {
        this.repairTypeId = repairTypeId;
    }

    public String getRepairTypeName() {
        return repairTypeName;
    }

    public void setRepairTypeName(String repairTypeName) {
        this.repairTypeName = repairTypeName;
    }
}
