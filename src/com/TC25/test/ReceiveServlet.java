package com.TC25.test;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.TC25.bean.Msg;
import com.TC25.bean.User;
import com.TC25.biz.IMsgBiz;
import com.TC25.bizImpl.MsgBizImpl;
@WebServlet("/doReceive")
public class ReceiveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("User");
		User u = (User)obj;
		String name = u.getName();
		//System.out.println(name);
		//将数据传入到后台进行查询
		IMsgBiz imb = new MsgBizImpl();
		List<Msg> list = imb.getMsg(name);
		
		request.setAttribute("mList", list);
		request.getRequestDispatcher("main.jsp").forward(request, response);
			
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
