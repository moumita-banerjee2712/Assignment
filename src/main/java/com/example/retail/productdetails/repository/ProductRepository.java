package com.example.retail.productdetails.repository;

import com.example.retail.productdetails.document.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, Long> {
}
