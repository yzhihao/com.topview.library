package com.yezhihao.www.view;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yezhihao.www.dao.AlterBorrowBookDao;
import com.yezhihao.www.dao.GetBookDao;
import com.yezhihao.www.po.BookPo;

/**
 * Servlet implementation class ReturnBookServlet
 */
@WebServlet("/ReturnBookServlet")
public class ReturnBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReturnBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		AlterBorrowBookDao AlterBorrowBookDao=new AlterBorrowBookDao();
		AlterBorrowBookDao alterBorrowBookDao=new AlterBorrowBookDao();
		GetBookDao getBookDao=new GetBookDao();
		BookPo book= new BookPo();
		Boolean a = false,b=false;
		try {
			book= getBookDao.getBookById(Integer.parseInt(request.getParameter("book_id")));
			b=alterBorrowBookDao.changeMargin( Integer.parseInt(request.getParameter("book_id")), book.getBook_margin()+1);
			a=AlterBorrowBookDao.returnbook(Integer.parseInt(request.getParameter("borrowbookid")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(a==true&&b==true){
			response.sendRedirect(request.getContextPath()+"/OneUserBorrowCondition.jsp?username="+(String)session.getAttribute("username"));
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
