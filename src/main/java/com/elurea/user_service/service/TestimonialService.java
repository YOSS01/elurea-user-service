package com.elurea.user_service.service;

import com.elurea.user_service.dto.SaveTestimonialRequest;
import com.elurea.user_service.entity.Testimonial;
import com.elurea.user_service.entity.User;
import com.elurea.user_service.repository.TestimonialRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class TestimonialService {
    private final TestimonialRepository testimonialRepository;

    public TestimonialService(TestimonialRepository testimonialRepository) {
        this.testimonialRepository = testimonialRepository;
    }

    // Get All Testimonials
    public List<Testimonial> getAll() {
        return testimonialRepository.findAll();
    }

    // Create New Testimonial
    public Testimonial create(SaveTestimonialRequest request) {
        Testimonial testimonial = new Testimonial();

        testimonial.setUserId(request.userId);
        testimonial.setMessage(request.message);
        testimonial.setRating(request.rating);

        return testimonialRepository.save(testimonial);
    }

    // Update Testimonial
    public Testimonial update(SaveTestimonialRequest request) {
        Testimonial testimonial = testimonialRepository.findById(request.id)
                .orElseThrow(() -> new RuntimeException("Testimonial not found"));

        if(request.message != null) testimonial.setMessage(request.message);
        testimonial.setRating(request.rating);

        return testimonialRepository.save(testimonial);
    }

    // Soft Delete Testimonial
    public void delete(UUID id) {
        Testimonial testimonial = testimonialRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Testimonial not found"));

        testimonial.setDeletedAt(LocalDateTime.now());

        testimonialRepository.save(testimonial);
    }
}
