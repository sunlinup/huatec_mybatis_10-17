package com.huatec.edu.util;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


/**
 * 这是mybatis的工具类，设计成单例模式
 * @author admin
 */
public class MybatisUtil {
	// 饿汉式
	private static final MybatisUtil instance = new MybatisUtil();
	private SqlSessionFactory sessionFactory;
	private MybatisUtil(){
		//给SqlSessionFactory做数据初始化
		try {
			InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
			sessionFactory = new SqlSessionFactoryBuilder().build(in);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static SqlSession openSession() {
		return instance.sessionFactory.openSession();
	}
}
