package com.elurea.user_service.dto;


import java.util.UUID;

public class SaveAddressRequest {
    public UUID id;
    public String userId;
    public String addressLine1;
    public String addressLine2;
    public String city;
    public String state;
    public String country;
    public String postalCode;
}
