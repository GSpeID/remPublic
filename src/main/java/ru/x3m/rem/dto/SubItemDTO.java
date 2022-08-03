package ru.x3m.rem.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.x3m.rem.entity.SubItem;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
@Setter
public class SubItemDTO {
    private Long subitemId;

    @NotNull(message = "Не должно быть пустым")
    @Size(min = 3, message = "Минимум {min} символа")
    private String subitemName;

    @NotNull(message = "Выберите подстатью")
    private Long itemsItemId;

    private String itemName;

    public SubItemDTO(SubItem subItem) {
        this.subitemId = subItem.getSubitemId();
        this.subitemName = subItem.getSubitemName();
        this.itemsItemId = subItem.getItemsItemId();
    }

}
