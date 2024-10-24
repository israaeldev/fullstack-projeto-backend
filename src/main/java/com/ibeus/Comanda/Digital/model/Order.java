package com.ibeus.Comanda.Digital.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String status;

    @ManyToMany
    @JoinTable(
            name = "orders_dish",
            joinColumns = @JoinColumn(name = "orders_id"),
            inverseJoinColumns = @JoinColumn(name = "dish_id")
    )
    private List<Dish> product;

    @ManyToOne
    @JoinColumn(name = "idclient")
    private Client idcliente;

}
