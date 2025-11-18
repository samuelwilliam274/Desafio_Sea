package com.example.desafio.controller;

import com.example.desafio.model.Product;
import com.example.desafio.service.ProductService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service){ this.service = service; }

    @GetMapping
    public List<Product> list(){ return service.findAll(); }

    @PostMapping
    public Product create(@RequestBody Product p){ return service.save(p); }
}
