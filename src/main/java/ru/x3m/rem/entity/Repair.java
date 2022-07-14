package ru.x3m.rem.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "repairs")
public class Repair {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long repairId;

    @Column(nullable = false)
    private String repairAddress;

    @Column
    private String repairDescription;

    @Column
    private LocalDate repairDate;

    @Column
    private Float fullCost;

    @Column
    private Float paid;

    @Column
    private Float arrears;

    @Column
    private Float outlay;

    @Column
    private Float profit;

    @ManyToOne
    @JoinColumn(name = "client_id", insertable = false, updatable = false)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "device_id", insertable = false, updatable = false)
    private Device device;

    @ManyToOne
    @JoinColumn(name = "repair_type_id", insertable = false, updatable = false)
    private RepairType repairType;

    @ManyToOne
    @JoinColumn(name = "status_id", insertable = false, updatable = false)
    private RepairStatuses repairStatuses;

    @Column(name = "device_id")
    private Long deviceId;

    @Column(name = "client_id")
    private Long clientId;

    @Column(name = "status_id")
    private Long statusId;

    @Column(name = "repair_type_id")
    private Long repairTypeId;

    public Repair() {
    }

    public Long getRepairId() {
        return repairId;
    }

    public void setRepairId(Long repairId) {
        this.repairId = repairId;
    }

    public String getRepairAddress() {
        return repairAddress;
    }

    public void setRepairAddress(String repairAddress) {
        this.repairAddress = repairAddress;
    }

    public String getRepairDescription() {
        return repairDescription;
    }

    public void setRepairDescription(String repairDescription) {
        this.repairDescription = repairDescription;
    }

    public LocalDate getRepairDate() {
        return repairDate;
    }

    public void setRepairDate(LocalDate repairDate) {
        this.repairDate = repairDate;
    }

    public Float getFullCost() {
        return fullCost;
    }

    public void setFullCost(Float fullCost) {
        this.fullCost = fullCost;
    }

    public Float getPaid() {
        return paid;
    }

    public void setPaid(Float paid) {
        this.paid = paid;
    }

    public Float getArrears() {
        return arrears;
    }

    public void setArrears(Float arrears) {
        this.arrears = arrears;
    }

    public Float getOutlay() {
        return outlay;
    }

    public void setOutlay(Float outlay) {
        this.outlay = outlay;
    }

    public Float getProfit() {
        return profit;
    }

    public void setProfit(Float profit) {
        this.profit = profit;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public RepairType getRepairType() {
        return repairType;
    }

    public void setRepairType(RepairType repairType) {
        this.repairType = repairType;
    }

    public RepairStatuses getRepairStatuses() {
        return repairStatuses;
    }

    public void setRepairStatuses(RepairStatuses repairStatuses) {
        this.repairStatuses = repairStatuses;
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public Long getRepairTypeId() {
        return repairTypeId;
    }

    public void setRepairTypeId(Long repairTypeId) {
        this.repairTypeId = repairTypeId;
    }
}