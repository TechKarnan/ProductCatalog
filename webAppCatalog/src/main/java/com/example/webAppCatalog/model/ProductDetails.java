package com.example.webAppCatalog.model;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "Product")
@Data
public class ProductDetails {

	@Id
	private String id;
	private String productName;
	private String productDescription;
	private Binary image;
}
