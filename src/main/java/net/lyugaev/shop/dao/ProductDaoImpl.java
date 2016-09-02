package net.lyugaev.shop.dao;

import java.util.List;

import net.lyugaev.shop.entity.Account;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import net.lyugaev.shop.entity.Product;

@Repository("productDao")
public class ProductDaoImpl extends AbstractDao<Product> implements ProductDao {

    public Product findById(int id) {
        Criteria crit = getSession().createCriteria(Product.class);
        crit.add(Restrictions.eq("id", id));
        return (Product) crit.uniqueResult();
    }

    public void saveProduct(Product product) {
        persist(product);
    }

    @SuppressWarnings("unchecked")
    public List<Product> findAllProducts() {
        Criteria crit = getSession().createCriteria(Product.class);
        return (List<Product>) crit.list();
    }
}