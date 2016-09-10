package net.lyugaev.shop.service;

import net.lyugaev.shop.dao.OrderDao;
import net.lyugaev.shop.entity.Account;
import net.lyugaev.shop.entity.Order;
import org.hamcrest.core.IsEqual;
import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.CoreMatchers.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

/**
 * Created by dmitry on 10.09.16.
 */
public class OrderServiceTest {

    private OrderServiceImpl orderService;
    private OrderDao dao;

    @Before
    public void setup() {
        orderService = new OrderServiceImpl();
        dao = mock(OrderDao.class);
        orderService.dao = dao;
    }

    @Test
    public void findById_Ok_Test() {
        Order order = new Order();
        order.setId(3);
        when(dao.findById(3)).thenReturn(order);

        Order order1 = orderService.findById(3);

        verify(dao).findById(3);
        assertThat(order1.getId(), equalTo(3));
    }

    @Test
    public void saveOrder_Ok_Test() {
        Order order = new Order();

        orderService.saveOrder(order);

        verify(dao, times(1)).saveOrder(order);
    }

    @Test
    public void findAllOrders_Ok_Test() {
        List<Order> orderList = new ArrayList<Order>();
        orderList.add(new Order());
        orderList.add(new Order());
        orderList.add(new Order());
        when(dao.findAllOrders()).thenReturn(orderList);

        List<Order> testList = new ArrayList<Order>();
        testList = orderService.findAllOrders();

        verify(dao).findAllOrders();
        assertThat(testList.size(), equalTo(3));
    }
}
