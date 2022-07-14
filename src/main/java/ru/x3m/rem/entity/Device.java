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
    private Long deviceId;

    @Column(unique = true, nullable = false)
    @NotNull(message = "не должно быть пустым")
    @Size(min = 3, max = 20, message = "минимум 3 символа")
    private String deviceName;

    @OneToMany(
            mappedBy = "device",
            cascade = CascadeType.ALL
    )
    private List<Repair> repairs;

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }
}
