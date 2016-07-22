package com.yezhihao.www.view;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yezhihao.www.dao.DeleteFailApplyDao;

/**
 * Servlet implementation class DeleteFailApplyServlet
 */
@WebServlet("/DeleteFailApplyServlet")
public class DeleteFailApplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteFailApplyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		DeleteFailApplyDao deleteFailApply=new DeleteFailApplyDao();
		Boolean a = false;
		try {
			a = deleteFailApply.deleteFailApply(0,request.getParameter("user_name"), Integer.parseInt(request.getParameter("id")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(a==true){
			response.sendRedirect(request.getContextPath()+"/ApplyStates.jsp?username="+(String)session.getAttribute("username"));
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
