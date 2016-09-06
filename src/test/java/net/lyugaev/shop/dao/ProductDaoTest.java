package net.lyugaev.shop.dao;

import net.lyugaev.shop.entity.Product;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Before;
import org.junit.Test;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;

/**
 * Created by dmitry on 05.09.16.
 */
public class ProductDaoTest {

    private ProductDao productDao;
    private Product product;
    private Session sessionMock;
    private Criteria criteriaMock;

    @Before
    public void init() {
        productDao = new ProductDaoImpl();
        product = new Product();
        sessionMock = createMock(Session.class);
        criteriaMock = createMock(Criteria.class);
    }

    @Test
    public void findById() {
        productDao.findById(3);


    }

}
