package org.example.products.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.products.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Tag(name = "Product Api")
@RequestMapping("/products")
public interface ProductApi {

    @GetMapping
    @Operation(summary = "get all products")
    ResponseEntity<List<Product>> getAll();

    @GetMapping("/{id}")
    @Operation(summary = "get product by id")
    ResponseEntity<Product> getById(@PathVariable Long id);
}
