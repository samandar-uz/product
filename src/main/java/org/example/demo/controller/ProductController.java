package org.example.demo.controller;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.demo.dto.ProductDTO;
import org.example.demo.entity.Attachment;
import org.example.demo.entity.Product;
import org.example.demo.repo.ProductRepository;
import org.example.demo.service.FileService;
import org.example.demo.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller


@RequiredArgsConstructor
public class ProductController {
    private final FileService fileService;
    private final ProductService productService;
    private final ProductRepository productRepository;

    @Transactional
    @PostMapping("/products")
    public String addProduct(@RequestParam MultipartFile photo, @ModelAttribute ProductDTO productDTO) {
        Attachment attachment = fileService.saveFile(photo);
        Product product = new Product();
        product.setPhoto(attachment);
        product.setName(productDTO.name());
        product.setPrice(productDTO.price());
        product.setDescription(productDTO.description())        ;
        productRepository.save(product);
        return "redirect:/";
    }

    @PostMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable Integer id) {
        productService.deleteProduct(id);
        return "redirect:/";
    }

}
