package com.TC25.biz;

import java.util.List;

import com.TC25.bean.User;

public interface IUserBiz {

	/**
	 * 注册用户的逻辑
	 * @param u 带有参数的用户对象
	 * @return 成功返回1 其它失败
	 */
	public int addUser(User u);
	
	
	/**
	 * 登陆用户的逻辑
	 * @param u 带有参数的用户对象
	 * @return 成功返回用户对象  其他返回null
	 */
	public User loginUser(User u);

	/**
	 * 查询不是登陆用户id的逻辑
	 * @param id
	 * @return 成功返回用户集合 其他返回为null
	 */
	public List<User> queryUser(int id);

	/**
	 * 查询是否是相同用户的逻辑
	 * @param name 用户名
	 * @return  成功返回用户对象 失败返回null
	 */
	public User checkUser(String name);
}
