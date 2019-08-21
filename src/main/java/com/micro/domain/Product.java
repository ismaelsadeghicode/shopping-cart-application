package com.micro.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Ismael Sadeghi, 8/19/2019 8:50 AM
 */

@Data
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, unique = true)
    private String code;
    @Column(nullable = false)
    private String name;
    private String description;
    private double price;
}
