package com.apache.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "User_Order")
public class Order implements Serializable {

    /**
     * Default constructor
     */
    public Order() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long orderId;


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private LocalDate dateCreated;


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private LocalDate dateShipped;


    private String status;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "shippingInfoId")
    private ShippingInfo shippingInfo;


    @OneToMany(fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetail = new ArrayList<>();


    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDate getDateShipped() {
        return dateShipped;
    }

    public void setDateShipped(LocalDate dateShipped) {
        this.dateShipped = dateShipped;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ShippingInfo getShippingInfo() {
        return shippingInfo;
    }

    public void setShippingInfo(ShippingInfo shippingInfo) {
        this.shippingInfo = shippingInfo;
    }

    public List<OrderDetail> getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(List<OrderDetail> orderDetail) {
        this.orderDetail = orderDetail;
    }
}
