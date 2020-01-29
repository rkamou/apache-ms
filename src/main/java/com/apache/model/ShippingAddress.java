package com.apache.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank; 

@Entity
public class ShippingAddress {

    /**
     * Default constructor
     */
    public ShippingAddress() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long shippingAddressId;


    @Column(nullable=false)
    @NotBlank(message = "* Street is required")
    private String street;

    @Column(nullable=false)
    @NotBlank(message = "* Street is required")
    private String city;

    @Column(nullable=false)
    @NotBlank(message = "* Street is required")
    private String state;

    @Column(nullable=false)
    @NotBlank(message = "* Street is required")
    private String zipcode;

    public long getShippingAddressId() {
        return shippingAddressId;
    }

    public void setShippingAddressId(long shippingAddressId) {
        this.shippingAddressId = shippingAddressId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}
