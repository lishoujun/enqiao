package cn.enqiao.nav;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.enqiao.util.bigmaria;

//@WebServlet("/linkadd")
public class LinkAdd extends HttpServlet {
	//int a = 0;

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain");
		response.setStatus(200);

		response.setCharacterEncoding("UTF-8");
		String url = request.getParameter("url");
		String title = request.getParameter("title");
		String topic = request.getParameter("topic");
		//System.out.println(title + " " + url);
		bigmaria bm = new bigmaria();
		bm.addlink(title, url,topic);

		response.sendRedirect("index.jsp");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);

	}
}
