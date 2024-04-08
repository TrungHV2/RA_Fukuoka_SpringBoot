package com.ra.session41.model;

import lombok.Data;

@Data
public class ProductRequest {
    private String id;
    private String name;
    private float price;
    private boolean status;
}
