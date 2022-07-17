package ru.x3m.rem.dto;

import ru.x3m.rem.entity.Device;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class DeviceDTO {

    private Long deviceId;

    @NotNull(message = "Не должно быть пустым")
    @Size(min = 2, max = 45, message = "Миинимум {min}, максимум {max} символов")
    private String deviceName;

    public DeviceDTO() {
    }

    public DeviceDTO(Long deviceId, String deviceName) {
        this.deviceId = deviceId;
        this.deviceName = deviceName;
    }

    public DeviceDTO(Device device){
        this.deviceId = device.getDeviceId();
        this.deviceName = device.getDeviceName();
    }

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
