package net.lyugaev.shop.dao;

import net.lyugaev.shop.entity.Product;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Before;
import org.junit.Test;

import static org.easymock.EasyMock.createMock;

/**
 * Created by dmitry on 05.09.16.
 */
public class ProductDaoTest {

    private Session mock;

    @Before
    public void init() {
        mock = createMock(Session.class);
    }

    @Test
    public void findById() {
        Criteria crit = mock.createCriteria(Product.class);
        crit.add(Restrictions.eq("id", 3));
        //return (Product) crit.uniqueResult();

    }

}
