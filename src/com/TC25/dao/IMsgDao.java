package com.TC25.dao;

import java.sql.SQLException;
import java.util.List;

import com.TC25.bean.Msg;

public interface IMsgDao {
	/**
	 * 添加到信息内容到数据库的方法
	 * @param m 信息对象
	 * @return 成功返回1 其他失败
	 */
	int insertMsg(Msg m) throws SQLException;
	/**
	 * 查询数据库用户收到信息的方法
	 * @param name 收到信息的名字
	 * @return 成功返回信息集合 失败返回null
	 */
	List<Msg> queryMsg(String name)throws SQLException;

}
