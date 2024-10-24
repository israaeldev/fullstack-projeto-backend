package com.ibeus.Comanda.Digital.repository;

import com.ibeus.Comanda.Digital.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Integer> {

}
