package org.example.demo.controller;

import org.example.demo.repo.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    private final ProductRepository productRepository;

    public PageController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public String getHomePage(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "index";
    }

    @GetMapping("product/add")
    public String addProduct() {
        return "add-product";
    }
}
