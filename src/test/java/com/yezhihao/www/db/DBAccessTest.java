package com.yezhihao.www.db;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import junit.framework.TestCase;

public class DBAccessTest extends TestCase {
	@Test
	public void testGetSqlSession() throws IOException {
		// 通过配置文件获取数据库连接信息
		Reader reader = Resources.getResourceAsReader("com/yezhihao/www/config/Configuration.xml");
		// 通过配置信息构建一个SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		// 通过sqlSessionFactory打开一个数据库会话
		sqlSessionFactory.openSession();
	}
	@Test
	public void testCloseSqlSession() {
		fail("Not yet implemented");
	}

}
