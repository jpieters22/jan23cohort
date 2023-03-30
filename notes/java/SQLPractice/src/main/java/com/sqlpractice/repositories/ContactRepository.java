package com.sqlpractice.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sqlpractice.models.Contact;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Long>{

	
}
