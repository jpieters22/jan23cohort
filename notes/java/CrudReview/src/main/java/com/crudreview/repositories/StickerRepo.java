package com.crudreview.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.crudreview.models.Sticker;

@Repository
public interface StickerRepo extends CrudRepository<Sticker, Long> {

	List<Sticker> findAll();
}
