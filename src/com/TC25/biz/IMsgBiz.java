package com.TC25.biz;

import java.util.List;

import com.TC25.bean.Msg;
import com.TC25.bean.Pager;

public interface IMsgBiz {
	/**
	 * 添加用户发送信息内容的逻辑
	 * @param m 信息对象
	 * @return 成功返回1 其他失败
	 */
	int addMsg(Msg m);
	
	/**
	 * 根据用户名称查询用户所收到的信息的逻辑
	 * @param name 接收信息的人
	 * @param pager 
	 * @return 成功返回信息集合 失败返回null
	 */
	List<Msg> getMsg(String name, Pager pager);
	
	/**
	 * 根据id查询发送信息内容的逻辑
	 * @param id 信息id
	 * @return 成功返回Msg对象 失败返回空
	 */
	Msg checkMsg(int id);
	
	/**
	 * 根据id删除信息内容的逻辑
	 * @param id 信息id
	 * @return 成功返回1 其他失败
	 */
	int deleteMsg(int id);
	
}
