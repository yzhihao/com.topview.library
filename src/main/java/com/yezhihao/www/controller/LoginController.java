package com.yezhihao.www.controller;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.ServletRequestEvent;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.yezhihao.www.po.Listener_UserPo;
import com.yezhihao.www.po.UserPo;
import com.yezhihao.www.service.LonginService;

/*
 *登录的controller 
 **/

@Controller

public class LoginController {
	
	@Autowired
	private LonginService longinService;
	
	/*该方法验证登录*/
	@RequestMapping(value="/servlet/LonginServlet")  
	public ModelAndView loginController(@ModelAttribute("user")UserPo user,HttpServletRequest request,HttpServletResponse response) throws Exception{
	    	ModelAndView mv = new ModelAndView();
	    	
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
					mv.addObject("a", "false");
					mv.setViewName("LonginFailed");
					//response.sendRedirect(request.getContextPath()+"/LonginFailed.jsp?a=false");
					return mv;
				}
		      }
		     
		      boolean a = false;
		      a=longinService.login(user);
		    
		      if(a)
				{
				       String[] isUseCookies = request.getParameterValues("isUseCookie");
				       if(isUseCookies!=null&&isUseCookies.length>0)
				       {
				          String username1 = URLEncoder.encode(user.getUsre_name(),"utf-8");
				          String password1 = URLEncoder.encode(user.getPassword(),"utf-8");
				          
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
					session.setAttribute("username", user.getUsre_name());
					if(user.getType().equals("管理员")){
						mv.setViewName("Administrator");
				        return mv;
					}
					if(user.getType().equals("普通用户")){
						mv.addObject("a", "ture");
						mv.setViewName("GeneralUser");
				        return mv;
					}
				}
				else
				{
					mv.addObject("a", "ture");
					mv.setViewName("LonginFailed");
			        return mv;
				}
		      
		      return mv; 
	}
	
	@RequestMapping(value="/Listener")  
	public ModelAndView Listener(ServletRequestEvent request){
		ModelAndView mv = new ModelAndView();
		@SuppressWarnings("unchecked")
		ArrayList<Listener_UserPo>  userList = (ArrayList<Listener_UserPo>) request.getServletContext().getAttribute("userList"); 
	    mv.addObject("userList", userList);
	    mv.setViewName("Listener");
		return mv;
		}
}
