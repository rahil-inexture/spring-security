package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.User;

public interface UserDao {
	User findById(int id);
    User findBySSO(String sso);
    void saveUser(User user);
    void deleteUserBySSO(String sso);
    List<User> findAllUsers(); 
}
