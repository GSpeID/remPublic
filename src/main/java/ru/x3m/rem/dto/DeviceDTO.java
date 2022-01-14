package ru.x3m.rem.dto;

import ru.x3m.rem.entity.Device;

import javax.validation.constraints.NotEmpty;

public class DeviceDTO {

    private Long device_id;

    @NotEmpty
    private String device_name;

    public DeviceDTO(){
    }

    public DeviceDTO(Long device_id, @NotEmpty String device_name) {
        this.device_id = device_id;
        this.device_name = device_name;
    }

    public DeviceDTO(Device device){
        this.device_id = device.getDevice_id();
        this.device_name = device.getDevice_name();
    }

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

    public String getDeviceNameById(Long device_id){
        return device_name;
    }

}
