package ru.x3m.rem.dto;

import ru.x3m.rem.entity.SubItem;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SubItemDTO {

    private Long subitemId;

    @NotNull(message = "Не должно быть пустым")
    @Size(min = 3, message = "Минимум {min} символа")
    private String subitemName;

    @NotNull(message = "Выберите подстатью")
    private Long itemsItemId;

    public SubItemDTO() {
    }

    public SubItemDTO(Long subitemId, String subitemName, Long itemsItemId) {
        this.subitemId = subitemId;
        this.subitemName = subitemName;
        this.itemsItemId = itemsItemId;
    }

    public SubItemDTO(SubItem subItem) {
        this.subitemId = subItem.getSubitemId();
        this.subitemName = subItem.getSubitemName();
        this.itemsItemId = subItem.getItemsItemId();
    }

    public Long getSubitemId() {
        return subitemId;
    }

    public void setSubitemId(Long subitemId) {
        this.subitemId = subitemId;
    }

    public String getSubitemName() {
        return subitemName;
    }

    public void setSubitemName(String subitemName) {
        this.subitemName = subitemName;
    }

    public Long getItemsItemId() {
        return itemsItemId;
    }

    public void setItemsItemId(Long itemsItemId) {
        this.itemsItemId = itemsItemId;
    }


}
