package com.study.servlet_study.repository;

import java.util.ArrayList;
import java.util.List;

import com.study.servlet_study.entity.Product;

public class ProductRepository {
	List<Product> products;
	
	private static ProductRepository instance;
	
	private ProductRepository() {
		products = new ArrayList<>();
	}
	
	public static ProductRepository getInstance() {
		if (instance == null) {
			instance = new ProductRepository();
		}
		return instance;
	}
	
	public int saveProduct(Product product) {
		for (Product p : products) {
			if (product.getProductName().equals(p.getProductName())) {
				return 0;
			}
		}
		products.add(product);
		
		return 1;
	}
	
	public Product findProductByProductName(String productName) {
		Product findProduct = null;
		
		for (Product product : products) {
			if (product.getProductName().equals(productName)) {
				findProduct = product;
			}
		}
		
		return findProduct;
	}

}
