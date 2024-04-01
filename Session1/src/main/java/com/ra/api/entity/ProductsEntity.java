package com.ra.api.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.Date;

@Data
@Entity
@Table(name = "products", schema = "store_manager")
public class ProductsEntity {
    @Id
    @Column(name = "Product_Id", nullable = false, length = 5)
    private String productId;
    @Column(name = "Product_Name", nullable = false, length = 150)
    private String productName;
    @Column(name = "Manufacturer", nullable = false, length = 200)
    private String manufacturer;
    @Column(name = "Created", nullable = true)
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Column(name = "Batch", nullable = false)
    private short batch;
    @Column(name = "Quantity", nullable = false)
    private int quantity;
    @Column(name = "Product_Status", nullable = true)
    private Boolean productStatus;
}
