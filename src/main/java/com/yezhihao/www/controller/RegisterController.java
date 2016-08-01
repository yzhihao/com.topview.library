package com.yezhihao.www.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.yezhihao.www.dao.User;
import com.yezhihao.www.po.UserPo;
import com.yezhihao.www.service.RegisterUserService;
import com.yezhihao.www.view.RegisterUserServlet;

@Controller
public class RegisterController {

	@Autowired
	private RegisterUserService RegisterUserService;
	
	@Autowired
	private User user1;
	
	/*注册用户,@InitBinder,@ModelAttribute("user")UserPo user*/
	@InitBinder  
    public void initBinder(WebDataBinder binder) {  
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
        dateFormat.setLenient(false);  
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));  
    }  
	
	@RequestMapping(value="/servlet/RegisterUserServlet")  
	public ModelAndView registerController(@RequestParam(value="usre_name" ) String  usre_name,@RequestParam(value="password" ) String  password,@RequestParam(value="possword_request" ) String  possword_request,@RequestParam(value="possword_right" ) String  possword_right,
			@RequestParam(value="type" ) String  type,@RequestParam(value="user_amg" ,required=false) MultipartFile user_amg,HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView();
		UserPo user=new UserPo();
		user.setUsre_name(usre_name);
		user.setPassword(password);
		user.setPossword_request(possword_request);
		user.setPossword_right(possword_right);
		user.setType(type);
		System.out.println("经过controller"+usre_name);
	    		String filePath=request.getSession().getServletContext().getRealPath("/");
	    		System.out.println(filePath);
	    		
	    		String date=new SimpleDateFormat("yyyyMMddHHmmssSSS") .format(new Date() );
		         Random random=new Random();//创建一个随机数对象
		         int result=random.nextInt(1000);
	    		//for(MultipartFile file:user_amg){
		         user_amg.transferTo(new File(filePath+"amg_lib/"+date+result+user_amg.getOriginalFilename()));			
	    		//}
	    		
	 		   ArrayList<UserPo> userlist=new ArrayList<UserPo>();
	 		   try {
	 			userlist=(ArrayList<UserPo>) user1.getUser();
	 		} catch (Exception e) {
	 			e.printStackTrace();
	 		}
	 		   int ret=0;
	 		   for(UserPo user2 :userlist){
	 			  if(user2.getUsre_name().equals(user.getUsre_name())){
	 				   ret=1;
	 				   break;
	 			  }
	 		   }
	 		   System.out.println("经过controller");
	 		   if(ret==1){
	 			  mv.setViewName("RegisterFali");
					return mv;
	 		   }
 			   else{
 				   	mv.addObject("user", user);
 			    	String password_right=RegisterUserServlet.getMD5(user.getPossword_right());
 			    	String password1=RegisterUserServlet.getMD5(user.getPassword());
 			    	user.setPassword(password1);
 			    	user.setUser_amg(date+result+user_amg.getOriginalFilename());
 			    	user.setPossword_right(password_right);
 			    	RegisterUserService.adduser(user);
 			    	mv.setViewName("RegisterSuceess");
 					return mv;
 			   }
	}
	
}
