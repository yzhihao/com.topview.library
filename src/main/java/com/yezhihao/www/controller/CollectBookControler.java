package com.yezhihao.www.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.yezhihao.www.po.BookPo;
import com.yezhihao.www.po.CollectBookPo;
import com.yezhihao.www.service.CollectBookService;
import com.yezhihao.www.dao.Book;
import com.yezhihao.www.dao.CollectBook;


@Controller
@RequestMapping(value="/servlet")
public class CollectBookControler {
	
	@Autowired
	private CollectBook CollectBook;
	
	@Autowired
	private Book Book;
	
	@Autowired
	private CollectBookService CollectBookService;
	
	/*获取所有的收藏的书籍*/
	@RequestMapping(value="/ShowCollectBook")  
	public ModelAndView ShowCollectBook(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		ArrayList<CollectBookPo> list=(ArrayList<CollectBookPo>)CollectBook.getCollectBook((String)session.getAttribute("username")) ;
		ArrayList<BookPo> booklist =new ArrayList<BookPo>();
		
		  	//GetBookDao getBook=new GetBookDao();
		    for(CollectBookPo collectBook: list){
		    	BookPo book=Book.getBookById(collectBook.getBook_id());
		    	System.out.println(book);
		    	booklist.add(book);
		    }
		    mv.addObject("list", booklist);
		    mv.setViewName("ShowCollectBook");
		return mv;
		}
	
	@RequestMapping(value="/CollectBookServlet")  
		public ModelAndView CollectBookServlet(@RequestParam(value="id" ,required=false) Integer id,HttpServletRequest request){
			ModelAndView mv = new ModelAndView();
			
			
			Boolean a = false;
			HttpSession session = request.getSession();
			CollectBookPo collectBook=new CollectBookPo(id,  (String)session.getAttribute("username"));
			try {
				a=CollectBookService.collectBook(collectBook);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(a==true){
			    mv.addObject("a", "ture");
				mv.setViewName("CollectBookstate");
				return mv;
			}
			if(a==false){
				mv.addObject("a", "false");
				mv.setViewName("CollectBookstate");
				return mv;
			}
			return mv;
			
			}
}
