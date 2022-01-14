package ru.x3m.rem.dto;

import ru.x3m.rem.entity.ClientType;

import javax.validation.constraints.NotEmpty;

public class ClientTypeDTO {

    private int client_type_id;

    @NotEmpty
    private String client_type_name;

    public ClientTypeDTO(){
    }

    public ClientTypeDTO(int client_type_id, @NotEmpty String client_type_name) {
        this.client_type_id = client_type_id;
        this.client_type_name = client_type_name;
    }

    public ClientTypeDTO(ClientType clientType){
        this.client_type_id = clientType.getClient_type_id();
        this.client_type_name = clientType.getClient_type_name();
    }

    public int getClient_type_id() {
        return client_type_id;
    }

    public void setClient_type_id(int client_type_id) {
        this.client_type_id = client_type_id;
    }

    public String getClient_type_name() {
        return client_type_name;
    }

    public void setClient_type_name(String client_type_name) {
        this.client_type_name = client_type_name;
    }

    public String getClientTypeNameById(int client_type_id){
        return client_type_name;
    }

}
