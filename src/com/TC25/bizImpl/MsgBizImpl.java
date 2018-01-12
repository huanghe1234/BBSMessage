package com.TC25.bizImpl;

import java.sql.SQLException;
import java.util.List;

import com.TC25.bean.Msg;
import com.TC25.biz.IMsgBiz;
import com.TC25.dao.IMsgDao;
import com.TC25.daoImpl.MsgDaoImpl;

public class MsgBizImpl implements IMsgBiz {

	@Override
	public int addMsg(Msg m) {
		if(m==null){
			throw new RuntimeException("传入参数有误");
		}
		IMsgDao imd = new MsgDaoImpl();
		int result = -1;
		try {
			result = imd.insertMsg(m);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Msg> getMsg(String name) {
		IMsgDao imd = new MsgDaoImpl();
		List<Msg> result = null;
		try {
			result = imd.queryMsg(name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
