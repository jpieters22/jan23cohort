package com.safetravels.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.safetravels.models.Travel;

@Repository
public interface TravelRepo extends CrudRepository <Travel, Long> {

	List<Travel> findAll();
	Optional<Travel> findById(Long search);
}
