package com.example.wosmartprojc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.wosmartprojc.models.Food;

@Repository
public interface FoodRepo extends CrudRepository<Food, Long> {
	List<Food> findAll();    
}
