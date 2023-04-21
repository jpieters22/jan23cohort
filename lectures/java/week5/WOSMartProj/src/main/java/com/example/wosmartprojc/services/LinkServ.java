package com.example.wosmartprojc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.wosmartprojc.models.Link;
import com.example.wosmartprojc.repositories.LinkRepo;

@Service
public class LinkServ {

	@Autowired
	private LinkRepo linkRepo;
	
//	======
//	CREATE
//	======
	public Link saveOne(Link link) {
		return linkRepo.save(link);
	}
	
//	====
//	READ
//	====
	public List<Link> getAll() {
		return linkRepo.findAll();
	}
	public Link getOne(Long id) {
		return linkRepo.findById(id).orElse(null);
	}
	
//	======
//	UPDATE
//	======
	public Link updateOne(Link editLink) {
		return linkRepo.save(editLink);
	}
	
//	======
//	DELETE
//	======
	public void deleteOne(Long id) {
		linkRepo.deleteById(id);
	}
}
