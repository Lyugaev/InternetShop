package net.lyugaev.shop.service;

import java.util.List;

import net.lyugaev.shop.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.lyugaev.shop.dao.ProductDao;

@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao dao;

    public Product findById(int id) {
        return dao.findById(id);
    }

    public void saveProduct(Product product) {
        dao.saveProduct(product);
    }

    public void updateProduct(Product product) {
        Product entity = dao.findById(product.getId());
        if(entity!=null){
            entity.setName(product.getName());
            entity.setAddedDate(product.getAddedDate());
            entity.setPrice(product.getPrice());
            entity.setDescription(product.getDescription());
        }
    }

    public void deleteProductById(int id) {
        dao.deleteProductById(id);
    }

    public List<Product> findAllProducts() {
        return dao.findAllProducts();
    }
}