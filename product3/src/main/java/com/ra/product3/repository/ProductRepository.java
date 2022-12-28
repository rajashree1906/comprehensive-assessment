package com.ra.product3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ra.product3.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	public Product findByName(String name);

}
