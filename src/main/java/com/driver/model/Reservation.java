package com.driver.model;

import jdk.dynalink.linker.LinkerServices;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int numberOfHours;

    public Reservation(){

    }

    public Reservation(int id,int numberOfHours) {
        this.id = id;
        this.numberOfHours=numberOfHours;
    }

    @ManyToOne
    @JoinColumn
    private Spot spot;

    @ManyToOne
    @JoinColumn
    private User user;

    @OneToOne(mappedBy = "reservation",cascade = CascadeType.ALL)
    List<Payment> paymentList=new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberOfHours() {
        return numberOfHours;
    }

    public void setNumberOfHours(int numberOfHours) {
        this.numberOfHours = numberOfHours;
    }

    public Spot getSpot() {
        return spot;
    }

    public void setSpot(Spot spot) {
        this.spot = spot;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Payment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }
}
