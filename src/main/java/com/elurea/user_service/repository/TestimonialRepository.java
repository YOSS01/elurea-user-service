package com.elurea.user_service.repository;

import com.elurea.user_service.entity.Testimonial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TestimonialRepository extends JpaRepository<Testimonial, UUID> {
    List<Testimonial> findAll();

    Optional<Testimonial> findById(UUID id);

    Testimonial save(Testimonial testimonial);
}
