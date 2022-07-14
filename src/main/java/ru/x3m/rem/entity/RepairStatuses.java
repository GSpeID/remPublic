package ru.x3m.rem.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "repair_statuses")
public class RepairStatuses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long statusId;

    @Column(unique = true, nullable = false)
    private String statusName;

    @OneToMany(
            mappedBy = "repairStatuses",
            cascade = CascadeType.ALL
    )
    private List<Repair> repairs;

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
