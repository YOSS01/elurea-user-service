package com.elurea.user_service.service;

import com.elurea.user_service.dto.SubscribeRequest;
import com.elurea.user_service.dto.UnsubscribeRequest;
import com.elurea.user_service.entity.Subscriber;
import com.elurea.user_service.entity.User;
import com.elurea.user_service.repository.SubscriberRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SubscriberService {
    private final SubscriberRepository subscriberRepository;

    public SubscriberService(SubscriberRepository subscriberRepository) {
        this.subscriberRepository = subscriberRepository;
    }

    // Get All Subscribers
    public List<Subscriber> getAll() {
        return subscriberRepository.findAll();
    }

    // Subscribe to the newsletter
    public Subscriber subscribe(SubscribeRequest request) {
        Subscriber subscriber = subscriberRepository.findByEmail(request.email);

        if (subscriber == null) {
            subscriber = new Subscriber();

            subscriber.setEmail(request.email);
            subscriber.setActive(true);
            subscriber.setSubscribedAt(LocalDateTime.now());
        } else {
            if (!subscriber.isActive()) {
                subscriber.setActive(true);
                subscriber.setSubscribedAt(LocalDateTime.now());
            } else {
                throw new RuntimeException("You are already subscribed");
            }
        }

        return subscriberRepository.save(subscriber);
    }

    // Unsubscribe from the newsletter
    public Subscriber unsubscribe(UnsubscribeRequest request) {
        Subscriber subscriber = subscriberRepository.findById(request.id).orElseThrow(() -> new RuntimeException("Subscriber not found"));

        subscriber.setActive(false);
        subscriber.setUnSubscribedAt(LocalDateTime.now());

        return subscriberRepository.save(subscriber);
    }
}
