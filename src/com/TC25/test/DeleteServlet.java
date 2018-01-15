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

@WebServlet("/doDelete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid = request.getParameter("id");
		int id =  Integer.parseInt(sid);
		//System.out.println(id);
		IMsgBiz imb = new MsgBizImpl();
		//将id传入到数据库进行删除
		int result = imb.deleteMsg(id);
		if(result == 1){
			System.out.println("信息删除成功");
			//request.getRequestDispatcher("deleteSuccess.jsp").include(request, response);
			response.getWriter().write("ok");
		}else{
			System.out.println("信息删除失败");
			response.getWriter().write("error");
		}
		
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
