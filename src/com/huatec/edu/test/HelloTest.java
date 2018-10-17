package com.huatec.edu.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.huatec.edu.dao.UserDao;
import com.huatec.edu.dao.impl.UserDaoImpl;
import com.huatec.edu.entity.User;
import com.huatec.edu.entity.UserMapper;
import com.huatec.edu.util.MybatisUtil;

public class HelloTest {
	private UserDao dao = new UserDaoImpl();
	@Test
	public void testSave() {
		User u = new User();
		u.setUsername("rose3343");
		u.setPassword("111");
		//dao.save(u);
		SqlSession session = MybatisUtil.openSession();
		session.insert("", u);
		session.commit();
		session.close();
	}
	
	@Test
	public void testUpdate() {
		User u = new User();
		u.setUsername("jack");
		u.setId(1L);
		dao.update(u);
	}
	
	@Test
	public void testDelete() {
		dao.delete(3L);
	}
	
	@Test
	public void testGet() {
		//System.out.println(dao.get(3L));
		SqlSession session = MybatisUtil.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
//		System.out.println(mapper.getClass());
		User u = mapper.getUserById(2L);
		System.out.println(u);
		
	}
	
	@Test
	public void testList() {
//		List<User> userList = dao.list();
//		for (int i = 0; i < userList.size(); i++) {
//			System.out.println(userList.get(i));
//		}
		SqlSession session = MybatisUtil.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<User> userList = mapper.list();
		for (User user : userList) {
			System.out.println(user);
		}
	}
	
	
	@Test
	public void testGetUserByAddress() {
		User u = new User();
		u.setAddress("%江苏%");
		SqlSession session = MybatisUtil.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<User> userList = mapper.getUserByAddress(u);
		for (User user : userList) {
			System.out.println(user);
		}
	}
}
