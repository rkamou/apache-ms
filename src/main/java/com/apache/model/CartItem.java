package com.apache.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne; 

@Entity
public class CartItem {

    /**
     * Default constructor
     */

    public CartItem() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    private String name;


    private int quantity;


    private double unitCost;

    @OneToOne
    @JoinColumn(name="itemId")
    private Item item;


    public long getId() {
        return id;
    }

    public void setId(long cartId) {
        this.id = cartId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
