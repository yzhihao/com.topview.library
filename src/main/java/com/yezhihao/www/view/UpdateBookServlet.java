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

import com.yezhihao.www.dao.GetBookDao;
import com.yezhihao.www.dao.UpdateBookDao;
import com.yezhihao.www.po.BookPo;

/**
 * Servlet implementation class AddBookServlet
 */
@WebServlet("/UpdateBookServlet")
public class UpdateBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBookServlet() {
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
		UpdateBookDao UpdateBookDao=new UpdateBookDao();
		boolean a = false;
		Map<String,String> map=new HashMap<String,String>();
		String fileName = null;
		try {
			File file ;
			int maxFileSize = 5000 * 1024;
			int maxMemSize = 5000 * 1024;
//			JspFactory fac=JspFactory.getDefaultFactory();
//			PageContext pageContext=fac.getPageContext(this, request,response, null, false, JspWriter.DEFAULT_BUFFER, true);			
//			ServletContext context = pageContext.getServletContext();
			ServletContext context =this.getServletContext();
			String filePath = context.getInitParameter("file-upload");
			String contentType = request.getContentType();
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
			   BookPo book=new BookPo();
			   book.setBook_name(map.get("book_name"));
			   book.setBook_writer(map.get("book_writer"));
			   book.setId(Integer.valueOf(map.get("ID")));
			   book.setBook_samem(Integer.valueOf(map.get("book_num")));
			   book.setBook_amg(fileName);
			   a=UpdateBookDao.updateBookDao(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(a)
		{
	        GetBookDao bookDao = new GetBookDao(); 
	        BookPo book=null;
			try {
				book=bookDao.getBookById(Integer.valueOf(map.get("ID")));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			HttpSession session = request.getSession();
			session.setAttribute("book", book);
			response.sendRedirect(request.getContextPath()+"/AddBookSuccess.jsp?a=ture");
		}
	}
	}

