package com.mvccreate.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mvccreate.models.Friend;

@Repository
public interface FriendRepo extends CrudRepository<Friend, Long>{

	List<Friend> findAll();
}
