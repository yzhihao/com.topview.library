package com.yezhihao.www.view;

import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import com.yezhihao.www.dao.GetUserDao;
import com.yezhihao.www.po.UserPo;
import com.yezhihao.www.service.RegisterUserService;

/**
 * Servlet implementation class RegisterUserServlet
 */
@WebServlet("/RegisterUserServlet")
public class RegisterUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterUserServlet() {
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
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		boolean a = false;
		Map<String,String> map=new HashMap<String,String>();
		String fileName = null;
		try {
			File file ;
			int maxFileSize = 5000 * 1024;
			int maxMemSize = 5000 * 1024;
//			JspFactory fac=JspFactory.getDefaultFactory();
//			PageContext pageContext=fac.getPageContext(this, request,response, null, false, JspWriter.DEFAULT_BUFFER, true);			
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
			        	 map.put(name,value);
			         }
			      }
			   }catch(Exception ex) {
			      System.out.println(ex);
			   }
			  }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 GetUserDao User=new GetUserDao();
		   ArrayList<UserPo> userlist=new ArrayList<UserPo>();
		   try {
			userlist=User.getUser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   int ret=0;
		   for(UserPo user :userlist){
			  if(user.getUsre_name().equals(map.get("username"))){
				   ret=1;
				   break;
			  }
		   }
		    String password=getMD5(map.get("password"));
		    String possword_right=getMD5(map.get("answer"));
		   if(ret==1){
			   response.sendRedirect(request.getContextPath()+"/RegisterFali.jsp");
			   return;
		   }
		   else{
			   	try {
			   		UserPo user=new UserPo(map.get("username"),password,map.get("type"),fileName);
			   		HttpSession session = request.getSession();
					session.setAttribute("password", map.get("password"));
			   		user.setPossword_request(map.get("request"));
			   		user.setPossword_right(possword_right);
				a=(new RegisterUserService()).adduser(user);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   String password1=getMD5(map.get("password"));
		if(a)
		{
			UserPo user=new UserPo(map.get("username"),password1,map.get("type"),fileName);
			user.setPossword_request(map.get("request"));
	   		user.setPossword_right(possword_right);
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			response.sendRedirect(request.getContextPath()+"/RegisterSuceess.jsp");
				}
		   }
		}	
	
	public final static String getMD5(String s) {
		char hexDigits[] = { '0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
		try {
		byte[] strTemp = s.getBytes();
		   MessageDigest mdTemp = MessageDigest.getInstance("MD5");
		   mdTemp.update(strTemp);
		byte[] md = mdTemp.digest();
		int j = md.length;
		char str[] = new char[j * 2];
		int k = 0;
		for (int i = 0; i < j; i++) {
		byte b = md[i];
		    str[k++] = hexDigits[b >> 4 & 0xf];
		    str[k++] = hexDigits[b & 0xf];
		   }
		return new String(str);
		  } catch (Exception e) {
		return null;
		  }
	}	
}
