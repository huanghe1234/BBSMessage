package com.TC25.daoImpl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.TC25.bean.User;
import com.TC25.dao.IUserDao;
import com.TC25.tools.JDBCUtils;



public class UserDaoImpl implements IUserDao{

	@Override
	public User queryByName(String name) throws SQLException {
		//1获取数据库操作对象run
		QueryRunner run = JDBCUtils.getQueryRunner();
		//2.执行
		String sql = "SELECT * FROM USERTABLE WHERE NAME = ?";
		User u = run.query(sql, new BeanHandler<>(User.class),name);
		return u;
			
	}

	@Override
	public int insertUser(User u) throws SQLException {
		//1获取数据库操作对象run
		QueryRunner run = JDBCUtils.getQueryRunner();
		//2.执行
		String sql = "INSERT INTO USERTABLE VALUES(?,?,?,USER_SEQ.NEXTVAL)";
		int update = run.update(sql, u.getName(),u.getPwd(),u.getEmail());
		return update;
	
		
	}

	@Override
	public User queryByUser(User u) throws SQLException {
		//1获取数据库操作对象run
		QueryRunner run = JDBCUtils.getQueryRunner();
		//2.执行
		String sql = "SELECT * FROM USERTABLE WHERE NAME = ? AND PWD = ?";
		User result = run.query(sql, new BeanHandler<>(User.class),u.getName(),u.getPwd());		
		return result;
		
	}

	@Override
	public List<User> checkUserById(int id) throws SQLException{
		//1获取数据库操作对象run
		QueryRunner run = JDBCUtils.getQueryRunner();
		//2.执行
		String sql = "SELECT * FROM USERTABLE WHERE ID != ? ";
		List<User> result = run.query(sql, new BeanListHandler<>(User.class),id);		
		return result;
	}

	@Override
	public User checkUser(String name) throws SQLException {
		//1获取数据库操作对象run
		QueryRunner run = JDBCUtils.getQueryRunner();
		//2.执行
		String sql = "SELECT * FROM USERTABLE WHERE NAME = ?";
		User u = run.query(sql, new BeanHandler<>(User.class),name);
		
		return u;
	}

	
}
