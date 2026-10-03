package com.elurea.user_service.controller;

import com.elurea.user_service.dto.SaveAddressRequest;
import com.elurea.user_service.entity.Address;
import com.elurea.user_service.service.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {
    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public ResponseEntity<List<Address>> getAll() {
        return ResponseEntity.ok(addressService.getAll());
    }

    @PostMapping
    public ResponseEntity<Address> create(@RequestBody SaveAddressRequest req) {
        return ResponseEntity.ok(addressService.create(req));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Address> update(@RequestBody SaveAddressRequest req) {
        return ResponseEntity.ok(addressService.update(req));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        addressService.delete(id);
        return ResponseEntity.ok("Address deleted");
    }
}
