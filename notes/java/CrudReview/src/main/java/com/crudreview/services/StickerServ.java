package com.crudreview.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudreview.models.Sticker;
import com.crudreview.repositories.StickerRepo;

@Service
public class StickerServ {

	@Autowired
	private StickerRepo stickerRepo;
	
	public Sticker createOne(Sticker c) {
		return stickerRepo.save(c);
	}
	
	public List<Sticker> getAll() {
		return stickerRepo.findAll();
	}
	
	public Sticker getOne(Long id) {
		return stickerRepo.findById(id).orElse(null);
	}
	
	public Sticker updateOne(Sticker c) {
		return stickerRepo.save(c);
	}
	
	public void deleteOne(Long id) {
		stickerRepo.deleteById(id);
	}
}
