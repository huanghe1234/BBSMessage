package com.TC25.bizImpl;

import java.sql.SQLException;
import java.util.List;

import com.TC25.bean.User;
import com.TC25.biz.IUserBiz;
import com.TC25.dao.IUserDao;
import com.TC25.daoImpl.UserDaoImpl;


public class UserBizImpl implements IUserBiz{
	IUserDao iud = new UserDaoImpl();
	
	@Override
	public int addUser(User u) {
		int row = -1;
		//判断注册的用户是否重名
		try {
			User result = iud.queryByName(u.getName());
			
			if(result == null){
				//如果不重名返回数字
				row = iud.insertUser(u);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return row;
	}

	@Override
	public User loginUser(User u) {
		//判断输入的用户名是否和数据库的用户名一致
		User result = null;
		try {
			result = iud.queryByUser(u);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<User> queryUser(int id) {
		if(id == 0){
			throw new RuntimeException("传入参数有误");
		}
		List<User> result =null;
			try {
				result = iud.checkUserById(id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return result;
	}

	@Override
	public User checkUser(String name) {
		User u = null;
		try {
			u = iud.checkUser(name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}


	
}
