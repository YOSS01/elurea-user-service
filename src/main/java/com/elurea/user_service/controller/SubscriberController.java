package com.elurea.user_service.controller;

import com.elurea.user_service.dto.SubscribeRequest;
import com.elurea.user_service.entity.Subscriber;
import com.elurea.user_service.service.SubscriberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/subscribers")
public class SubscriberController {
    private final SubscriberService subscriberService;

    public SubscriberController(SubscriberService subscriberService) {
        this.subscriberService = subscriberService;
    }

    @GetMapping
    public ResponseEntity<List<Subscriber>> getAll() {
        return ResponseEntity.ok(subscriberService.getAll());
    }

    @PostMapping
    public ResponseEntity<Subscriber> subscribe(@RequestBody SubscribeRequest request) {
        return ResponseEntity.ok(subscriberService.subscribe(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Subscriber> unsubscribe(@PathVariable UUID id) {
        return ResponseEntity.ok(subscriberService.unsubscribe(id));
    }
}
