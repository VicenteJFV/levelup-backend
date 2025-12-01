package com.example.levelup_backend.gamer.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String category;

    private Integer price;
    private Integer stock;

    @Column(length = 1000)
    private String description;

    private String imageUrl;
}
