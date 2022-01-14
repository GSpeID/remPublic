package ru.x3m.rem.dto;


import ru.x3m.rem.entity.Client;

import javax.validation.constraints.NotEmpty;

public class ClientDTO {

    private Long client_id;

    @NotEmpty
    private String client_name;

    public ClientDTO(){
    }

    public ClientDTO(Long client_id, @NotEmpty String client_name) {
        this.client_id = client_id;
        this.client_name = client_name;
    }

    public ClientDTO(Client client) {
        this.client_id = client.getClient_id();
        this.client_name = client.getClient_name();
    }


    public Long getClient_id() {
        return client_id;
    }

    public void setClient_id(Long client_id) {
        this.client_id = client_id;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public String getClientNameById(Long client_id){
        return client_name;
    }

}
