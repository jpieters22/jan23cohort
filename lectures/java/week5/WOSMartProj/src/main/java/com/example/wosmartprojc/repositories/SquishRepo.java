package com.example.wosmartprojc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.wosmartprojc.models.Squish;

@Repository
public interface SquishRepo extends CrudRepository<Squish, Long> {
	List<Squish> findAll();
}
