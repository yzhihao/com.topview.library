package com.yezhihao.www.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.yezhihao.www.dao.User;
import com.yezhihao.www.dao.Book;
import com.yezhihao.www.dao.BorrowBook;
import com.yezhihao.www.po.BookPo;
import com.yezhihao.www.po.BorrowBookPo;
import com.yezhihao.www.po.UserPo;
import com.yezhihao.www.service.AllowApplyService;
import com.yezhihao.www.service.BrrowBookService;

@Controller
@RequestMapping(value="/servlet")  
public class BorrowBookController {
	
	
	@Autowired
	private AllowApplyService AllowApplyService;
	
	@Autowired
	private BorrowBook BorrowBook;
	
	@Autowired
	private BrrowBookService BrrowBookService;
	
	@Autowired
	private User user;
	
	@Autowired
	private Book Book;
	
	
	/*获取借阅记录*/
	@RequestMapping(value="/OneUserBorrowCondition")  
	public ModelAndView OneUserBorrowCondition(HttpServletRequest request){
		List<BorrowBookPo>  borrowbooklist=new ArrayList<BorrowBookPo>();
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		BorrowBookPo BorrowBookPo=new BorrowBookPo();
		BorrowBookPo.setAllow_borrow(1);
		BorrowBookPo.setUser_name((String)session.getAttribute("username"));
		borrowbooklist=BorrowBook.getBorrowBookByUsername1(BorrowBookPo);
		for(BorrowBookPo applyBook: borrowbooklist){
			BookPo book=Book.getBookById(applyBook.getBook_id());
			applyBook.setBook_amg(book.getBook_amg());
		}
		
		
		ArrayList<UserPo> userlist=(ArrayList<UserPo>) user.getgeneralUser("普通用户");
		int ret=0;
		for(UserPo User:userlist){
     	   if(((String)session.getAttribute("username")).equals(User.getUsre_name())){
     		   ret=1;
     		   break;
     	   }
        }
		mv.addObject("ret", ret);
		mv.addObject("list", borrowbooklist);
	    mv.setViewName("OneUserBorrowCondition");
		return mv;
		}
	
	/*得到一个用户的借书记录*/
	@RequestMapping(value="/OneOldBorrowCondition")  
	public ModelAndView OneOldBorrowCondition(HttpServletRequest request){
		List<BorrowBookPo>  borrowbooklist=new ArrayList<BorrowBookPo>();
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		BorrowBookPo BorrowBookPo=new BorrowBookPo();
		BorrowBookPo.setAllow_borrow(-1);
		BorrowBookPo.setUser_name((String)session.getAttribute("username"));
		borrowbooklist=BorrowBook.getBorrowBookByUsername1(BorrowBookPo);
		for(BorrowBookPo applyBook: borrowbooklist){
			BookPo book=Book.getBookById(applyBook.getBook_id());
			applyBook.setBook_amg(book.getBook_amg());
		}
		
		ArrayList<UserPo> userlist=(ArrayList<UserPo>) user.getgeneralUser("普通用户");
		int ret=0;
		for(UserPo User:userlist){
     	   if(((String)session.getAttribute("username")).equals(User.getUsre_name())){
     		   ret=1;
     		   break;
     	   }
        }
		mv.addObject("ret", ret);
		mv.setViewName("OneOldBorrowCondition");		
		mv.addObject("list", borrowbooklist);
		return mv;
		}
	
	/*查看待审核记录*/
	@RequestMapping(value="/AllowBorrow")  
	public ModelAndView AllowBorrow(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
        ArrayList<BorrowBookPo> borrowbooklist=(ArrayList<BorrowBookPo>) BorrowBook.getApplyBook(2);
        if(borrowbooklist!=null){
		    for(BorrowBookPo applyBook: borrowbooklist){
		    	BookPo book=Book.getBookById(applyBook.getBook_id());
		    	applyBook.setBook_amg(book.getBook_amg());
		    }
	    }
        mv.addObject("list", borrowbooklist);
        mv.setViewName("AllowBorrow");
		return mv;
		}
	
	
	/*审核借阅的记录*/
	@RequestMapping(value="/AllowApplyServlet")  
	public ModelAndView AllowApplyServlet(@RequestParam(value="id" ) Integer  id,HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
       
		
		 BookPo book = null;
		 HttpSession session = request.getSession();
         try {
			book = Book.getBookById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	    Boolean a=false;
		if(book.getBook_margin()==0){
			 mv.setViewName("AllowFail");
			 return mv;
		}
		
		else{
			Date d=new Date();   
			SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");   
			String borrow_date = df.format(d);  
			String return_date = df.format(new Date(d.getTime() - 30*24*60*60*1000));
			BorrowBookPo borrowBook=new BorrowBookPo(book.getId(),book.getBook_name(),(String) session.getAttribute("applyusername"),borrow_date, return_date);
			borrowBook.setBorrow_bookid((Integer)session.getAttribute("borrowbook_id"));
			borrowBook.setAllow_borrow(Integer.parseInt(request.getParameter("agree")));
			try {
				a=AllowApplyService.brrowBook(borrowBook);//提交给Service层进行修改处理
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(a==true){
			mv.setViewName("AllowSuccess");
			return mv;
		}
		return mv;
		}
	
	/*所有的借阅记录*/
	@RequestMapping(value="/ShowAllBorrowedBook")  
	public ModelAndView ShowAllBorrowedBook(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
        ArrayList<BorrowBookPo> borrowbooklist=(ArrayList<BorrowBookPo>) BorrowBook.getApplyBook(1);
        if(borrowbooklist!=null){
		    for(BorrowBookPo applyBook: borrowbooklist){
		    	BookPo book=Book.getBookById(applyBook.getBook_id());
		    	applyBook.setBook_amg(book.getBook_amg());
		    }
	    }
        mv.addObject("list", borrowbooklist);
        mv.setViewName("ShowAllBorrowedBook");
		return mv;
		}
	
	/*得到单个用户的审核情况*/
	@RequestMapping(value="/ApplyStates")  
	public ModelAndView ApplyStates(HttpServletRequest request,@RequestParam(value="username" ) String  username){
		ModelAndView mv = new ModelAndView();
     	ArrayList<BorrowBookPo> list=new ArrayList<BorrowBookPo>();
     	ArrayList<BorrowBookPo> list1=(ArrayList<BorrowBookPo>) BorrowBook.getBorrowBookByUsername(username);
	    for (BorrowBookPo applybook : list1) {
	    	if(applybook.getAllow_borrow()==2||applybook.getAllow_borrow()==0){
	    		list.add(applybook);
		    }
		}
	    mv.addObject("list", list);
	    mv.setViewName("ApplyStates");
		return mv;
		}
	
	/*借书详情*/
	@RequestMapping(value="/AllowBookDetails")  
		public ModelAndView AllowBookDetails(@RequestParam(value="id" ) Integer  id,@RequestParam(value="user_name" ) Integer  user_name,HttpServletRequest request){
			ModelAndView mv = new ModelAndView();
			HttpSession session =request.getSession();
			 ArrayList<BorrowBookPo> borrowbooklist=(ArrayList<BorrowBookPo>) BorrowBook.getApplyBook(1);
		        if(borrowbooklist!=null){
				    for(BorrowBookPo applyBook: borrowbooklist){
				    	BookPo book=Book.getBookById(applyBook.getBook_id());
				    	applyBook.setBook_amg(book.getBook_amg());
				    }
			    }
		        BorrowBookPo theone = null;
		        if(borrowbooklist!=null&&borrowbooklist.size()>0)
		          {
		              for(int i=0;i<borrowbooklist.size();i++)
		              {
		           	   BorrowBookPo applybook = borrowbooklist.get(i);
			           	   if(applybook.getBook_id()==id&&applybook.getUser_name().equals(user_name)){
			           		theone=applybook;
			           		break;
			           	   }
		           	   }
		          }
	          session.setAttribute("applyusername",theone.getUser_name());
	          session.setAttribute("applybook_id",theone.getBook_id());
	          session.setAttribute("borrowbook_id",theone.getBorrow_bookid());
	        mv.addObject("book", theone);
	        mv.setViewName("AllowBookDetails");
			return mv;
			}
	
	/*所有的申请借阅记录*/
	@RequestMapping(value="/ApplyBorrowBook")  
	public ModelAndView ApplyBorrowBook(@RequestParam(value="id" ) Integer  id,@RequestParam(value="book_margin" ) Integer  book_margin,@RequestParam(value="Book_name" ) String  Book_name,HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		boolean a=false;
		int ret=0;
		HttpSession session =request.getSession();
		ArrayList<BorrowBookPo> list =(ArrayList<BorrowBookPo>) BorrowBook.getBorrowBookByUsername((String)session.getAttribute("username"));
		for (BorrowBookPo borrowBookPo : list) {
			if(borrowBookPo.getBook_name().equals(Book_name)){
				ret=1;
				break;
			}
		}
		if(book_margin!=0&&ret==0){
			Date d=new Date();   
			SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");   
			String borrow_date = df.format(d);  
			String return_date = df.format(new Date(d.getTime() - 30*24*60*60*1000));
			BorrowBookPo borrowBook=new BorrowBookPo(id, Book_name, (String)session.getAttribute("username"), 2, borrow_date, return_date);
			try {
				a=BrrowBookService.brrowBook(borrowBook);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else{
			if(ret==1){
				  mv.addObject("ret", 1);
			      mv.setViewName("ApplyFail");
			      return mv;
			}else{
				  mv.addObject("ret", 0);
			      mv.setViewName("ApplyFail");
			      return mv;			
			 }
		}
		if(a==true){
			mv.addObject("a", "ture");
		    mv.setViewName("ApplyBorrowBook");
		    return mv;
		}
		return mv;
	}
}
