package cn.enqiao.nav;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.enqiao.util.bigmaria;

/**
 * Servlet implementation class Showtopic
 * 此页面用来在添加链接时查找分类编号
 *  @author lsjun 20150210
 */
//@WebServlet("/showtopic")
public class Showtopic extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Showtopic() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		bigmaria bm=new bigmaria();
		
		out.append(bm.getTopic());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
		
	}

}
