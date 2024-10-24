package com.ibeus.Comanda.Digital.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private Double price;
}