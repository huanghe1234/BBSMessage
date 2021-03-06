package com.TC25.bizImpl;

import java.sql.SQLException;
import java.util.List;

import com.TC25.bean.Msg;
import com.TC25.bean.Pager;
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
	public List<Msg> getMsg(String name,Pager pager) {
		IMsgDao imd = new MsgDaoImpl();
		List<Msg> result = null;
		try {
			//3.获取总记录数
			int count = imd.queryCount(name);
			//4.将记录总数设置到pager对象中
			pager.setRecordCount(count);
			//5.得到页码区间,当前页面所显示的信息行数
			int start = (pager.getCurrentPage()-1)*pager.PAGE_RECORD;
			int end = start+pager.PAGE_RECORD;
			//6.调用dao,查询区间集合			
			result = imd.queryMsg(name,start,end);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Msg checkMsg(int id) {
		IMsgDao imd = new MsgDaoImpl();
		Msg result = null;
		try {
			//1.根据id查询Msg详情内容
			result = imd.checkMsgById(id);
			//2.根据id修改Msg的状态,如果未读的修改为已读
			if("未读".equals(result.getState())){
				imd.updateMsg(id,"已读");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int deleteMsg(int id) {
		IMsgDao imd = new MsgDaoImpl();
		int result = -1;
		try {
			result = imd.deleteMsgById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
