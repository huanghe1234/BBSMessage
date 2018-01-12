package com.TC25.test;

import java.io.IOException;
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

@WebServlet("/doSend")
public class SendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("User");
		User u = (User) obj;
		String toUser = request.getParameter("toUser");//发送给哪个用户的名称
		String fromUser = u.getName(); //当前的用户的名称
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		//System.out.println(toUser);
		//System.out.println(fromUser);
		//System.out.println(title);
		//System.out.println(content);
		//封装成对象进行数据传输
		Msg m = new Msg(toUser, fromUser, title, content);
		IMsgBiz imb = new MsgBizImpl();
		int result = imb.addMsg(m);
		if(result==1){
			System.out.println("信息添加成功");
			response.sendRedirect("main.jsp");
			//request.getRequestDispatcher("doSendMsg").forward(request, response);
		}else{
			System.out.println("数据添加失败");
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
