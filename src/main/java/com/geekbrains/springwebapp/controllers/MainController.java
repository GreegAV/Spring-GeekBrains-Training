package com.geekbrains.springwebapp.controllers;

import com.geekbrains.springwebapp.entities.Product;
import com.geekbrains.springwebapp.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainController {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/index")
    public String homePage() {
        return "index";
    }

    @GetMapping("/shop")
    public String shopPage(Model model) {
        Product product =
                new Product(4L, "Cocoa", 100);
        model.addAttribute("prod", product);
        return "shop";
    }

    @GetMapping("/details/{id}")
    public String detailsPage(Model model, @PathVariable("id") Long id) {
        Product selectedProduct = productService.getProducts().get(id.intValue() - 1);
        model.addAttribute("selectedProduct", selectedProduct);
        return "details";
    }
}
