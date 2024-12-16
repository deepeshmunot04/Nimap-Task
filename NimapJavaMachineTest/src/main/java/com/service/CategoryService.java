package com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.model.Category;
import com.repository.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;

	public Page<Category> getAllCategories(int page, int size){
		return categoryRepository.findAll(PageRequest.of(page, size));
	}

	public Category createCategory(Category category){
		return categoryRepository.save(category);
	}

	public Optional<Category> getCategoryById(int categoryID){
		return categoryRepository.findById(categoryID);
	}

	public Category updateCategory(int categoryID, Category categoryDetails){
		Category category = categoryRepository.findById(categoryID).orElseThrow(() -> new RuntimeException("Category not found"));
		category.setCategoryName(categoryDetails.getCategoryName());
		return categoryRepository.save(category);
	}

	public void deleteCategory(int categoryID){
		categoryRepository.deleteById(categoryID);
	}
}