package com.yezhihao.www.view;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.yezhihao.www.po.UserPo;
import com.yezhihao.www.service.LonginService;

/**
 * Servlet implementation class LonginServlet
 */
@WebServlet(description = "This is the description of my J2EE component", urlPatterns = { "/LonginServlet" })
public class LonginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LonginServlet() {
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
		String username2="";
	      Cookie[] cookies1 = request.getCookies();
	      if(cookies1!=null&&cookies1.length>0)
	      {
	           for(Cookie c:cookies1)
	           {
	              if(c.getName().equals("Username"))
	              {
	                   username2 =  URLDecoder.decode(c.getValue(),"utf-8");
	              }
	           }
	      }   
	      if(username2.equals("")||username2==null){
			String piccode = (String) request.getSession().getAttribute("piccode");
			String checkcode = request.getParameter("checkcode");
			checkcode = checkcode.toUpperCase();
			if(checkcode.equals(piccode)){
			}else{
				response.sendRedirect(request.getContextPath()+"/LonginFailed.jsp?a=false");
				return;
			}
	      }
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String type = request.getParameter("type");
		LonginService longinService=new LonginService();
						
		boolean a = false;
		try {
			a=longinService.login(new UserPo(username,password,type));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(a)
		{
		       String[] isUseCookies = request.getParameterValues("isUseCookie");
		       if(isUseCookies!=null&&isUseCookies.length>0)
		       {
		          String username1 = URLEncoder.encode(request.getParameter("username"),"utf-8");
		          String password1 = URLEncoder.encode(request.getParameter("password"),"utf-8");
		          
		          Cookie UsernameCookie = new Cookie("Username",username1);
		          Cookie PasswordCookie = new Cookie("Password",password1);
		          UsernameCookie.setMaxAge(864000);
		          PasswordCookie.setMaxAge(864000);
		          UsernameCookie.setPath(request.getContextPath()+"/");
		          PasswordCookie.setPath(request.getContextPath()+"/");
		          response.addCookie(UsernameCookie);
		          response.addCookie(PasswordCookie);
		       }
		       else
		       {
		          Cookie[] cookies = request.getCookies();
		          if(cookies!=null&&cookies.length>0)
		          {
		             for(Cookie c:cookies)
		             {
		                if(c.getName().equals("Username")||c.getName().equals("Password"))
		                {
		                    c.setMaxAge(0); 
		                    c.setPath(request.getContextPath()+"/");
		                    response.addCookie(c); 
		                }
		             }
		          }
		       }
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			if(type.equals("管理员")){
				response.sendRedirect(request.getContextPath()+"/Administrator.jsp");
			}
			if(type.equals("普通用户")){
				response.sendRedirect(request.getContextPath()+"/GeneralUser.jsp");
			}
		}
		else
		{
			response.sendRedirect(request.getContextPath()+"/LonginFailed.jsp?a=ture");
		}
	}					
}
