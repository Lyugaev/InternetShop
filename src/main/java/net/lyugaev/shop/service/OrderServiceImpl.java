package net.lyugaev.shop.service;

import net.lyugaev.shop.dao.OrderDao;
import net.lyugaev.shop.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("orderService")
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao dao;

    public Order findById(int id) {
        return dao.findById(id);
    }

    public void saveOrder(Order order) {
        dao.saveOrder(order);
    }

    public List<Order> findAllOrders() {
        return dao.findAllOrders();
    }
}