package com.intercafe.admin.service;

import com.intercafe.admin.model.OrdersModel;
import com.intercafe.admin.repository.OrdersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrdersRepository ordersRepository;

    public OrderService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }
    public List<OrdersModel> getAll(){
        return ordersRepository.getAllOrders();
    }
}
