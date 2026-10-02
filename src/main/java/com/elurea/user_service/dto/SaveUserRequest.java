package com.elurea.user_service.dto;

import com.elurea.user_service.enums.Role;
import com.elurea.user_service.enums.Title;

import java.util.UUID;

public class SaveUserRequest {
    public UUID id;
    public Title title;
    public String name;
    public String email;
    public String password;
    public String phoneNumber;
    public Role role;
    public String avatar;
}
