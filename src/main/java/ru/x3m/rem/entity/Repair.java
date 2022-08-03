package ru.x3m.rem.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
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

    @Column(name = "cash")
    private Boolean cash;

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
    private RepairStatus repairStatus;

    @Column(name = "device_id")
    private Long deviceId;

    @Column(name = "client_id")
    private Long clientId;

    @Column(name = "status_id")
    private Long statusId;

    @Column(name = "repair_type_id")
    private Long repairTypeId;

}