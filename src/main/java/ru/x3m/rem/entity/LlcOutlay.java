package ru.x3m.rem.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "llcOutlay")
public class LlcOutlay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "llcOutlayId")
    private Long llcOutlayId;

    @Column(name = "description")
    private String description;

    @Column(name = "cost")
    private Float cost;

    @Column(name = "date")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "costItemId", insertable = false, updatable = false)
    private CostItem costItem;

    private Long costItemId;

    public LlcOutlay() {
    }

    public Long getLlcOutlayId() {
        return llcOutlayId;
    }

    public void setLlcOutlayId(Long llcOutlayId) {
        this.llcOutlayId = llcOutlayId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public CostItem getCostItem() {
        return costItem;
    }

    public void setCostItem(CostItem costItem) {
        this.costItem = costItem;
    }

    public Long getCostItemId() {
        return costItemId;
    }

    public void setCostItemId(Long costItemId) {
        this.costItemId = costItemId;
    }
}
