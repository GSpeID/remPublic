package ru.x3m.rem.entity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "devices")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long device_id;

    @Column(unique = true, nullable = false)
    @NotNull(message = "не должно быть пустым")
    @Size(min = 3, max = 250, message = "минимум 3 символа")
    private String device_name;

    @OneToMany(
            mappedBy = "device",
            cascade = CascadeType.ALL
//            orphanRemoval = true
    )
    private List<Repair> repairs;


    public Long getDevice_id() {
        return device_id;
    }

    public void setDevice_id(Long device_id) {
        this.device_id = device_id;
    }

    public String getDevice_name() {
        return device_name;
    }

    public void setDevice_name(String device_name) {
        this.device_name = device_name;
    }


}
