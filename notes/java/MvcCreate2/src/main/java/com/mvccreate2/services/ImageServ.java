package com.mvccreate2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvccreate2.models.Image;
import com.mvccreate2.repositories.ImageRepo;

@Service
public class ImageServ {

//	private final ImageRepo imageRepo;
//	public ImageServ(ImageRepo imageRepo) {
//		this.imageRepo = imageRepo;
//	}
	
	@Autowired
	private ImageRepo imageRepo;
	
	public List<Image> allImages() {
		return imageRepo.findAll();
	}
	
	public Image createImage(Image i) {
		return imageRepo.save(i);
	}
}
