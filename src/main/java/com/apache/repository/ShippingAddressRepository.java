package com.apache.repository;

import com.apache.model.ShippingAddress; 
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShippingAddressRepository extends JpaRepository<ShippingAddress,Long> {
    Optional<ShippingAddress> findByZipcode(String zipcode);

}
