package com.crudreview.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudreview.models.Category;
import com.crudreview.repositories.CategoryRepo;

@Service
public class CategoryServ {

	@Autowired
	private CategoryRepo catRepo;
	
	public Category createOne(Category c) {
		return catRepo.save(c);
	}
	
	public List<Category> getAll() {
		return catRepo.findAll();
	}
	
	public Category getOne(Long id) {
		return catRepo.findById(id).orElse(null);
	}
	
	public Category updateOne(Category c) {
		return catRepo.save(c);
	}
	
	public void deleteOne(Long id) {
		catRepo.deleteById(id);
	}
}
