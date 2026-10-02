package com.elurea.user_service.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public class SubscribeRequest {
    public UUID id;
    public String userId;
    public String email;
    public boolean isActive;
    public LocalDateTime subscribedAt;
    public LocalDateTime unSubscribedAt;
}
