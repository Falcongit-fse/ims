package com.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.entity.Product;
import com.inventory.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	ProductService service;
	@GetMapping("/ims/getAllProducts")
	public List<Product> getAllProducts(){
		
		return service.getAllProducts();
	}
	@PostMapping("/ims/createProduct")
	public ResponseEntity<String> createProduct(@RequestBody Product product){
		return service.createProduct(product);
	}
	@PutMapping("/ims/updateProduct")
	public ResponseEntity<String> updateProduct(@RequestBody Product product){
		return service.updateProduct(product);
		
	}
	@DeleteMapping("/ims/deleteProduct/{productId}")
	public ResponseEntity<String> deleteProduct(@PathVariable Integer productId){
		return service.deleteProduct(productId);
		
	}
	@GetMapping("/ims/getProductById/{productId}")
	public Product getProductById(@PathVariable Integer productId){
		return service.getProductById(productId);
		
	}
}
