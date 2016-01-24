package cn.enqiao.business;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.enqiao.util.bigmaria;

/**
 * Servlet implementation class job
 */
public class job extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public job() {
        super();
        // TODO Auto-generated constructor stub
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		for(balabala){
//			balabala...;
//		}
		bigmaria bm=new bigmaria();
		String markerArr = bm.getJobs().toString();
//		request.setAttribute("markerArr", "[{title:\"千丁互联\",content:\"java\",point:\"116.605381|39.9309\",isOpen:0,icon:{w:21,h:21,l:0,t:0,x:6,lb:5}}]");
		request.setAttribute("markerArr", markerArr);
	}
	
	
	


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
