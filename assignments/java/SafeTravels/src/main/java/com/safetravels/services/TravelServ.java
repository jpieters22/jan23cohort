package com.safetravels.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetravels.models.Travel;
import com.safetravels.repositories.TravelRepo;

@Service
public class TravelServ {

	@Autowired
	private TravelRepo travelRepo;
	
	public List<Travel> allTravel() {
		return travelRepo.findAll();
	}
	
	public Travel getOne(Long id) {
		return travelRepo.findById(id).orElse(null);
	}
	
	public Travel createItem(Travel t) {
		return travelRepo.save(t);
	}
	
	public Travel updatedItem(Travel t) {
		return travelRepo.save(t);
	}
	
	public void deleteOne(Long id) {
		travelRepo.deleteById(id);
	}
}
