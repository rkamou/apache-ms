package com.apache.service;

import com.apache.model.Order;

import java.util.List;

public interface OrderService {
    public Order save(Order order);
    public List<Order> getOrders();

    public Order getOrderById(long id);

    public Order updateOrder(Order order);
    public void deleteOrder(long orderId);
}
