package com.elurea.user_service.repository;

import com.elurea.user_service.entity.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface SubscriberRepository extends JpaRepository<Subscriber, UUID> {
    List<Subscriber> findAll();

    Optional<Subscriber> findById(UUID id);

    Subscriber findByEmail(String email);

    Subscriber save(Subscriber subscriber);
}
