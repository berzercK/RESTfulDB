package com.netcracker.BatyrkinAndrew.entity;

import javax.persistence.*;

@Entity
@Table(name = "buyers")
public class Buyer {

    @Id
    @Column(name = "id_buyer")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBuyer;
    @Column(name = "name")
    private String name;
    @Column(name = "region")
    private String region;
    @Column(name = "sale")
    private double sale;

    public Buyer() {
    }

    public Buyer(String name, String region, double sale) {
        this.name = name;
        this.region = region;
        this.sale = sale;
    }

    public int getIdBuyer() {
        return idBuyer;
    }

    public void setIdBuyer(int idBuyer) {
        this.idBuyer = idBuyer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public double getSale() {
        return sale;
    }

    public void setSale(double sale) {
        this.sale = sale;
    }

    @Override
    public String toString() {
        return "Buyer{" +
                "idBuyer=" + idBuyer +
                ", name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", sale=" + sale +
                '}';
    }

}