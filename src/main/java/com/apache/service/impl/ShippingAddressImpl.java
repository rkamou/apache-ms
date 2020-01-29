package com.apache.service.impl;

import com.apache.model.ShippingAddress;
import com.apache.repository.ShippingAddressRepository;
import com.apache.service.ShippingAddressService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShippingAddressImpl implements ShippingAddressService {
    private ShippingAddressRepository ShippingAddressRepository;

    public ShippingAddressImpl(ShippingAddressRepository ShippingAddressRepository) {
        this.ShippingAddressRepository = ShippingAddressRepository;
    }

    @Override
    public ShippingAddress createNewShippingAddress(ShippingAddress ShippingAddress) {
        return ShippingAddressRepository.save(ShippingAddress);
    }

    @Override
    public List<ShippingAddress> getAllShippingAddresses() {
        return ShippingAddressRepository.findAll(Sort.by("zipcode"));
    }



    @Override
    public Optional<ShippingAddress> getShippingAddressByZipcode(String zipcode) {
        return ShippingAddressRepository.findByZipcode(zipcode);
    }

    @Override
    public ShippingAddress updateShippingAddressById(ShippingAddress editedShippingAddress, Long ShippingAddressId) {
        return ShippingAddressRepository.findById(ShippingAddressId)
                .map(addressToBeUpdated -> {
                    addressToBeUpdated.setCity(editedShippingAddress.getCity());
                    addressToBeUpdated.setState(editedShippingAddress.getState());
                    addressToBeUpdated.setStreet(editedShippingAddress.getStreet());
                    addressToBeUpdated.setZipcode(editedShippingAddress.getZipcode());
                    return ShippingAddressRepository.save(addressToBeUpdated);
                }).orElseGet(() -> {
                    return ShippingAddressRepository.save(editedShippingAddress);
                });
    }

    @Override
    public void deleteShippingAddressById(Long shippingAddressId) {
        ShippingAddressRepository.deleteById(shippingAddressId);
    }


}

