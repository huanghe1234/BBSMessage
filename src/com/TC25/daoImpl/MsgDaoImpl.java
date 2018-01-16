package com.TC25.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
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
		String sql = "INSERT INTO T_MSG VALUES(T_MSG_SEQ.NEXTVAL,?,?,?,?,'未读',?)";
		int update = run.update(sql,m.getToUser(),m.getFromUser(),m.getTitle(),m.getContent(),m.getMsgDate());
		return update;
	}

	@Override
	public List<Msg> queryMsg(String name, int start, int end) throws SQLException {
		//1获取数据库操作对象run
		QueryRunner run = JDBCUtils.getQueryRunner();
		//2.执行
		String sql = "SELECT * FROM (SELECT ROWNUM R,T_MSG.* FROM T_MSG WHERE TOUSER =?) T WHERE T.R>? AND T.R<=? ";
		List<Msg> result = run.query(sql, new BeanListHandler<>(Msg.class),name,start,end);		

		return result;
	}

	@Override
	public Msg checkMsgById(int id) throws SQLException {
		//1获取数据库操作对象run
		QueryRunner run = JDBCUtils.getQueryRunner();
		//2.执行
		String sql = "SELECT ID,TOUSER,FROMUSER,TITLE,CONTENT,STATE,MSGDATE FROM T_MSG WHERE ID = ? ";
		Msg result = run.query(sql, new BeanHandler<>(Msg.class),id);		
		return result;
	}
	
	@Override
	public int updateMsg(int id, String state) throws SQLException {
		//1获取数据库操作对象run
		QueryRunner run = JDBCUtils.getQueryRunner();
		//2.执行
		String sql="UPDATE T_MSG SET STATE = ? WHERE ID = ?";
		int update = run.update(sql,state,id);
		return update;
		
	}

	@Override
	public int deleteMsgById(int id) throws SQLException {
		//1获取数据库操作对象run
		QueryRunner run = JDBCUtils.getQueryRunner();
		//2.执行
		String sql="DELETE FROM T_MSG WHERE ID = ?";
		int update = run.update(sql,id);
		return update;
	}

	@Override
	public int queryCount(String name) throws SQLException {
		int count = -1;
		Connection conn = JDBCUtils.getConnection();
		String sql = "SELECT COUNT(ID) FROM T_MSG WHERE TOUSER = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setObject(1, name);
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			count = rs.getInt(1);
		}
		rs.close();
		ps.close();
		conn.close();	
		return count;
	}

	


}
