package ru.x3m.rem.dto;

import ru.x3m.rem.entity.Item;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ItemDTO {

    private Long itemId;

    @NotNull(message = "не может быть пустым")
    @Size(min = 2, max = 16, message = "название минимум {min}, максимум {max} символов")
    private String itemName;

    public ItemDTO() {
    }

    public ItemDTO(Long itemId, String itemName) {
        this.itemId = itemId;
        this.itemName = itemName;
    }

    public ItemDTO(Item item) {
        this.itemId = item.getItemId();
        this.itemName = item.getItemName();
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
