package com.TC25.daoImpl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.TC25.bean.Msg;
import com.TC25.dao.IMsgDao;
import com.TC25.tools.JDBCUtils;

public class MsgDaoImpl implements IMsgDao {

	@Override
	public int insertMsg(Msg m) throws SQLException {
		//1获取数据库操作对象run
		QueryRunner run = JDBCUtils.getQueryRunner();
		//2.执行
		String sql = "INSERT INTO T_MSG VALUES(T_MSG_SEQ.NEXTVAL,?,?,?,?)";
		int update = run.update(sql,m.getToUser(),m.getFromUser(),m.getTitle(),m.getContent());
		return update;
	}

	@Override
	public List<Msg> queryMsg(String name) throws SQLException {
		//1获取数据库操作对象run
		QueryRunner run = JDBCUtils.getQueryRunner();
		//2.执行
		String sql = "SELECT ID,TOUSER,FROMUSER,TITLE,CONTENT FROM T_MSG WHERE TOUSER = ? ";
		List<Msg> result = run.query(sql, new BeanListHandler<>(Msg.class),name);		
		return result;
	}
	
	

}
