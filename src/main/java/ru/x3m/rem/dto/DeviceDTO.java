package ru.x3m.rem.dto;

import ru.x3m.rem.entity.Device;

import javax.validation.constraints.NotEmpty;

public class DeviceDTO {

    private Long deviceId;

    @NotEmpty
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
