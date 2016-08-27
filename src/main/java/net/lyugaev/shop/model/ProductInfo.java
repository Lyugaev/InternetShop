package net.lyugaev.shop.model;

import net.lyugaev.shop.entity.Product;

/**
 * Created by dmitry on 25.08.16.
 */
public class ProductInfo {

    private int id;
    private String name;
    private double price;

    public ProductInfo() {
    }

    public ProductInfo(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
    }

    public ProductInfo(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
