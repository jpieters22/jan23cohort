package com.example.wosmartprojc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.wosmartprojc.models.Cart;

@Repository
public interface CartRepo extends CrudRepository<Cart, Long> {
    List<Cart> findAll();
}
