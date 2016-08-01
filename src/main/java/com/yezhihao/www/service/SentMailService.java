package com.yezhihao.www.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.URLName;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

import com.sun.mail.smtp.SMTPTransport;

@Service
public class SentMailService {
	public void sentMail() throws MessagingException{
		  @SuppressWarnings("unused")
		String result;
		   // 收件人的电子邮件
		   String to = "1193337545@qq.com";

		   // 发件人的电子邮件
		   String from = "1079345916@qq.com";

		   // 假设你是从本地主机发送电子邮件
		   String host = "localhost";

		   // 获取系统属性对象
		   Properties properties = System.getProperties();

		   // 设置邮件服务器
		   properties.setProperty("mail.smtp.host", host);
		   
		   properties.setProperty("mail.user", "1079345916@qq.com");
		   properties.setProperty("mail.password", "inwhieotlhqliajc");
		   

		  
		   // 获取默认的Session对象。
		   Session mailSession = Session.getDefaultInstance(properties);
		   Transport transport = new SMTPTransport(mailSession,new URLName("localhost"));
		   transport.connect("localhost",465,null,null);
		   try{
		      // 创建一个默认的MimeMessage对象。
		      MimeMessage message = new MimeMessage(mailSession);
		      // 设置 From: 头部的header字段
		      message.setFrom(new InternetAddress(from));
		      // 设置 To: 头部的header字段
		      message.addRecipient(Message.RecipientType.TO,
		                               new InternetAddress(to));
		      // 设置 Subject: header字段
		      message.setSubject("This is the Subject Line!");
		     
		      // 设置 HTML消息
		      message.setContent("<h1>This is actual message</h1>",
		                            "text/html" );
		      // 发送消息
		      Transport.send(message);
		      result = "Sent message successfully....";
		   }catch (MessagingException mex) {
		      mex.printStackTrace();
		      result = "Error: unable to send message....";
		   }
	}
	public static void main(String[] args) throws MessagingException {
		new SentMailService().sentMail();
	}
}
