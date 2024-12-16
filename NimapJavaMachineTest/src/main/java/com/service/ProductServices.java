package com.service;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.model.Product;
import com.repository.ProductRepository;

@Service
public class ProductServices {
	@Autowired
	private ProductRepository productRepository;

	public Page<Product> getAllProducts(int page, int size) {
		return productRepository.findAll(PageRequest.of(page, size));
	}

	public Product createProduct(Product product) {
		return productRepository.save(product);
	}

	public Optional<Product> getProductById(int productID) {
		return productRepository.findById(productID);
	}

	public Product updateProduct(int productID, Product productDetails) {
		Product product = productRepository.findById(productID).orElseThrow(() -> new RuntimeException("Product not found"));
		product.setProductName(productDetails.getProductName());
		product.setProductPrice(productDetails.getProductPrice());
		product.setCategory(productDetails.getCategory());
		return productRepository.save(product);
	}

	public void deleteProduct(int productID) {
		productRepository.deleteById(productID);
	}
}