package net.lyugaev.shop.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import net.lyugaev.shop.model.Product;

@Repository("productDao")
public class ProductDaoImpl extends AbstractDao<Integer, Product> implements ProductDao {

    public Product findById(int id) {
        return getByKey(id);
    }

    public void saveProduct(Product product) {
        persist(product);
    }

    public void deleteProductById(int id) {
        Query query = getSession().createSQLQuery("delete from Product where id = :id");
        query.setInteger("id", id);
        query.executeUpdate();
    }

    @SuppressWarnings("unchecked")
    public List<Product> findAllProducts() {
        Criteria criteria = createEntityCriteria();
        return (List<Product>) criteria.list();
    }
}