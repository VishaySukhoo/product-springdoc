package org.example.products.service.converter;

import org.example.products.model.Product;
import org.example.products.persistence.ProductEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter implements Converter<ProductEntity, Product> {

    @Override
    public Product convert(ProductEntity entity) {
        var dto = new Product();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }
}
