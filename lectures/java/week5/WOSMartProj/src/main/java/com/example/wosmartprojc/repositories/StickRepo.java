package com.example.wosmartprojc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.wosmartprojc.models.Stick;

@Repository
public interface StickRepo extends CrudRepository<Stick, Long> {
	List<Stick> findAll();
}
