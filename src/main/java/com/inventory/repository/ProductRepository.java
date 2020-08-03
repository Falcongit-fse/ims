package com.inventory.repository;

import org.springframework.data.repository.CrudRepository;

import com.inventory.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {
	public Product findByProductName(String name);

}
