package com.crudreview.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.crudreview.models.Category;

@Repository
public interface CategoryRepo extends CrudRepository<Category, Long> {

	List<Category> findAll();
}
