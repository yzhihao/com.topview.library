package com.yezhihao.www.view;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yezhihao.www.dao.GetBookDao;
import com.yezhihao.www.po.BookPo;
import com.yezhihao.www.po.BorrowBookPo;
import com.yezhihao.www.service.AllowApplyService;

/**
 * Servlet implementation class AllowApply
 */
@WebServlet("/AllowApply")
public class AllowApplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllowApplyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 GetBookDao bookDao = new GetBookDao(); 
		 BookPo book = null;
		 HttpSession session = request.getSession();
         try {
			book = bookDao.getBookById((Integer)session.getAttribute("applybook_id"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    Boolean a=false;
	if(book.getBook_margin()==0){
		response.sendRedirect(request.getContextPath()+"/AllowFail.jsp");
	}
	else{
		AllowApplyService brrowBookService =new AllowApplyService();
		Date d=new Date();   
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");   
		String borrow_date = df.format(d);  
		String return_date = df.format(new Date(d.getTime() - 30*24*60*60*1000));
		BorrowBookPo borrowBook=new BorrowBookPo(book.getId(),book.getBook_name(),(String) session.getAttribute("applyusername"),borrow_date, return_date);
		borrowBook.setBorrow_bookid((Integer)session.getAttribute("borrowbook_id"));
		borrowBook.setAllow_borrow(Integer.parseInt(request.getParameter("agree")));
		try {
			a=brrowBookService.brrowBook(borrowBook);//提交给Service层进行修改处理
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	if(a==true){
		response.sendRedirect(request.getContextPath()+"/AllowSuccess.jsp");
	}
	}

}
