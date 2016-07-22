package com.yezhihao.www.view;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yezhihao.www.po.CollectBookPo;
import com.yezhihao.www.service.CollectBookService;

/**
 * Servlet implementation class CollectBookServlet
 */
@WebServlet("/CollectBookServlet")
public class CollectBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CollectBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Boolean a = false;
		HttpSession session = request.getSession();
		CollectBookService collectBookService =new CollectBookService();
		CollectBookPo collectBook=new CollectBookPo(Integer.parseInt(request.getParameter("id")),  (String)session.getAttribute("username"));
		try {
			a=collectBookService.collectBook(collectBook);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(a==true){
			response.sendRedirect(request.getContextPath()+"/CollectBookstate.jsp?a=ture");
		}
		if(a==false){
			response.sendRedirect(request.getContextPath()+"/CollectBookstate.jsp?a=false");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
