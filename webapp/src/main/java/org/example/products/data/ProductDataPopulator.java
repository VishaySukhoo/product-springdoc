package org.example.products.data;

import org.example.products.persistence.ProductEntity;
import org.example.products.persistence.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

@Service
public class ProductDataPopulator implements ApplicationRunner {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(ApplicationArguments args) {
        for (int i = 0; i < 5; i++) {
            ProductEntity productEntity = new ProductEntity();
            productEntity.setName("p" + i);
            productRepository.save(productEntity);
        }
    }

}
