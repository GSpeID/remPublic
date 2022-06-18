package ru.x3m.rem.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "subCostItem")
public class SubCostItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subCostItemId")
    private Long subCostItemId;

    @Column(name = "subCostItemName")
    private String subCostItemName;

    @OneToMany(
            mappedBy = "subCostItem",
            cascade = CascadeType.ALL
    )
    private List<CostItem> costItems;

    public SubCostItem() {
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

    public List<CostItem> getCostItems() {
        return costItems;
    }

    public void setCostItems(List<CostItem> costItems) {
        this.costItems = costItems;
    }
}
