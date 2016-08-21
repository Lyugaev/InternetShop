package net.lyugaev.shop.service;

import java.util.List;

import net.lyugaev.shop.model.Product;

public interface ProductService {

    Product findById(int id);

    void saveProduct(Product product);

    void updateProduct(Product product);

    void deleteProductBySku(String sku);

    List<Product> findAllProducts();

    Product findProductBySku(String sku);

    boolean isProductSkuUnique(Integer id, String sku);

}