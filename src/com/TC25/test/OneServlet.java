package com.TC25.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TC25.bean.Msg;
import com.TC25.biz.IMsgBiz;
import com.TC25.bizImpl.MsgBizImpl;

@WebServlet("/doOne")
public class OneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid = request.getParameter("id");
		int id =  Integer.parseInt(sid);
		//System.out.println(id);
		IMsgBiz imb = new MsgBizImpl();
		//将id传入到数据库进行查询
		Msg result = imb.checkMsg(id);
		if(result!=null){
			request.setAttribute("msg", result);
			request.getRequestDispatcher("readMsg.jsp").forward(request, response);
		}else{
			response.getWriter().write("查询失败!");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
