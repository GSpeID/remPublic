package ru.x3m.rem.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name = "repair_payments")
public class RepairPayments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long payment_id;

    @Column(nullable = false)
    private Long full_cost;

    @Column(nullable = false)
    private Long paid;

    @Column(nullable = false)
    private Long arrears;

    @OneToMany(
            mappedBy = "repairPayments",
            cascade = CascadeType.ALL
//            orphanRemoval = true
    )
    private List<Repair> repairs;

    public Long getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(Long payment_id) {
        this.payment_id = payment_id;
    }

    public Long getFull_cost() {
        return full_cost;
    }

    public void setFull_cost(Long full_cost) {
        this.full_cost = full_cost;
    }

    public Long getPaid() {
        return paid;
    }

    public void setPaid(Long paid) {
        this.paid = paid;
    }

    public Long getArrears() {
        return arrears;
    }

    public void setArrears(Long arrears) {
        this.arrears = arrears;
    }
}
