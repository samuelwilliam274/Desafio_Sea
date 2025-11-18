package com.example.desafio.service;

import com.example.desafio.model.Product;
import com.example.desafio.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository repo;

    public ProductService(ProductRepository repo){ this.repo = repo; }

    public List<Product> findAll(){ return repo.findAll(); }
    public Product save(Product p){ return repo.save(p); }
}
