package net.lyugaev.shop.dao;

import java.util.List;

import net.lyugaev.shop.entity.Order;

public interface OrderDao {

    Order findById(int id);

    void saveOrder(Order order);

    List<Order> findAllOrders();
}