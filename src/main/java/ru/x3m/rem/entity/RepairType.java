package ru.x3m.rem.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "repair_types")
public class RepairType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long repair_type_id;

    @Column(unique = true, nullable = false)
    private String repair_type_name;

    @OneToMany(
            mappedBy = "repairType",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )

    private List<Repair> repairs;

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

    public List<Repair> getRepairs() {
        return repairs;
    }

    public void setRepairs(List<Repair> repairs) {
        this.repairs = repairs;
    }
}
