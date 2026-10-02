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

    // Getter and Setter

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public LocalDateTime getSubscribedAt() {
        return subscribedAt;
    }

    public void setSubscribedAt(LocalDateTime subscribedAt) {
        this.subscribedAt = subscribedAt;
    }

    public LocalDateTime getUnSubscribedAt() {
        return unSubscribedAt;
    }

    public void setUnSubscribedAt(LocalDateTime unSubscribedAt) {
        this.unSubscribedAt = unSubscribedAt;
    }
}
