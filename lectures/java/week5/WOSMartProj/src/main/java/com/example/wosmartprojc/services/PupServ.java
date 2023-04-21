package com.example.wosmartprojc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.wosmartprojc.models.Puppy;
import com.example.wosmartprojc.repositories.PupRepo;

@Service
public class PupServ {

	@Autowired
	private PupRepo pupRepo;
	
//	======
//	CREATE
//	======
	public Puppy savePup(Puppy pup) {
		return pupRepo.save(pup);
	}
	
//	====
//	READ
//	====
	public List<Puppy> getAll() {
		return pupRepo.findAll();
	}
	public Puppy getOne(Long id) {
		return pupRepo.findById(id).orElse(null);
	}
	
//	======
//	UPDATE
//	======
	public Puppy updateOne(Puppy editPuppy) {
		return pupRepo.save(editPuppy);
	}
	
//	======
//	DELETE
//	======
	public void deleteOne(Long id) {
		pupRepo.deleteById(id);
	}
}
