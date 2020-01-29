package com.apache.model;

import javax.persistence.*;
import java.io.Serializable; 

@SuppressWarnings("serial")
@Entity
public class ShippingInfo implements Serializable {

    /**
     * Default constructor
     */
    public ShippingInfo() {
    }

    public ShippingInfo(String shippingType, double shippingCost) {
        this.shippingType = shippingType;
        this.shippingCost = shippingCost;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long shippingInfoId;


    private String shippingType;


    private double shippingCost;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    ShippingAddress shippingAddress;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    MethodPayement methodPayement;

    public long getShippingInfoId() {
        return shippingInfoId;
    }

    public void setShippingInfoId(long shippingInfoId) {
        this.shippingInfoId = shippingInfoId;
    }

    public String getShippingType() {
        return shippingType;
    }

    public void setShippingType(String shippingType) {
        this.shippingType = shippingType;
    }

    public double getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(double shippingCost) {
        this.shippingCost = shippingCost;
    }

    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public MethodPayement getMethodPayement() {
        return methodPayement;
    }

    public void setMethodPayement(MethodPayement methodPayement) {
        this.methodPayement = methodPayement;
    }
}
