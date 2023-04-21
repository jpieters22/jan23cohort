package com.example.wosmartprojc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.wosmartprojc.models.Cart;
import com.example.wosmartprojc.repositories.CartRepo;

@Service
public class CartServ {

	@Autowired
	private CartRepo cartRepo;
	
//	======
//	CREATE
//	======
	public Cart saveOne(Cart cart) {
		return cartRepo.save(cart);
	}
	
//	====
//	READ
//	====
	public List<Cart> getAll() {
		return cartRepo.findAll();
	}
	public Cart getOne(Long id) {
		return cartRepo.findById(id).orElse(null);
	}
	
//	======
//	UPDATE
//	======
	public Cart updateOne(Cart editCart) {
		return cartRepo.save(editCart);
	}
	
//	======
//	DELETE
//	======
	public void deleteOne(Long id) {
		cartRepo.deleteById(id);
	}
}
