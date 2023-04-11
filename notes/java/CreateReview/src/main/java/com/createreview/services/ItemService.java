package com.createreview.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.createreview.models.Item;
import com.createreview.repositories.ItemRepository;

@Service
public class ItemService {

	@Autowired
	private ItemRepository itemRepo;
	
	public List<Item> allItems() {
		return itemRepo.findAll();
	}
	
	public Item getOne(Long id) {
		return itemRepo.findById(id).orElse(null);
	}
	
//	public Item findItem(Long id) {
//        Optional<Item> optionalItem = itemRepo.findById(id);
//        if(optionalItem.isPresent()) {
//            return optionalItem.get();
//        } else {
//            return null;
//        }
//    }
	
	public Item createItem(Item i) {
		return itemRepo.save(i);
	}
	
	public Item updatedItem(Item i) {
		return itemRepo.save(i);
	}
	
	public void deleteOne(Long id) {
		itemRepo.deleteById(id);
	}
}
