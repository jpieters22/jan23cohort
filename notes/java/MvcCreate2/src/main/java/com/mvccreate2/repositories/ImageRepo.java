package com.mvccreate2.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mvccreate2.models.Image;

@Repository
public interface ImageRepo extends CrudRepository<Image, Long> {

	List<Image> findAll();
	
}
