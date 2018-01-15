package com.TC25.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TC25.bean.User;
import com.TC25.biz.IUserBiz;
import com.TC25.bizImpl.UserBizImpl;

public class Register extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		//1.获取从请求里面获得的数据
		String name = req.getParameter("username");
		String pwd = req.getParameter("password");
		String affirm =  req.getParameter("affirm");
		String email =  req.getParameter("email");
		//2.将数据封装为对象
		User u = new User(name,pwd,email);
		//3.进入逻辑层,对数据进行判断
		//4.对从逻辑层返回的结果进行判断
		
		if(pwd.equals(affirm)){
			IUserBiz iub = new UserBizImpl();
			int result = iub.addUser(u);
			if(result == 1){
				resp.sendRedirect("index.jsp");
				resp.getWriter().write("可以注册");
			}else{
				resp.getWriter().write("注册名重复");
			}
		}else{
			resp.getWriter().write("两次输入的密码不一致");
		}
		//System.out.println(result==1?"注册成功":"注册失败");
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
