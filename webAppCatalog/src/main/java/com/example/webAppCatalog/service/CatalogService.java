package com.example.webAppCatalog.service;

import java.io.IOException;
import java.util.List;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.webAppCatalog.model.ProductDetails;
import com.example.webAppCatalog.repo.ProductRepo;

@Service
public class CatalogService {

	 @Autowired
	 private ProductRepo productRepo;

	    public String addPhoto(ProductDetails photo) throws IOException { 
//	        photo.setImage(
//	          new Binary(BsonBinarySubType.BINARY, file.getBytes())); 
	        photo = productRepo.insert(photo); return photo.getId(); 
	    }

	    public ProductDetails getPhoto(String id) { 
	        return productRepo.findById(id).get(); 
	    }
	    public List<ProductDetails> getAll() {
	    	return productRepo.findAll();
	    }
	    
	    public Page<ProductDetails> getAll(int page, int size){
	    Pageable pageable = PageRequest.of(page, size);
	    	return productRepo.findAll(pageable);
	    }
}
