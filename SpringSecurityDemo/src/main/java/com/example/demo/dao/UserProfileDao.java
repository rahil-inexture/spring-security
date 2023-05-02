package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.UserProfile;

public interface UserProfileDao {
	UserProfile findById(int id);
	UserProfile findByType(String type);
	List<UserProfile> findByAll();
}
