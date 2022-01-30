package ru.x3m.rem.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "repair_statuses")
public class RepairStatuses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long status_id;

    @Column(unique = true, nullable = false)
    private String status_name;

    @OneToMany(
            mappedBy = "repairStatuses",
            cascade = CascadeType.ALL
//            orphanRemoval = true
    )
    private List<Repair> repairs;

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
