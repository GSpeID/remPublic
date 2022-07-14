package ru.x3m.rem.dto;

import org.springframework.format.annotation.DateTimeFormat;
import ru.x3m.rem.entity.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class RepairDTO {


    private Long repairId;

    @NotEmpty
    private String repairAddress;

    @NotEmpty
    private String repairDescription;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate repairDate;

    @NotNull
    private Float fullCost;

    @NotNull
    private Float paid;

    @NotNull
    private Float outlay;

    @NotNull
    private Float arrears;

    @NotNull
    private Float profit;

    //----------------------------
    private Long clientId;
    private Long deviceId;
    private Long repairTypeId;
    private Long clientTypeId;
    private Long statusId;
    private String clientName;
    private String deviceName;
    private String clientTypeName;
    private String repairTypeName;
    private String statusName;
    //---------------------------


    public RepairDTO() {
    }

    public RepairDTO(Long repairId, String repairAddress, String repairDescription,
                     LocalDate repairDate, Float fullCost, Float paid,
                     Float outlay, Float arrears, Float profit, Long clientId,
                     Long deviceId, Long repairTypeId, Long clientTypeId,
                     Long statusId, String clientName, String deviceName,
                     String clientTypeName, String repairTypeName,
                     String statusName) {
        this.repairId = repairId;
        this.repairAddress = repairAddress;
        this.repairDescription = repairDescription;
        this.repairDate = repairDate;
        this.fullCost = fullCost;
        this.paid = paid;
        this.outlay = outlay;
        this.arrears = arrears;
        this.profit = profit;
        this.clientId = clientId;
        this.deviceId = deviceId;
        this.repairTypeId = repairTypeId;
        this.clientTypeId = clientTypeId;
        this.statusId = statusId;
        this.clientName = clientName;
        this.deviceName = deviceName;
        this.clientTypeName = clientTypeName;
        this.repairTypeName = repairTypeName;
        this.statusName = statusName;
    }

    public RepairDTO(Repair repair) {
        this.repairId = repair.getRepairId();
        this.repairAddress = repair.getRepairAddress();
        this.repairDescription = repair.getRepairDescription();
        this.repairDate = repair.getRepairDate();
        this.clientId = repair.getClientId();
        this.deviceId = repair.getDeviceId();
        this.repairTypeId = repair.getRepairTypeId();
        this.statusId = repair.getStatusId();
        this.clientName = repair.getClient().getClientName();
        this.deviceName = repair.getDevice().getDeviceName();
        this.repairTypeName = repair.getRepairType().getRepairTypeName();
        this.clientTypeName = repair.getClient().getClientType().getClientTypeName();
        this.clientTypeId = repair.getClient().getClientType().getClientTypeId();
        this.statusName = repair.getRepairStatuses().getStatusName();
        this.fullCost = repair.getFullCost();
        this.paid = repair.getPaid();
        this.arrears = repair.getArrears();
        this.outlay = repair.getOutlay();
        this.profit = repair.getProfit();
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

    public Float getOutlay() {
        return outlay;
    }

    public void setOutlay(Float outlay) {
        this.outlay = outlay;
    }

    public Float getArrears() {
        return arrears;
    }

    public void setArrears(Float arrears) {
        this.arrears = arrears;
    }

    public Float getProfit() {
        return profit;
    }

    public void setProfit(Float profit) {
        this.profit = profit;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public Long getRepairTypeId() {
        return repairTypeId;
    }

    public void setRepairTypeId(Long repairTypeId) {
        this.repairTypeId = repairTypeId;
    }

    public Long getClientTypeId() {
        return clientTypeId;
    }

    public void setClientTypeId(Long clientTypeId) {
        this.clientTypeId = clientTypeId;
    }

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getClientTypeName() {
        return clientTypeName;
    }

    public void setClientTypeName(String clientTypeName) {
        this.clientTypeName = clientTypeName;
    }

    public String getRepairTypeName() {
        return repairTypeName;
    }

    public void setRepairTypeName(String repairTypeName) {
        this.repairTypeName = repairTypeName;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public float calcArrears(){
        arrears=fullCost-paid;
        return arrears;
    }

    public float calcProfit(){
        profit=fullCost-outlay;
        return profit;
    }

}
