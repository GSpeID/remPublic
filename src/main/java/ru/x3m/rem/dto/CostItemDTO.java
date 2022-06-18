package ru.x3m.rem.dto;

import ru.x3m.rem.entity.CostItem;

import javax.validation.constraints.NotNull;

public class CostItemDTO {

    @NotNull
    private Long costItemId;

    @NotNull
    private String costItemName;

    @NotNull
    private Long subCostItemId;

    public CostItemDTO() {
    }

    public CostItemDTO(Long costItemId, String costItemName, Long subCostItemId) {
        this.costItemId = costItemId;
        this.costItemName = costItemName;
        this.subCostItemId = subCostItemId;
    }

    public CostItemDTO(CostItem costItem) {
        this.costItemId = costItem.getCostItemId();
        this.costItemName = costItem.getCostItemName();
        this.subCostItemId = costItem.getSubCostItemId();
    }


    public Long getCostItemId() {
        return costItemId;
    }

    public void setCostItemId(Long costItemId) {
        this.costItemId = costItemId;
    }

    public String getCostItemName() {
        return costItemName;
    }

    public void setCostItemName(String costItemName) {
        this.costItemName = costItemName;
    }

    public Long getSubCostItemId() {
        return subCostItemId;
    }

    public void setSubCostItemId(Long subCostItemId) {
        this.subCostItemId = subCostItemId;
    }
}
