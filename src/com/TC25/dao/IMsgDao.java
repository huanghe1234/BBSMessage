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
	 * @param end 
	 * @param start 
	 * @return 成功返回信息集合 失败返回null
	 */
	List<Msg> queryMsg(String name, int start, int end)throws SQLException;
	/**
	 * 根据id查询数据的方法
	 * @param id 
	 * @return 成功返回信息对象 失败为null
	 */
	Msg checkMsgById(int id) throws SQLException;
	/**
	 * 修改信息的状态
	 * @param id
	 * @param state
	 */
	int updateMsg(int id, String state) throws SQLException;
	/**
	 * 根据id删除数据库数据的方法
	 * @param id
	 * @return 成功返回1  其他失败
	 */
	int deleteMsgById(int id) throws SQLException;
	/**
	 * 查询当前用户的信息记录总数
	 * @param name 
	 * @return 1成功 0失败
	 */
	int queryCount(String name) throws SQLException;

}
