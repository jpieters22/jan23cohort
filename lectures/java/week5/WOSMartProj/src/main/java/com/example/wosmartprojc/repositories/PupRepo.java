package com.example.wosmartprojc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.wosmartprojc.models.Puppy;

@Repository
public interface PupRepo extends CrudRepository<Puppy, Long>{
	List<Puppy> findAll();
}
