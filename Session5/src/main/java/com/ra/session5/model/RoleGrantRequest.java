package com.ra.session5.model;

import lombok.Data;

import java.util.List;

@Data
public class RoleGrantRequest {
    private String userId;
    private List<String> roles;
}
