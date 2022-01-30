package ru.x3m.rem.dto;

import ru.x3m.rem.entity.RepairPayments;
import ru.x3m.rem.repository.RepairPaymentsRepo;

import javax.validation.constraints.NotNull;

public class RepairPaymentDTO {

    private Long payment_id;
    @NotNull
    private Long full_cost;
    @NotNull
    private Long paid;
    @NotNull
    private Long arrears;

    public RepairPaymentDTO(){
    }

    public RepairPaymentDTO(Long payment_id, Long full_cost, Long paid, Long arrears) {
        this.payment_id = payment_id;
        this.full_cost = full_cost;
        this.paid = paid;
        this.arrears = arrears;
    }

    public  RepairPaymentDTO(RepairPayments repairPayments){
        this.payment_id = repairPayments.getPayment_id();
        this.full_cost = repairPayments.getFull_cost();
        this.paid = repairPayments.getPaid();
        this.arrears = repairPayments.getArrears();
    }

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
