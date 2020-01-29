package com.apache.model;

import javax.persistence.*;
import java.io.Serializable; 

@SuppressWarnings("serial")
@Entity
public class OrderDetail implements Serializable {

    /**
     * Default constructor
     */
    public OrderDetail() {
    }

    public OrderDetail(int quantity, double unitCost) {
        this.quantity = quantity;
        this.unitCost = unitCost;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long orderDetailId;


    private int quantity;


    private double unitCost;

    @OneToOne
    @JoinColumn(name="itemId")
    private Item item;

//    @ManyToOne
//    @JoinColumn(name = "orderId")
//    private  Order order;

    public long getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(long orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(double unitCost) {
        this.unitCost = unitCost;
    }

    public Item getArtWork() {
        return item;
    }

    public void setArtWork(Item artWork) {
        this.item = artWork;
    }
}
