package com.TC25.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TC25.bean.User;
import com.TC25.biz.IUserBiz;
import com.TC25.bizImpl.UserBizImpl;

public class Login extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		IUserBiz iub = new UserBizImpl();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		String name = req.getParameter("username");
		String pwd = req.getParameter("password");
		//封装为对象进行数据传输
		User u = new User(name,pwd);
		//传入逻辑层进行判断,并得到User对象
		User result = iub.loginUser(u);
		
		if(result != null){
			req.getSession().setAttribute("User",result);
			resp.sendRedirect("main.jsp");
		}else{
			resp.sendRedirect("loginFailed.jsp");
		}
			
		System.out.println(result !=null ?"登陆成功":"登陆失败");
		
		
	}
}
