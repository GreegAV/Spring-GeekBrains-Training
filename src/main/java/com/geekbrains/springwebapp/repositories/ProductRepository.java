package com.geekbrains.springwebapp.repositories;

import com.geekbrains.springwebapp.entities.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    @PostConstruct
    public void init() {
        products = new ArrayList<>();
        products.add(new Product(1L, "Milk", 80));
        products.add(new Product(2L, "Cheese", 320));
        products.add(new Product(3L, "Ball", 200));
        products.add(new Product(4L, "Cocoa", 100));
    }
}
