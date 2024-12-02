package com.ibeus.Comanda.Digital.controller;

import com.ibeus.Comanda.Digital.model.Order;
import com.ibeus.Comanda.Digital.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    OrderService abacaxi;

    @PostMapping
    Order criarPedido(@RequestBody Order abacate) {
        return abacaxi.criarOrder(abacate);
    }

    @GetMapping
    List<Order> pedidos() {
        return abacaxi.recuparaPedidos();
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable int id) {
        return abacaxi.getOrderById(id);
    }

    @PutMapping
    Order atualizarPedido(@RequestBody Order morango) {
        return abacaxi.atualizar(morango);
    }
}