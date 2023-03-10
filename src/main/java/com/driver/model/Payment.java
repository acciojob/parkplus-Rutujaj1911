package com.driver.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private boolean isPaymentCompleted;
    @Enumerated(value = EnumType.STRING)
    private PaymentMode paymentMode;

    @OneToOne
    @JoinColumn
    private Reservation reservation;

    public Payment(){

    }

    public Payment(int id,boolean isPaymentCompleted,PaymentMode paymentMode){
        this.id=id;
        this.isPaymentCompleted=isPaymentCompleted;
        this.paymentMode=paymentMode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public void getReservation(Integer reservationId) {
    }

    public boolean isPaymentCompleted() {
        return isPaymentCompleted;
    }

    public void setPaymentCompleted(boolean paymentCompleted) {
        isPaymentCompleted = paymentCompleted;
    }
}
