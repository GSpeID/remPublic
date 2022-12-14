package ru.x3m.rem.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
@Setter
public class ItemDTO {

    private Long itemId;

    @Valid
    @NotNull(message = "не может быть пустым")
    @Size(min = 2, max = 45, message = "Минимум {min}, максимум {max} символов")
    private String itemName;

}
