package com.ra.product3.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ra.product3.entity.Product;
import com.ra.product3.repository.ProductRepository;


@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

	@InjectMocks
	private ProductServiceImpl productService;
	@Mock
	private ProductRepository productRepository;
	
	
	
	@Test
	void testCreateProduct() {
		Product pro=new Product(5000l,"Laptop",80000.0);
		//fake repository or mock repository -> Mockito;
		Mockito.when(productRepository.save(pro)).thenReturn(pro);
		Product actual=productService.saveProduct(pro);
		// it will call the productservice.createProduct(pro)
		assertEquals(pro, actual);	
	}

	@Test
	void testGetAllProduct() {
		Product p1 = new Product(2000l,"furniture",57456.0);
		Product p2 = new Product(2001l,"sofa",5456.0);
		Product p3 = new Product(2002l,"mixer",7456.0);
		List<Product> listOfProducts=new ArrayList<>();
		listOfProducts.add(p1);listOfProducts.add(p2);listOfProducts.add(p3);
		Mockito.when(productRepository.findAll()).thenReturn(listOfProducts);
		List<Product> actuals=productService.getAllProducts();
		assertEquals(listOfProducts, actuals);
		assertEquals(listOfProducts.size(), actuals.size());
		assertEquals(listOfProducts.get(0), actuals.get(0));
	}

	
}
