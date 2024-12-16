
package com.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.model.Product;
import com.service.ProductServices;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	 
	@Autowired
	 private ProductServices productService;
	
	
	 @GetMapping
	 public Page<Product> getAllProducts(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
	     
	     return productService.getAllProducts(page, size);
	 }
	 
	 
	 @PostMapping
	 public Product createProduct(@RequestBody Product product) {
	     return productService.createProduct(product);
	 }
	 
	 
	 @GetMapping("/{productID}")
	 public ResponseEntity<Product> getProductById(@PathVariable("productID") int productID) {
	     Optional<Product> product = productService.getProductById(productID);
	     return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	 }
	 
	 @PutMapping("/{productID}")
	 public ResponseEntity<Product> updateProduct(@PathVariable("productID") int productID, @RequestBody Product productDetails) {
	     Product updatedProduct = productService.updateProduct(productID, productDetails);
	     return ResponseEntity.ok(updatedProduct);
	 }

	 @DeleteMapping("/{productID}")
	 public ResponseEntity<Void> deleteProduct(@PathVariable("productID") int productID) {
		 productService.deleteProduct(productID);
	     return ResponseEntity.noContent().build();
	 }

}
