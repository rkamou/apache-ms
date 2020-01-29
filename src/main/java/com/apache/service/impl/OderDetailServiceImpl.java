package com.apache.service.impl;

import com.apache.model.OrderDetail;
import com.apache.repository.OrderDetailRepository;
import com.apache.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OderDetailServiceImpl implements OrderDetailService {
    @Autowired
    OrderDetailRepository orderDetailRepository;
    @Override
    public OrderDetail save(OrderDetail orderDetail) {
        return orderDetailRepository.save(orderDetail);
    }

    @Override
    public List<OrderDetail> getOrders() {
        return orderDetailRepository.findAll();
    }

    @Override
    public OrderDetail getOrderDetailById(long id) {
        return orderDetailRepository.findById(id).orElse(null);
    }

    @Override
    public OrderDetail updateOrderDetail(OrderDetail orderDetail) {
        return orderDetailRepository.save(orderDetail);
    }

    @Override
    public void deleteOrderDetailById(long orderDetailId) {
        orderDetailRepository.deleteById(orderDetailId);
    }

    @Override
    public void deleteOrderDetail(OrderDetail order) {
        orderDetailRepository.delete(order);
    }
}
