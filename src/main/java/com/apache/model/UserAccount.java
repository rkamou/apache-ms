package com.apache.model;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.util.*;

@Entity
@Transactional
public class UserAccount {

    /**
     * Default constructor
     */
    public UserAccount() {
    }

    String userProfilePic;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userAccountId;

    @Column(nullable=false)
    @NotBlank(message = "* First Name is required")
    private String firstName;
    @Column(nullable=false)
    @NotBlank(message = "* Last Name is required")
    private String lastName;
    @Column(nullable=false)
    @NotBlank(message = "* Email is required")
    @Email(message = "* Email format : example@xyw.com")
    private String email;

    @Column(nullable=false)
    @Size(min=8)
    @NotBlank(message = "* password is required")
    private String password;


    @Column
    private String loginStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "roleUser")
    private RoleUser roleUser;


    private boolean active;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "addressId")
    private ShippingAddress shoppingAddress;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "shoppingCartId")
    private ShoppingCart shoppingCart;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Order> order;

    public UserAccount(@NotBlank(message = "* First Name is required") String firstName,
                       @NotBlank(message = "* Last Name is required") String lastName, @NotBlank(message = "* Email is required") String email, @Size(min = 1) @NotBlank(message = "* password is required") String password, String loginStatus, RoleUser roleUsers) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.loginStatus = loginStatus;
        this.roleUser = roleUsers;
    }

    public int getUserAccountId() {
        return userAccountId;
    }

    public void setUserAccountId(int userAccountId) {
        this.userAccountId = userAccountId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(String loginStatus) {
        this.loginStatus = loginStatus;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserProfilePic() {
        return userProfilePic;
    }

    public void setUserProfilePic(String userProfilePic) {
        this.userProfilePic = userProfilePic;
    }

    public RoleUser getRoleUser() {
        return roleUser;
    }

    public void setRoleUser(RoleUser roleUser) {
        this.roleUser = roleUser;
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

    @Override
    public String toString() {
        return "UserAccount{" +
                "userProfilePic='" + userProfilePic + '\'' +
                ", userAccountId=" + userAccountId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", loginStatus='" + loginStatus + '\'' +
                ", roleUser=" + roleUser +
                ", active=" + active +
                '}';
    }
}
