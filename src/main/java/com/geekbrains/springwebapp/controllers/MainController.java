package com.geekbrains.springwebapp.controllers;

import com.geekbrains.springwebapp.entities.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainController {
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
        Product[] products = {
                new Product(1L, "Milk", 80),
                new Product(2L, "Cheese", 320),
                new Product(3L, "Ball", 200)
        };

        model.addAttribute("selectedProduct", products[id.intValue() - 1]);
        return "details";
    }
}
