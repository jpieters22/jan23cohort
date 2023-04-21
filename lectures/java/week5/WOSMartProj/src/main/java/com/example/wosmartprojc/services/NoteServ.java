package com.example.wosmartprojc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.wosmartprojc.models.Note;
import com.example.wosmartprojc.repositories.NoteRepo;

@Service
public class NoteServ {

	@Autowired
	private NoteRepo noteRepo;
	
//	======
//	CREATE
//	======
	public Note saveOne(Note note) {
		return noteRepo.save(note);
	}
	
//	====
//	READ
//	====
	public List<Note> getAll() {
		return noteRepo.findAll();
	}
	public Note getOne(Long id) {
		return noteRepo.findById(id).orElse(null);
	}
	
//	======
//	UPDATE
//	======
	public Note updateOne(Note editNote) {
		return noteRepo.save(editNote);
	}
	
//	======
//	DELETE
//	======
	public void deleteOne(Long id) {
		noteRepo.deleteById(id);
	}
}
