package com.example.wosmartprojc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.wosmartprojc.models.Category;
import com.example.wosmartprojc.repositories.CategoryRepo;

@Service
public class CategoryServ {

	@Autowired
	private CategoryRepo categoryRepo;
	
//	======
//	CREATE
//	======
	public Category saveOne(Category category) {
		return categoryRepo.save(category);
	}
	
//	====
//	READ
//	====
	public List<Category> getAll() {
		return categoryRepo.findAll();
	}
	public Category getOne(Long id) {
		return categoryRepo.findById(id).orElse(null);
	}
	
//	======
//	UPDATE
//	======
	public Category updateOne(Category editCategory) {
		return categoryRepo.save(editCategory);
	}
	
//	======
//	DELETE
//	======
	public void deleteOne(Long id) {
		categoryRepo.deleteById(id);
	}
}
