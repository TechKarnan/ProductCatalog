package com.example.webAppCatalog.repo;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.webAppCatalog.model.ProductDetails;

public interface ProductRepo extends MongoRepository<ProductDetails, String>{

	Page<ProductDetails> findAll(Pageable pageable);
}
