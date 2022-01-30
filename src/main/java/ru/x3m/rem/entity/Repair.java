package ru.x3m.rem.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "repairs")
public class Repair {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long repair_id;

    @Column(nullable = false)
    private String repair_address;

    @Column
    private String repair_description;

    @Column
    private LocalDate repair_date;

    @ManyToOne
    @JoinColumn(name = "client_id", insertable=false, updatable=false)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "device_id", insertable=false, updatable=false)
    private Device device;

    @ManyToOne
    @JoinColumn(name = "repair_type_id", insertable=false, updatable=false)
    private RepairType repairType;

    @ManyToOne
    @JoinColumn(name = "status_id", insertable=false, updatable=false)
    private RepairStatuses repairStatuses;

    @ManyToOne
    @JoinColumn(name = "payment_id", insertable=false, updatable=false)
    private RepairPayments repairPayments;

    private Long device_id;
    private Long client_id;
    private Long status_id;
    private Long payment_id;
    private Long repair_type_id;

    public Repair(){
    }

    public Long getRepair_id() {
        return repair_id;
    }

    public void setRepair_id(Long repair_id) {
        this.repair_id = repair_id;
    }

    public String getRepair_address() {
        return repair_address;
    }

    public void setRepair_address(String repair_address) {
        this.repair_address = repair_address;
    }

    public String getRepair_description() {
        return repair_description;
    }

    public void setRepair_description(String repair_description) {
        this.repair_description = repair_description;
    }

    public LocalDate getRepair_date() {
        return repair_date;
    }

    public void setRepair_date(LocalDate repair_date) {
        this.repair_date = repair_date;
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
    public void setDevice_id(Long device_id) {
        this.device_id = device_id;
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

    public RepairPayments getRepairPayments() {
        return repairPayments;
    }

    public void setRepairPayments(RepairPayments repairPayments) {
        this.repairPayments = repairPayments;
    }

    public Long getDevice_id() {
        return device_id;
    }

    public Long getClient_id() {
        return client_id;
    }

    public void setClient_id(Long client_id) {
        this.client_id = client_id;
    }

    public Long getStatus_id() {
        return status_id;
    }

    public void setStatus_id(Long status_id) {
        this.status_id = status_id;
    }

    public Long getRepair_type_id() {
        return repair_type_id;
    }

    public void setRepair_type_id(Long repair_type_id) {
        this.repair_type_id = repair_type_id;
    }

    public Long getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(Long payment_id) {
        this.payment_id = payment_id;
    }
}