package org.example.products.service;

import org.example.products.model.Product;
import org.example.products.persistence.ProductEntity;
import org.example.products.persistence.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ConversionService conversionService;

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll() {
        return productRepository.findAll()
                .stream()
                .map(entity -> conversionService.convert(entity, Product.class))
                .collect(Collectors.toList());
    }

    public Product getById(Long id) {
        ProductEntity productEntity = productRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return conversionService.convert(productEntity, Product.class);
    }
}
