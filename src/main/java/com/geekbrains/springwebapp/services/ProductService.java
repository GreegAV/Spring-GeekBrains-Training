package com.geekbrains.springwebapp.services;

import com.geekbrains.springwebapp.entities.Product;
import com.geekbrains.springwebapp.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getProductById(Long id) {
       return productRepository.getProducts().get(id.intValue()-1);
    }

}
