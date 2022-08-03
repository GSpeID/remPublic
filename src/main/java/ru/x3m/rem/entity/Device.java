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
@Table(name = "devices")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deviceId;

    @Column(unique = true, nullable = false)
    @NotNull(message = "Не должно быть пустым")
    @Size(min = 2, max = 45, message = "Миинимум {min}, максимум {max} символов")
    private String deviceName;

    @OneToMany(
            mappedBy = "device",
            cascade = CascadeType.ALL
    )
    private List<Repair> repairs;

}
