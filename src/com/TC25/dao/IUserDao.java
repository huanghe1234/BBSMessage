package com.TC25.dao;

import java.sql.SQLException;
import java.util.List;

import com.TC25.bean.User;


public interface IUserDao {
	/**
	 * 根据名称查询用户
	 * @param name 用户名称
	 * @return 成功返回用户对象  失败返回null
	 * @throws SQLException
	 */
	public User queryByName(String name)throws SQLException;
	
	
	/**
	 * 往数据库内添加用户
	 * @param u 用户对象
	 * @return 成功返回1, 其他返回失败
	 * @throws SQLException
	 */
	public int insertUser(User u)throws SQLException;

	
	/**
	 * 检查数据数据库的数据
	 * @param u 用户对象
	 * @return 如果能查出来返回用户对象,如果不能返回null
	 */
	public User queryByUser(User u) throws SQLException;

	/**
	 * 检查数据库内不是所选id的方法
	 * @param id
	 * @return 成功返回用户集合 失败为null
	 */
	public List<User> checkUserById(int id) throws SQLException;

	/**
	 * 查询是否是相同用户的方法
	 * @param name
	 * @return 成功返回用户对象 失败null
	 * @throws SQLException
	 */
	public User checkUser(String name)throws SQLException;


	
	
	
	
	
	
}
