package com.yezhihao.www.view;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yezhihao.www.dao.GetBorrowBookDao;
import com.yezhihao.www.po.BorrowBookPo;
import com.yezhihao.www.service.BrrowBookService;

/**
 * Servlet implementation class ApplyBorrowBook
 */
@WebServlet("/ApplyBorrowBook")
public class ApplyBorrowBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplyBorrowBook() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean a=false;
		int ret=0;
		GetBorrowBookDao bookDao = new GetBorrowBookDao();
		HttpSession session =request.getSession();
		String Book_name= new String(request.getParameter("Book_name").getBytes("iso-8859-1"), "utf-8");
		try {
			ArrayList<BorrowBookPo> list =bookDao.getBorrowBookByUsername(3,(String)session.getAttribute("username"));
		for (BorrowBookPo borrowBookPo : list) {
			if(borrowBookPo.getBook_name().equals(Book_name)){
				ret=1;
				break;
			}
		}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(Integer.parseInt(request.getParameter("book_margin"))!=0&&ret==0){
			BrrowBookService brrowBookService =new BrrowBookService();
			Date d=new Date();   
			SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");   
			String borrow_date = df.format(d);  
			String return_date = df.format(new Date(d.getTime() - 30*24*60*60*1000));
			BorrowBookPo borrowBook=new BorrowBookPo(Integer.parseInt(request.getParameter("id")), Book_name, (String)session.getAttribute("username"), 2, borrow_date, return_date);
			try {
				a=brrowBookService.brrowBook(borrowBook);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else{
			if(ret==1){
				response.sendRedirect(request.getContextPath()+"/ApplyFail.jsp?ret=1");
			}else{
				response.sendRedirect(request.getContextPath()+"/ApplyFail.jsp?ret=0");
			}
		}
		if(a==true){
			response.sendRedirect(request.getContextPath()+"/ApplyBorrowBook.jsp?a=ture");
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
