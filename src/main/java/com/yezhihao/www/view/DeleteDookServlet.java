package com.yezhihao.www.view;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yezhihao.www.dao.CollectBookDao;
import com.yezhihao.www.dao.DeleteDookDao;

/**
 * Servlet implementation class DeleteDookServlet
 */
@WebServlet("/DeleteDookServlet")
public class DeleteDookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteDookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("a").equals("ture")){
			CollectBookDao CollectBookDao=new CollectBookDao();
			try {
				CollectBookDao.deleteCollectBook(Integer.valueOf(request.getParameter("book_id")));
				response.sendRedirect(request.getContextPath()+"/ShowCollectBook.jsp");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			String book_id=request.getParameter("book_id");
			DeleteDookDao DeleteDookDao=new DeleteDookDao();
			int a = 0;
			try {
				a=DeleteDookDao.deleteFailApply(Integer.valueOf(book_id));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(a==-1){
			response.sendRedirect(request.getContextPath()+"/DeleteDookState.jsp?a=ture");
	
		}
		else{
			response.sendRedirect(request.getContextPath()+"/DeleteDookState.jsp?a=false&m="+a);
		}
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
