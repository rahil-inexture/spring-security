package com.example.demo.service;

import java.util.List;

import com.example.demo.model.User;

public interface UserService {	
	User findById(int id);
    User findBySSO(String sso);
    void saveUser(User user);
    void updateUser(User user);
    void deleteUserBySSO(String sso);
    List<User> findAllUsers(); 
    boolean isUserSSOUnique(Integer id, String sso);
}
