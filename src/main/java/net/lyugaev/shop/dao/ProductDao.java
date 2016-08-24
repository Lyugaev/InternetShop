package net.lyugaev.shop.dao;

import java.util.List;

import net.lyugaev.shop.model.Product;

public interface ProductDao {

    Product findById(int id);

    void saveProduct(Product product);

    void deleteProductById(int id);

    List<Product> findAllProducts();
}