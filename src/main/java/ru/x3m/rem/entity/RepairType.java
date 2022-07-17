package ru.x3m.rem.entity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "repair_types")
public class RepairType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long repairTypeId;

    @NotNull(message = "Не должно быть пустым")
    @Size(min = 2, max = 45, message = "Миинимум {min}, максимум {max} символов")
    @Column(unique = true, nullable = false)
    private String repairTypeName;

    @OneToMany(
            mappedBy = "repairType",
            cascade = CascadeType.ALL
    )
    private List<Repair> repairs;

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
