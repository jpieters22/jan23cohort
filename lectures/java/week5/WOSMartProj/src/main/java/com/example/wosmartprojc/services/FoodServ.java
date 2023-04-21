package com.example.wosmartprojc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.wosmartprojc.models.Food;
import com.example.wosmartprojc.repositories.FoodRepo;

@Service
public class FoodServ {

	@Autowired
	private FoodRepo foodRepo;
	
//	======
//	CREATE
//	======
	public Food saveOne(Food food) {
		return foodRepo.save(food);
	}
	
//	====
//	READ
//	====
	public List<Food> getAll() {
		return foodRepo.findAll();
	}
	public Food getOne(Long id) {
		return foodRepo.findById(id).orElse(null);
	}
	
//	======
//	UPDATE
//	======
	public Food updateOne(Food editFood) {
		return foodRepo.save(editFood);
	}
	
//	======
//	DELETE
//	======
	public void deleteOne(Long id) {
		foodRepo.deleteById(id);
	}
}
