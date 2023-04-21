package com.example.wosmartprojc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.wosmartprojc.models.Stick;
import com.example.wosmartprojc.repositories.StickRepo;

@Service
public class StickServ {

	@Autowired
	private StickRepo stickRepo;
	
//	======
//	CREATE
//	======
	public Stick saveOne(Stick stick) {
		return stickRepo.save(stick);
	}
	
//	====
//	READ
//	====
	public List<Stick> getAll() {
		return stickRepo.findAll();
	}
	public Stick getOne(Long id) {
		return stickRepo.findById(id).orElse(null);
	}
	
//	======
//	UPDATE
//	======
	public Stick updateOne(Stick editStick) {
		return stickRepo.save(editStick);
	}
	
//	======
//	DELETE
//	======
	public void deleteOne(Long id) {
		stickRepo.deleteById(id);
	}
}
