package com.ra.product3.serviceImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.ra.product3.entity.Product;
import com.ra.product3.exception.ProductNotFoundException;
import com.ra.product3.repository.ProductRepository;
import com.ra.product3.service.ProductService;


@Service
public class ProductServiceImpl implements ProductService {
	
	Logger log=LoggerFactory.getLogger(ProductServiceImpl.class);

	@Autowired
	ProductRepository productRepository;
	
	
	@Override
	public Product saveProduct(Product product){
		Product p = productRepository.save(product);
		if(p==null) {
			
//		log.warn("The product object is not save in the db");
		}
		//log.info("product object inserted in the db success");
		return p;
	}
	
	
	@Override
	public List<Product> getAllProducts() {
		List<Product> list = productRepository.findAll(); 
		if(list.isEmpty()) {
			log.error("No product details in the db");
			log.debug("the list of orduct is"+list.size());
		}
		log.info("fetched some product"+list.size());
		return list;
	}
	
	

	@Override
	public ResponseEntity<Product> getProductById(Long id) {
		Product product = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found!"));
		return ResponseEntity.ok(product);
	}

	
	
	@Override
	public Product updateProduct(Long id, Product productDetails) {
		Product product = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found!"));
		
		product.setId(productDetails.getId());
		product.setName(productDetails.getName());
		product.setPrice(productDetails.getPrice());
		
		Product updatedProduct = productRepository.save(product);
		
		return updatedProduct;
	}


	@Override
	public void deleteById(long id) {
		productRepository.deleteById(id);
	   
		
	}
	@Override
	public Product findByName(String name) {

		return productRepository.findByName(name);
	}
}
