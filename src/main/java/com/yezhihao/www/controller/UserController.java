package com.yezhihao.www.controller;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.yezhihao.www.dao.User;
import com.yezhihao.www.po.UserPo;
import com.yezhihao.www.service.Md5;



@Controller
@RequestMapping(value="/servlet")  
public class UserController {
	@Autowired
	private User user;
	
	@Autowired
	private com.yezhihao.www.service.SentMailService SentMailService;

	@RequestMapping(value="/ShowUser")  
	public ModelAndView AddBook() throws Exception{
		ModelAndView mv = new ModelAndView();
        ArrayList<UserPo> list=(ArrayList<UserPo>) user.getgeneralUser("普通用户");
        mv.addObject("list", list);
        mv.setViewName("ShowUser");
		return mv;
		}
	
	@RequestMapping(value="/AnswerPossword_Q")  
	public ModelAndView AnswerPossword_Q(@RequestParam(value="username" ) String  username) throws Exception{
		ModelAndView mv = new ModelAndView();
		UserPo user1=user.getuserbyusername(username);
		mv.addObject("user", user1);
        mv.setViewName("AnswerPossword_Q");
		return mv;
		}
	
	@RequestMapping(value="/ChangePassword")  
	public ModelAndView ChangePassword(@RequestParam(value="username" ) String  username,@RequestParam(value="answer" ) String  answer,@RequestParam(value="a1" ) String  a1) throws Exception{
		ModelAndView mv = new ModelAndView();
		@SuppressWarnings("unused")
		String answer1=Md5.getMD5(answer);
		/*System.out.print(answer);
		if(answer.equals(request.getParameter("a1"))){%>
		*/
		if(answer.equals(a1)){
		mv.addObject("a1", "ture");
		}else{
		mv.addObject("a1", "false");	
		}
		mv.addObject("username", username);
        mv.setViewName("ChangePassword");
		return mv;
		}

	@RequestMapping(value="/ChangePosswordServlet")  
	public ModelAndView ChangePosswordServlet(@RequestParam(value="possword" ) String  possword,@RequestParam(value="username" ) String  username) throws Exception{
		ModelAndView mv = new ModelAndView();
		String possword1= Md5.getMD5(possword);
		UserPo UserPo=new UserPo();
		UserPo.setPossword_request(possword1);
		UserPo.setUsre_name(username);
		user.updateuserdao(UserPo);
		//mv.addObject("username", username);
        mv.setViewName("ChangePossword_S");
		return mv;
		}
	
	@RequestMapping(value="/setmail")  
		public ModelAndView setmail(@RequestParam(value="possword" ) String  possword,@RequestParam(value="username" ) String  username) throws Exception{
			ModelAndView mv = new ModelAndView();
			SentMailService.sentMail();
	        mv.setViewName("setmailsuccess");
			return mv;
			}
	
}
