package com.huatec.edu.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.huatec.edu.dao.UserDao;
import com.huatec.edu.entity.User;
import com.huatec.edu.util.MybatisUtil;

public class UserDaoImpl implements UserDao {

	public void save(User u) {
		SqlSession session = MybatisUtil.openSession();
		session.insert("com.huatec.edu.entity.User.save", u);
		session.commit();
		session.close();
	}
	public void update(User u) {
		SqlSession session = MybatisUtil.openSession();
		session.update("com.huatec.edu.entity.User.update", u);
		session.commit();
		session.close();
	}
	public void delete(Long id) {
		SqlSession session = MybatisUtil.openSession();
		session.delete("com.huatec.edu.entity.User.delete", id);
		session.commit();
		session.close();
	}
	public User get(Long id) {
		SqlSession session = MybatisUtil.openSession();
		User u = session.selectOne("com.huatec.edu.entity.User.getUserById", id);
		session.close();
		return u;
	}
	public List<User> list() {
		SqlSession session = MybatisUtil.openSession();
		List<User> userList = session.selectList("com.huatec.edu.entity.User.list");
		session.close();
		return userList;
	}

}
