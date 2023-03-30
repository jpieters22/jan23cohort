package com.sqlpractice.services;

import org.springframework.stereotype.Service;

import com.sqlpractice.repositories.ContactRepository;

@Service
public class ContactService {

	
	//FIELD
	//adding the repo dependency 
	private final ContactRepository contactRepo;
	
	
	//CONSTRUCTOR
	public ContactService(ContactRepository contactRepo) {
		this.contactRepo = contactRepo;
	}
	
	
}
