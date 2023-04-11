package com.javagrades.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javagrades.models.Student;
import com.javagrades.repositories.StudentRepo;

@Service
public class StudentServ {

	@Autowired
	private StudentRepo studentRepo;
	
	public List<Student> getAll(){
		return studentRepo.findAll();
	}
	
	public Student getOne(Long id) {
		return studentRepo.findById(id).orElse(null);
	}
	
	public Student createOne(Student i) {
		return studentRepo.save(i);
	}
	
	public Student updatedOne(Student i) {
		return studentRepo.save(i);
	}
	
	public void deleteOne(Long id) {
		studentRepo.deleteById(id);
	}
}
