package ru.x3m.rem.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "costItem")
public class CostItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "costItemId")
    private Long costItemId;

    @Column(name = "costItemName")
    private String costItemName;

    @ManyToOne
    @JoinColumn(name = "subCostItemId", insertable = false, updatable = false)
    private SubCostItem  subCostItem;

    private Long subCostItemId;

    @OneToMany(
            mappedBy = "costItem",
            cascade = CascadeType.ALL
    )
    private List<LlcOutlay> llcOutlays;


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

    public SubCostItem getSubCostItem() {
        return subCostItem;
    }

    public void setSubCostItem(SubCostItem subCostItem) {
        this.subCostItem = subCostItem;
    }

    public Long getSubCostItemId() {
        return subCostItemId;
    }

    public void setSubCostItemId(Long subCostItemId) {
        this.subCostItemId = subCostItemId;
    }

    public List<LlcOutlay> getLlcOutlays() {
        return llcOutlays;
    }

    public void setLlcOutlays(List<LlcOutlay> llcOutlays) {
        this.llcOutlays = llcOutlays;
    }
}
