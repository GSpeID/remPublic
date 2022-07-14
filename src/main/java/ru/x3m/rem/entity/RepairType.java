package ru.x3m.rem.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "repair_types")
public class RepairType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long repairTypeId;

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
