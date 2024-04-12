package com.ra.session5.model;

import lombok.Data;

@Data
public class TokenResponse {
    private String token;
    private String tokenType = "Bearer";
}
