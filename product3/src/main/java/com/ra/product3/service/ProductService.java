package com.ra.product3.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ra.product3.entity.Product;



public interface ProductService {
	public Product saveProduct(Product product);
	public List<Product> getAllProducts();
	public ResponseEntity<Product> getProductById(Long id);
	public Product updateProduct(Long id, Product productDetails);
	public void deleteById(long id);
	public Product findByName(String name);
}
