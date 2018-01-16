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
import com.TC25.bean.Pager;
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
		
		//1.获取当前下标页
		int pageNum = 1;
		String page = request.getParameter("page");
		if(page!=null && !"".equals(page)){
			pageNum = Integer.parseInt(page); 
		}
		Pager pager = new Pager(pageNum);
		
		//2.调用业务层完成数据查询
		IMsgBiz imb = new MsgBizImpl();
		List<Msg> list = imb.getMsg(name,pager);
		
		//7.将pager和list存入域中
		request.setAttribute("mList", list);
		request.setAttribute("pager", pager);
		//8.转发到jsp页面显示
		request.getRequestDispatcher("main.jsp").forward(request, response);
			
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
