package ru.x3m.rem.dto;

import ru.x3m.rem.entity.ClientType;

import javax.validation.constraints.NotEmpty;

public class ClientTypeDTO {

    private Long clientTypeId;

    @NotEmpty
    private String clientTypeName;

    public ClientTypeDTO() {
    }

    public ClientTypeDTO(Long clientTypeId, String clientTypeName) {
        this.clientTypeId = clientTypeId;
        this.clientTypeName = clientTypeName;
    }

    public ClientTypeDTO(ClientType clientType){
        this.clientTypeId = clientType.getClientTypeId();
        this.clientTypeName = clientType.getClientTypeName();
    }

    public Long getClientTypeId() {
        return clientTypeId;
    }

    public void setClientTypeId(Long clientTypeId) {
        this.clientTypeId = clientTypeId;
    }

    public String getClientTypeName() {
        return clientTypeName;
    }

    public void setClientTypeName(String clientTypeName) {
        this.clientTypeName = clientTypeName;
    }
}
