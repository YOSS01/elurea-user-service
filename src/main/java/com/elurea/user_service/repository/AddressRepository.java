package com.elurea.user_service.repository;

import com.elurea.user_service.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AddressRepository extends JpaRepository<Address, UUID> {
    List<Address> findAll();

    Optional<Address> findById(UUID id);

    Address save(Address address);

    void deleteById(UUID id);
}
