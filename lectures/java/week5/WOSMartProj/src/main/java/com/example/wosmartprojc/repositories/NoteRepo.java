package com.example.wosmartprojc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.wosmartprojc.models.Note;

@Repository
public interface NoteRepo extends CrudRepository<Note, Long> {
	List<Note> findAll();
}
