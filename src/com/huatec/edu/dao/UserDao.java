package com.huatec.edu.dao;

import java.util.List;

import com.huatec.edu.entity.User;

public interface UserDao {
	void save(User u);
	void update(User u);
	void delete(Long id);
	User get(Long id);
	List<User> list();
}
