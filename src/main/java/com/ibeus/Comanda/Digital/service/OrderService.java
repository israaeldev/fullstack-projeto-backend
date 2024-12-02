package com.ibeus.Comanda.Digital.service;

import com.ibeus.Comanda.Digital.model.Dish;
import com.ibeus.Comanda.Digital.model.Order;
import com.ibeus.Comanda.Digital.repository.ClientRepository;
import com.ibeus.Comanda.Digital.repository.DishRepository;
import com.ibeus.Comanda.Digital.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
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

        for (Dish produto : order.getProduct()){
            if (produto.getId() != null) {
                 Dish produtoexistente = kiwi.findById(produto.getId())
                         .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto nao encontrado."));
                 produtos_persistidos.add(produtoexistente);

            }

        }

        order.setProduct(produtos_persistidos);


        return banana.save(order);


    }

    public Order getOrderById(int id) {
        return banana.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido não encontrado"));
    }

    public List<Order> recuparaPedidos (){
         List<Order> pedidos =banana.findAll();
         return pedidos;
    }

    public Order atualizar(Order morango){
        Order pedidoAtualizado = null;
        //Cliente
        if (Integer.valueOf(morango.getId()) != null){
            //vamos atualizar
            pedidoAtualizado = banana.findById(morango.getId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido não encontrado"));
        }
        // vamos criar
        pedidoAtualizado.setStatus(morango.getStatus());

        banana.save(pedidoAtualizado);
        return pedidoAtualizado;
    }



}
