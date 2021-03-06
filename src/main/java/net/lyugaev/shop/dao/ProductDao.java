package net.lyugaev.shop.dao;

import java.util.List;

import net.lyugaev.shop.entity.Product;

public interface ProductDao {

    Product findById(int id);

    void saveProduct(Product product);

    List<Product> findAllProducts();
}