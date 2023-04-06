package com.example.webAppCatalog.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.webAppCatalog.model.ProductDetails;
import com.example.webAppCatalog.service.CatalogService;

import ch.qos.logback.core.model.Model;

@RestController
public class Controller {
	
	@Autowired
	private CatalogService CatalogService;
	
	

	@GetMapping(value = "/test")
	public String test() {
		return "hello mongo";
	}
	
	@PostMapping("/photos/add")
	public String addPhoto(@RequestBody ProductDetails productDetails) 
	  throws IOException {
	    String id =CatalogService.addPhoto(productDetails);
	    return "redirect:/photos/" + id;
	}
	
	
	@GetMapping("/getAll")
	public List<ProductDetails> getAll() {
		return CatalogService.getAll();
	}
	
	@GetMapping("/getPage")
	public List<ProductDetails> getAll(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "3") int size) {
		return CatalogService.getAll(page,size).getContent();
	}
}
