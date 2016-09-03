package net.lyugaev.shop.service;

import net.lyugaev.shop.entity.Order;

import java.util.List;

public interface OrderService {

    Order findById(int id);

    void saveOrder(Order order);

    List<Order> findAllOrders();
}