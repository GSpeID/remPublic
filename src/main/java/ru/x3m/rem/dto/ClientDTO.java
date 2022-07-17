package ru.x3m.rem.dto;

import ru.x3m.rem.entity.Client;

import javax.validation.constraints.*;

public class ClientDTO {

    private Long clientId;

    @NotNull(message = "Не должно быть пустым")
    @Size(min = 2, max = 45, message = "Миинимум {min}, максимум {max} символов")
    private String clientName;

    @NotNull(message = "Выберите тип клиента")
    private  Long clientTypeId;



    public ClientDTO(){
    }

    public ClientDTO(Long clientId, String clientName, Long clientTypeId) {
        this.clientId = clientId;
        this.clientName = clientName;
        this.clientTypeId = clientTypeId;
    }

    public ClientDTO(Client client) {
        this.clientId = client.getClientId();
        this.clientName = client.getClientName();
        this.clientTypeId = client.getClientType().getClientTypeId();
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Long getClientTypeId() {
        return clientTypeId;
    }

    public void setClientTypeId(Long clientTypeId) {
        this.clientTypeId = clientTypeId;
    }
}
