package com.elurea.user_service.entity;

import jakarta.persistence.*;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "subscriber")
public class Subscriber {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String userId;

    @Column(nullable = false, unique = true)
    private String email;

    private boolean isActive = false;

    private LocalDateTime subscribedAt;
    private LocalDateTime unSubscribedAt;
}
