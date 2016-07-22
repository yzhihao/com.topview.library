package com.yezhihao.www.view;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.yezhihao.www.po.BookPo;
import com.yezhihao.www.service.AddBookService;

/**
 * Servlet implementation class AddBookServlet
 */
@WebServlet("/AddBookServlet")
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		AddBookService addBookService=new AddBookService();
		boolean a = false;
		Map<String,String> map=new HashMap<String,String>();
		String fileName = null;
		 int book_margin=0;
		int book_samem=0;
		try {
			File file ;
			int maxFileSize = 5000 * 1024;
			int maxMemSize = 5000 * 1024;
//			JspFactory fac=JspFactory.getDefaultFactory();
//			PageContext pageContext=fac.getPageContext(this, request,response, null, false, JspWriter.DEFAULT_BUFFER, true);			
			//ServletContext context = pageContext.getServletContext();
			ServletContext context =this.getServletContext();
			String filePath = context.getInitParameter("file-upload");
			String contentType = request.getContentType();
			System.out.print("ewf"+contentType.indexOf("multipart/form-data"));
			if ((contentType.indexOf("multipart/form-data") >= 0)) {
			   DiskFileItemFactory factory = new DiskFileItemFactory();
			   factory.setSizeThreshold(maxMemSize);
			   factory.setRepository(new File("c:\\temp"));
			   ServletFileUpload upload = new ServletFileUpload(factory);
			   upload.setSizeMax( maxFileSize );
			   try{ 
			      List<FileItem> fileItems = upload.parseRequest(request);
			      Iterator<FileItem> i = fileItems.iterator();
			
			      while ( i.hasNext () ) 
			      {
			         FileItem fi = (FileItem) i.next();
			         String date=new SimpleDateFormat("yyyyMMddHHmmssSSS") .format(new Date() );
			         Random random=new Random();//创建一个随机数对象
			         int result=random.nextInt(1000);
			         if ( !fi.isFormField () )   
			         {
			         fileName = date+result+fi.getName();
			         
			         if( fileName.lastIndexOf("\\") >= 0 ){
			         file = new File( filePath + 
			         fileName.substring( fileName.lastIndexOf("\\"))) ;
			         }else{
			         file = new File( filePath + 
			         fileName.substring(fileName.lastIndexOf("\\")+1)) ;
			         }
			         fi.write( file );
			         }
			         else{
			        	 String name = fi.getFieldName(); 
			        	 String value = fi.getString(); 
			        	 value = new String(value.getBytes("iso-8859-1"), "utf-8"); 
			        	 map.put(name, value);
			         }
			      }
			   }catch(Exception ex) {
			      System.out.println(ex);
			   }
			   book_samem = Integer.parseInt(map.get("book_samem"), 10);
			   book_margin = Integer.parseInt(map.get("book_samem"), 10);
				a=addBookService.addBook(new BookPo(0,map.get("book_name"),map.get("book_writer"),fileName,book_samem,book_margin));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(a)
		{
			BookPo book=new BookPo(0,map.get("book_name"),map.get("book_writer"),fileName,book_samem,book_margin);
			HttpSession session = request.getSession();
			session.setAttribute("book", book);
			response.sendRedirect(request.getContextPath()+"/AddBookSuccess.jsp?a=ture");
		}else{
			response.sendRedirect(request.getContextPath()+"/AddBookSuccess.jsp?a=flase");
		}
	}
	}

