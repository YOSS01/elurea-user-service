package com.elurea.user_service.dto;

import com.elurea.user_service.enums.Title;

public class RegisterRequest {
    public Title title;
    public String name;
    public String email;
    public String password;
    public String phoneNumber;
}
