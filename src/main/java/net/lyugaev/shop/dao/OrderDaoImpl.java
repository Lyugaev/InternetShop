package net.lyugaev.shop.dao;

import java.util.List;

import net.lyugaev.shop.entity.Account;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import net.lyugaev.shop.entity.Order;

@Repository("orderDao")
public class OrderDaoImpl extends AbstractDao<Order> implements OrderDao {

    public Order findById(int id) {
        Criteria crit = getSession().createCriteria(Order.class);
        crit.add(Restrictions.eq("id", id));
        return (Order) crit.uniqueResult();
    }

    public void saveOrder(Order order) {
        persist(order);
    }

    @SuppressWarnings("unchecked")
    public List<Order> findAllOrders() {
        Criteria crit = getSession().createCriteria(Order.class);
        return (List<Order>) crit.list();
    }
}