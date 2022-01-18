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
    private String repair_name;

    @Column
    private String repair_description;

    @Column(nullable = false)
    private float repair_cost;

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
    @JoinColumn(name = "client_type_id", insertable=false, updatable=false)
    private ClientType clientType;

    private Long device_id;
    private Long client_id;
    private Long client_type_id;
    private Long repair_type_id;

    public Repair(){
    }

    public Long getRepair_id() {
        return repair_id;
    }

    public void setRepair_id(Long repair_id) {
        this.repair_id = repair_id;
    }

    public String getRepair_name() {
        return repair_name;
    }

    public void setRepair_name(String repair_name) {
        this.repair_name = repair_name;
    }

    public String getRepair_description() {
        return repair_description;
    }

    public void setRepair_description(String repair_description) {
        this.repair_description = repair_description;
    }

    public float getRepair_cost() {
        return repair_cost;
    }

    public void setRepair_cost(float repair_cost) {
        this.repair_cost = repair_cost;
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

    public ClientType getClientType() {
        return clientType;
    }

    public void setClientType(ClientType clientType) {
        this.clientType = clientType;
    }

    //--------

    public Long getDevice_id() {
        return device_id;
    }

    public Long getClient_id() {
        return client_id;
    }

    public void setClient_id(Long client_id) {
        this.client_id = client_id;
    }

    public Long getClient_type_id() {
        return client_type_id;
    }

    public void setClient_type_id(Long client_type_id) {
        this.client_type_id = client_type_id;
    }

    public Long getRepair_type_id() {
        return repair_type_id;
    }

    public void setRepair_type_id(Long repair_type_id) {
        this.repair_type_id = repair_type_id;
    }
}