package com.apache.controller;

import com.apache.model.ShippingAddress;

import com.apache.service.ShippingAddressService;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost"}, allowedHeaders = "*")
@RequestMapping(value = "/eartwork/api/shippingaddress", produces = MediaType.APPLICATION_JSON_VALUE)
public class ShippingAddressController {
    private ShippingAddressService shippingAddressService;

    public ShippingAddressController(ShippingAddressService shippingAddressService) {
        this.shippingAddressService = shippingAddressService;
    }

    @GetMapping(value = {"/list"})
    public List<ShippingAddress> getShippingAdresses() {
        return shippingAddressService.getAllShippingAddresses();
    }

    @PostMapping(value = "/add")
    public ShippingAddress addNewShippingAddress(@Valid @RequestBody ShippingAddress shippingAddress) {
        return shippingAddressService.createNewShippingAddress(shippingAddress);
    }

    @GetMapping(value = "/get/{zipcode}")
    public Optional<ShippingAddress> getUserAccountByEmail(@PathVariable String zipcode) {
        return shippingAddressService.getShippingAddressByZipcode(zipcode);
    }

    @PutMapping(value = "/update/{shippingAddressId}")
    public ShippingAddress updateBook(@Valid @RequestBody ShippingAddress editedShippingAddress, @PathVariable Long shippingAddressId) {
        return shippingAddressService.updateShippingAddressById(editedShippingAddress, shippingAddressId);
    }

    @DeleteMapping(value = "/delete/{shippingAddressId}")
    public void deleteShippingAddress(@PathVariable Long shippingAddressId) {
        shippingAddressService.deleteShippingAddressById(shippingAddressId);
    }

}
