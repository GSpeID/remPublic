package ru.x3m.rem.dto;

import ru.x3m.rem.entity.LlcOutlay;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class LlcOutlayDTO {

    @NotNull
    private Long llcOutlayId;

    @NotNull
    private  String description;

    @NotNull
    private Float cost;

    @NotNull
    private LocalDate date;

    @NotNull
    private Long costItemId;

    public LlcOutlayDTO() {
    }

    public LlcOutlayDTO(Long llcOutlayId, String description, Float cost, LocalDate date, Long costItemId) {
        this.llcOutlayId = llcOutlayId;
        this.description = description;
        this.cost = cost;
        this.date = date;
        this.costItemId = costItemId;
    }

    public LlcOutlayDTO(LlcOutlay llcOutlay) {
        this.llcOutlayId = llcOutlay.getLlcOutlayId();
        this.description = llcOutlay.getDescription();
        this.cost = llcOutlay.getCost();
        this.date = llcOutlay.getDate();
        this.costItemId = llcOutlay.getCostItemId();
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

    public Long getCostItemId() {
        return costItemId;
    }

    public void setCostItemId(Long costItemId) {
        this.costItemId = costItemId;
    }
}
