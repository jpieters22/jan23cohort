package com.example.wosmartprojc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.wosmartprojc.models.Squish;
import com.example.wosmartprojc.repositories.SquishRepo;


@Service
public class SquishServ {

	@Autowired
	private SquishRepo cartRepo;
	
//	======
//	CREATE
//	======
	public Squish saveOne(Squish cart) {
		return cartRepo.save(cart);
	}
	
//	====
//	READ
//	====
	public List<Squish> getAll() {
		return cartRepo.findAll();
	}
	public Squish getOne(Long id) {
		return cartRepo.findById(id).orElse(null);
	}
	
//	======
//	UPDATE
//	======
	public Squish updateOne(Squish editSquish) {
		return cartRepo.save(editSquish);
	}
	
//	======
//	DELETE
//	======
	public void deleteOne(Long id) {
		cartRepo.deleteById(id);
	}
}
