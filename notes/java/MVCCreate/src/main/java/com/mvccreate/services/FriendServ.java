package com.mvccreate.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mvccreate.models.Friend;
import com.mvccreate.repositories.FriendRepo;

@Service
public class FriendServ {

	private final FriendRepo friendRepo;
	
	public FriendServ(FriendRepo friendRepo) {
		this.friendRepo = friendRepo;
	}
	
	public List<Friend> allFriends() {
		return friendRepo.findAll();
	}
	
}
