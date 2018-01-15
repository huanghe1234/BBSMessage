package com.TC25.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TC25.bean.User;
import com.TC25.biz.IUserBiz;
import com.TC25.bizImpl.UserBizImpl;

@WebServlet("/doCheck")
public class CheckNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IUserBiz iub = new UserBizImpl();
		String name = request.getParameter("name");
		if("".equals(name)){
			response.getWriter().write("用户为空");
			
		}else{
			//将拿到的数据和数据库的内容进行对比
			User u = iub.checkUser(name);		
			if(u!=null){
				response.getWriter().write("用户名重复");
			}else{
				response.getWriter().write("可以注册");		
			}
		
		}	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
