package com.ra.product3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.ra.product3.entity.Product;
import com.ra.product3.service.ProductService;




@RestController
@CrossOrigin(origins="*")
@RequestMapping("/v1/api")
public class ProductController {
	
	

	@Autowired
	ProductService productService;
	
	@PostMapping("/registerproduct")
	  public Product saveProduct(@RequestBody Product product){
	      return productService.saveProduct(product);
	  }
	
	
	@GetMapping("/products")
	public List<Product> getAllProducts() {
	
		return productService.getAllProducts();
	}
	
	
	 @GetMapping("/name/{name}")
	  public Product findByusername(@PathVariable("name") String name) {
	      return productService.findByName(name);
	  }
	 
	 
	@PutMapping("/update/{id}")
	public Product updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
		return productService.updateProduct(id, productDetails);
	}
	
	

	@GetMapping("/product/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Long id) {
		return productService.getProductById(id);
	}
	
	 @DeleteMapping("delete/{id}")
	  public void deleteById(@PathVariable long id) {
	     
	       productService.deleteById(id);
	  }

}
