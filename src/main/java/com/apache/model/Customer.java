package com.apache.model;

import javax.persistence.*;
import java.util.*;


public class Customer {

    /**
     * Default constructor
     */
    public Customer() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long customerId;


    private String firstname;


    private String lastName;


    private String contact;


    private boolean active;

     @OneToOne
    private ShippingAddress shoppingAddress;


    private ShoppingCart shoppingCart;


    private List<Order> order;


    private UserAccount userAcctount;


    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public ShippingAddress getShoppingAddress() {
        return shoppingAddress;
    }

    public void setShoppingAddress(ShippingAddress shoppingAddress) {
        this.shoppingAddress = shoppingAddress;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
    }

    public UserAccount getUserAcctount() {
        return userAcctount;
    }

    public void setUserAcctount(UserAccount userAcctount) {
        this.userAcctount = userAcctount;
    }
}
