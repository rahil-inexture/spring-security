package com.example.demo.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserProfileDao;
import com.example.demo.model.UserProfile;
import com.example.demo.service.UserProfileService;

@Service
@Transactional
public class UserProfileServiceImpl implements UserProfileService{

	@Autowired
	private UserProfileDao userProfileDao; 
	@Override
	public UserProfile findById(int id) {
		return userProfileDao.findById(id);
	}

	@Override
	public UserProfile findByType(String type) {
		return userProfileDao.findByType(type);
	}

	@Override
	public List<UserProfile> findByAll() {
		return userProfileDao.findByAll();
	}
}
