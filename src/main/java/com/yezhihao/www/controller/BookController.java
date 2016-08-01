package com.yezhihao.www.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.yezhihao.www.dao.Book;
import com.yezhihao.www.dao.CollectBook;
import com.yezhihao.www.dao.GetBookDao;
import com.yezhihao.www.dao.User;
import com.yezhihao.www.po.BookPo;
import com.yezhihao.www.po.Page;
import com.yezhihao.www.po.UserPo;

@Controller
@RequestMapping(value="/servlet")  
public class BookController {
	
	@Autowired
	private Book Book;
	
	@Autowired
	private CollectBook collectBook; 
	
	@Autowired
	private User user;
	
	@Autowired
	private com.yezhihao.www.service.AddBookService AddBookService;
	
	/*该方法验证登录*/
	@RequestMapping(value="/ShowBook")  
	public ModelAndView showbookController(@RequestParam("curPage") String curPage,HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		Page page=new Page();
		int a=(Integer.valueOf(curPage)-1)*8;
		page.setDbIndex(a);
		page.setDbNumber(8);
		ArrayList<BookPo> booklist=(ArrayList<BookPo>) Book.queryBookByPage(page);
		

		mv.addObject("booklist", booklist);
		page.count();
		page.setCurrentPage(Integer.valueOf(curPage));
		
		ArrayList<UserPo> userlist=(ArrayList<UserPo>) user.getgeneralUser("普通用户");
		int ret=0;
		HttpSession session = request.getSession();
		for(UserPo User:userlist){
     	   if(((String)session.getAttribute("username")).equals(User.getUsre_name())){
     		   ret=1;
     		   break;
     	   }
        }
		mv.addObject("ret", ret);
		mv.addObject("page", page);
		mv.setViewName("showBook1");
		return mv;
		}
	
	@RequestMapping(value="/AddBookServlet")  
	public ModelAndView AddBook(@ModelAttribute("book") BookPo book,@RequestParam(value="file" ,required=false) MultipartFile file,HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView();
		String filePath=request.getSession().getServletContext().getRealPath("/");
		String date=new SimpleDateFormat("yyyyMMddHHmmssSSS") .format(new Date() );
        Random random=new Random();//创建一个随机数对象
        int result=random.nextInt(1000);
		//for(MultipartFile file:user_amg){
        file.transferTo(new File(filePath+"amg_lib/"+date+result+file.getOriginalFilename()));			
		//}
        book.setBook_amg(date+result+file.getOriginalFilename());
     	AddBookService.addBook(book);
	   	mv.setViewName("AddBookSuccess");
	   	//mv.addObject("book", book);
		return mv;
	}
	
	@RequestMapping(value="/DeleteDookServlet")  
	public ModelAndView DeleteDookServlet(@RequestParam("a") String a,@RequestParam(value="book_id" ,required=false) Integer book_id,HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView();
		if(a.equals("ture")){
			collectBook.deleteCollectBook(book_id);
		 	mv.setViewName("ShowCollectBook");
		 	//TODO
			return mv;
		}
		else{
			BookPo Book1=Book.getBookById(book_id);
			if(Book1.getBook_samem()==Book1.getBook_margin()){
				Book.deleteFailApply(book_id);
				mv.setViewName("DeleteDookState");
				mv.addObject("a", "ture");
				return mv;
			}
			else{
				Book1.setBook_margin(0);
				int m=Book1.getBook_samem()-Book1.getBook_margin();
				Book1.setBook_samem(Book1.getBook_samem()-Book1.getBook_margin());
			
				Book1.setId(book_id);
				Book.deleteFailApply1(Book1);
				mv.setViewName("DeleteDookState");
				mv.addObject("a", "false");
				mv.addObject("m", m);
				return mv;
			}
			
		}
	}
	
	@RequestMapping(value="/BookDetails")  
	public ModelAndView BookDetails(@RequestParam(value="id" ,required=false) Integer id,HttpServletRequest request, HttpServletResponse response) throws Exception{
		ModelAndView mv = new ModelAndView();
		BookPo book=Book.getBookById(id);
		ArrayList<UserPo> userlist=(ArrayList<UserPo>) user.getgeneralUser("普通用户");
		int ret=0;
		HttpSession session = request.getSession();
		for(UserPo User:userlist){
     	   if(((String)session.getAttribute("username")).equals(User.getUsre_name())){
     		   ret=1;
     		   break;
     	   }
        }
		mv.addObject("ret", ret);
		
	    String list ="";
        //从客户端获得Cookies集合
        Cookie[] cookies = request.getCookies();
        //遍历这个Cookies集合
        if(cookies!=null&&cookies.length>0)
        {
            for(Cookie c:cookies)
            {
                if(c.getName().equals("ListViewCookie"))
                {
                   list = c.getValue();
                }
            }
        }
        list+=id+",";
        //如果浏览记录超过1000条，清零.
        String[] arr = list.split(",");
        if(arr!=null&&arr.length>0)
        {
            if(arr.length>=1000)
            {
                list="";
            }
        }
        Cookie cookie = new Cookie("ListViewCookie",list);
        response.addCookie(cookie);
        GetBookDao bookDao=new GetBookDao();//这里new一个dao属纯粹偷懒。
        ArrayList<BookPo> booklist = bookDao.getViewList(list);
        mv.addObject("list", booklist);
		mv.addObject("book", book);
		mv.setViewName("BookDetails");
		return mv;
	}
	
	@RequestMapping(value="/ShowSelectBook")  
	public ModelAndView ShowSelectBook(@RequestParam(value="select" ,required=false) String select,HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView();
		BookPo BookPo=new BookPo();
		BookPo.setBook_writer(select);
		BookPo.setBook_name(select);
		ArrayList<BookPo> list=(ArrayList<com.yezhihao.www.po.BookPo>) Book.getBookByselect(BookPo);
		mv.addObject("list", list);
		ArrayList<UserPo> userlist=(ArrayList<UserPo>) user.getgeneralUser("普通用户");
		int ret=0;
		HttpSession session = request.getSession();
		for(UserPo User:userlist){
     	   if(((String)session.getAttribute("username")).equals(User.getUsre_name())){
     		   ret=1;
     		   break;
     	   }
        }
		mv.addObject("ret", ret);
		mv.addObject("list", list);
	   	mv.setViewName("ShowSelectBook");
		return mv;
	}
	
	@RequestMapping(value="/UdateBook")  
	public ModelAndView UdateBook(@RequestParam(value="book_id" ,required=false) Integer book_id,HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView();
		BookPo book =Book.getBookById(book_id);
		mv.addObject("book", book);
	   	mv.setViewName("UdateBook");
		return mv;
	}
	
	@RequestMapping(value="/UpdateBookServlet")  
	public ModelAndView UpdateBookServlet(@ModelAttribute("book") BookPo book,@RequestParam(value="file" ,required=false) MultipartFile file,HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		BookPo book1=Book.getBookById(book.getId());

		book.setBook_samem(book1.getBook_samem()+book.getBook_samem());
		book.setBook_margin(book.getBook_samem()+book1.getBook_margin());
		String filePath=request.getSession().getServletContext().getRealPath("/");
		String date=new SimpleDateFormat("yyyyMMddHHmmssSSS") .format(new Date() );
        Random random=new Random();//创建一个随机数对象
        int result=random.nextInt(1000);
		//for(MultipartFile file:user_amg){
        file.transferTo(new File(filePath+"amg_lib/"+date+result+file.getOriginalFilename()));			
		//}
        book.setBook_amg(date+result+file.getOriginalFilename());
        Book.updateBookDao(book);
		mv.addObject("book", book);
        mv.addObject("a", "ture");
	   	mv.setViewName("AddBookSuccess");
		return mv;
	}
}

