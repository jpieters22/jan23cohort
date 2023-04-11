package com.burgertracker1.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.burgertracker1.models.Burger;

@Repository
public interface BurgerRepository extends CrudRepository<Burger, Long> {

	List<Burger> findAll();
	Optional<Burger> findById(Long search);
}
