package com.burgertracker1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.burgertracker1.models.Burger;
import com.burgertracker1.repositories.BurgerRepository;



@Service
public class BurgerServ {

	@Autowired
	private BurgerRepository burgerRepo;
	
	public List<Burger> allBurgers() {
		return burgerRepo.findAll();
	}
	
	public Burger getOne(Long id) {
		return burgerRepo.findById(id).orElse(null);
	}
	
//	public Item findItem(Long id) {
//        Optional<Item> optionalItem = itemRepo.findById(id);
//        if(optionalItem.isPresent()) {
//            return optionalItem.get();
//        } else {
//            return null;
//        }
//    }
	
	public Burger createItem(Burger i) {
		return burgerRepo.save(i);
	}
	
	public Burger updatedItem(Burger i) {
		return burgerRepo.save(i);
	}
	
	public void deleteOne(Long id) {
		burgerRepo.deleteById(id);
	}
}
