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

import com.model.Category;
import com.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
	@Autowired
	 private CategoryService categoryService;
	
	@GetMapping
	 public Page<Category> getAllCategories(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
	     return categoryService.getAllCategories(page, size);
	 }
	
	@PostMapping
	 public Category createCategory(@RequestBody Category category) {
	     return categoryService.createCategory(category);
	 }

	 @GetMapping("/{categoryID}")
	 public ResponseEntity<Category> getCategoryById(@PathVariable("categoryID") int categoryID) {
	     Optional<Category> category = categoryService.getCategoryById(categoryID);
	     return category.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	 }

	 @PutMapping("/{categoryID}")
	 public ResponseEntity<Category> updateCategory(@PathVariable("categoryID") int categoryID, @RequestBody Category categoryDetails) {
	     Category updatedCategory = categoryService.updateCategory(categoryID, categoryDetails);
	     return ResponseEntity.ok(updatedCategory);
	 }

	 @DeleteMapping("/{categoryID}")
	 public ResponseEntity<Void> deleteCategory(@PathVariable("categoryID") int categoryID) {
		 categoryService.deleteCategory(categoryID);
	     return ResponseEntity.noContent().build();
	 }

}