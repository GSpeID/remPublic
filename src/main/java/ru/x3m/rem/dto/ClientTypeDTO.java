package ru.x3m.rem.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.x3m.rem.entity.ClientType;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
@Setter
public class ClientTypeDTO {

    private Long clientTypeId;

    @NotNull(message = "Не должно быть пустым")
    @Size(min = 2, max = 45, message = "Миинимум {min}, максимум {max} символов")
    private String clientTypeName;

    public ClientTypeDTO(ClientType clientType){
        this.clientTypeId = clientType.getClientTypeId();
        this.clientTypeName = clientType.getClientTypeName();
    }

}
