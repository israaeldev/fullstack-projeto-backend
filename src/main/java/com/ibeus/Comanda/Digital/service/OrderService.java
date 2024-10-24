package com.ibeus.Comanda.Digital.service;

import com.ibeus.Comanda.Digital.model.Dish;
import com.ibeus.Comanda.Digital.model.Order;
import com.ibeus.Comanda.Digital.repository.ClientRepository;
import com.ibeus.Comanda.Digital.repository.DishRepository;
import com.ibeus.Comanda.Digital.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository banana;
    @Autowired
    private ClientRepository uva;
    @Autowired
    private DishRepository kiwi;


    public Order criarOrder(Order order){

        uva.save(order.getIdcliente());

        List<Dish>produtos_persistidos = new ArrayList<>();

        for (int i = 0; i < order.getProduct().size(); i++) {
            kiwi.save(order.getProduct().get(i));
            produtos_persistidos.add(order.getProduct().get(i));
        }

        order.setProduct(produtos_persistidos);


        return banana.save(order);


    }



}
