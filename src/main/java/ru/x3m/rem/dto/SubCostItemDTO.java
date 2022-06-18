package ru.x3m.rem.dto;

import ru.x3m.rem.entity.SubCostItem;

import javax.validation.constraints.NotNull;

public class SubCostItemDTO {

    @NotNull
    private Long subCostItemId;

    @NotNull
    private String subCostItemName;

    public SubCostItemDTO() {
    }

    public SubCostItemDTO(Long subCostItemId, String subCostItemName) {
        this.subCostItemId = subCostItemId;
        this.subCostItemName = subCostItemName;
    }

    public SubCostItemDTO(SubCostItem subCostItem) {
        this.subCostItemId = subCostItem.getSubCostItemId();
        this.subCostItemName = subCostItem.getSubCostItemName();
    }

    public Long getSubCostItemId() {
        return subCostItemId;
    }

    public void setSubCostItemId(Long subCostItemId) {
        this.subCostItemId = subCostItemId;
    }

    public String getSubCostItemName() {
        return subCostItemName;
    }

    public void setSubCostItemName(String subCostItemName) {
        this.subCostItemName = subCostItemName;
    }
}
