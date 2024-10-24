package com.ibeus.Comanda.Digital.controller;

import com.ibeus.Comanda.Digital.model.Order;
import com.ibeus.Comanda.Digital.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    OrderService abacaxi;

    @PostMapping
    Order criarPedido(@RequestBody Order abacate){
        return abacaxi.criarOrder(abacate);

    }

}
