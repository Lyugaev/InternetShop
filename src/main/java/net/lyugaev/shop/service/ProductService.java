package net.lyugaev.shop.service;

import java.util.List;

import net.lyugaev.shop.entity.Product;

public interface ProductService {

    Product findById(int id);

    void saveProduct(Product product);

    void updateProduct(Product product);

    List<Product> findAllProducts();
}