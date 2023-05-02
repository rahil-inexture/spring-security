package com.example.demo.service;

import java.util.List;

import com.example.demo.model.UserProfile;

public interface UserProfileService {
	
	UserProfile findById(int id);
	UserProfile findByType(String type);
	List<UserProfile> findByAll();
}
