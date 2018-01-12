package com.TC25.test;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.TC25.bean.User;
import com.TC25.biz.IUserBiz;
import com.TC25.bizImpl.UserBizImpl;

public class SendMsgServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("User");
		User u = (User) obj;
		int id = u.getId();
		//将id输入至数据库,进行查询并返回用户对象集合
		IUserBiz iub = new UserBizImpl();
		List<User> list = iub.queryUser(id);
		//资源存入域中,并进行资源转发
		if(list != null){
			req.setAttribute("list", list);
			req.getRequestDispatcher("newMsg.jsp").forward(req, resp);
		}else{
			System.out.println("查询失败");
		}
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
