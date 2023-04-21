package com.example.wosmartprojc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.wosmartprojc.models.Link;

@Repository
public interface LinkRepo extends CrudRepository<Link, Long>{
	List<Link> findAll();
}
