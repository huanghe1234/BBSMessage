package com.TC25.biz;

import java.util.List;

import com.TC25.bean.Msg;

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
	 * @return 成功返回信息集合 失败返回null
	 */
	List<Msg> getMsg(String name);
	
}
