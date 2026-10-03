package com.elurea.user_service.controller;

import com.elurea.user_service.dto.SaveTestimonialRequest;
import com.elurea.user_service.entity.Testimonial;
import com.elurea.user_service.service.TestimonialService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/testimonials")
public class TestimonialController {
    private final TestimonialService testimonialService;

    public TestimonialController(TestimonialService testimonialService) {
        this.testimonialService = testimonialService;
    }

    @GetMapping
    public ResponseEntity<List<Testimonial>> getAll() {
        return ResponseEntity.ok(testimonialService.getAll());
    }

    @PostMapping
    public ResponseEntity<Testimonial> create(@RequestBody SaveTestimonialRequest request) {
        return ResponseEntity.ok(testimonialService.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Testimonial> update(@RequestBody SaveTestimonialRequest request) {
        return ResponseEntity.ok(testimonialService.update(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> softDelete(@PathVariable UUID id) {
        testimonialService.delete(id);
        return ResponseEntity.ok("Testimonial deleted");
    }
}
