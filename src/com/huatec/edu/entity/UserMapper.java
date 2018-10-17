package com.huatec.edu.entity;

import java.util.List;

public interface UserMapper {
	void save(User u);
	void update(User u);
	void delete(long id);
	User getUserById(long id);
	List<User> list();
	
	/**
	 * 查询出地址不为空且年龄大于18的江苏籍用户
	 * @return
	 */
	List<User> getUserByAddress(User u);
}
