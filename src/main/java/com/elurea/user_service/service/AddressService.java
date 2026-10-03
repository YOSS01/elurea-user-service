package com.elurea.user_service.service;

import com.elurea.user_service.dto.SaveAddressRequest;
import com.elurea.user_service.entity.Address;
import com.elurea.user_service.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AddressService {
    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    // Get All Addresses
    public List<Address> getAll() {
        return addressRepository.findAll();
    }

    // Create New Address
    public Address create(SaveAddressRequest request) {
        Address address = new Address();

        if(request.userId != null) address.setUserId(request.userId);
        address.setAddressLine1(request.addressLine1);
        if(request.addressLine2 != null) address.setAddressLine2(request.addressLine2);
        address.setCountry(request.country);
        address.setCity(request.city);
        address.setState(request.state);
        address.setPostalCode(request.postalCode);

        return addressRepository.save(address);
    }

    // Update Address
    public Address update(SaveAddressRequest request) {
        if(request.id == null) throw new RuntimeException("Address ID is required");
        Address address = addressRepository.findById(request.id).orElseThrow(() -> new RuntimeException("Address not found"));

        if(request.userId != null) address.setUserId(request.userId);
        if(request.addressLine1 != null) address.setAddressLine1(request.addressLine1);
        if(request.addressLine2 != null) address.setAddressLine2(request.addressLine2);
        if(request.country != null) address.setCountry(request.country);
        if(request.city != null) address.setCity(request.city);
        if(request.state != null) address.setState(request.state);
        if(request.postalCode != null) address.setPostalCode(request.postalCode);

        return addressRepository.save(address);
    }

    // Delete Address
    public void delete(UUID id) {
        if(id == null) throw new RuntimeException("Address ID is required");
        Address address = addressRepository.findById(id).orElseThrow(() -> new RuntimeException("Address not found"));

        addressRepository.deleteById(address.getId());
    }
}
