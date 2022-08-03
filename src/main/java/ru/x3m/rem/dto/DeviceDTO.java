package ru.x3m.rem.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.x3m.rem.entity.Device;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
@Setter
public class DeviceDTO {

    private Long deviceId;

    @NotNull(message = "Не должно быть пустым")
    @Size(min = 2, max = 45, message = "Миинимум {min}, максимум {max} символов")
    private String deviceName;

    public DeviceDTO(Long deviceId, String deviceName) {
        this.deviceId = deviceId;
        this.deviceName = deviceName;
    }

    public DeviceDTO(Device device){
        this.deviceId = device.getDeviceId();
        this.deviceName = device.getDeviceName();
    }

}
