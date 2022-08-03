package ru.x3m.rem.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "repair_statuses")
public class RepairStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long statusId;

    @NotNull(message = "Не должно быть пустым")
    @Size(min = 2, max = 45, message = "Миинимум {min}, максимум {max} символов")
    @Column(unique = true, nullable = false)
    private String statusName;

    @OneToMany(
            mappedBy = "repairStatus",
            cascade = CascadeType.ALL
    )
    private List<Repair> repairs;

}
