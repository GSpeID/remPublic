package ru.x3m.rem.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.x3m.rem.entity.Client;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
@Setter
public class ClientDTO {

    private Long clientId;

    @NotNull(message = "Не должно быть пустым")
    @Size(min = 2, max = 45, message = "Миинимум {min}, максимум {max} символов")
    private String clientName;

    @NotNull(message = "Выберите тип клиента")
    private  Long clientTypeId;

    private String clientContact;

    private String clientPhone;

    private String clientMail;

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

}
