package com.niit.supportclasses;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.niit.model.User;



public class ApproveReserveEmail {

	public static void sendEmail(User u,String bookname) {
	  int port=25;
	  String host="smtp.qq.com";  
	  final String user="784991263@qq.com";//change accordingly  
	  final String password="jhzlaxziykknbbgi";//change accordingly  
	    
	  String to=u.getEmail();//change accordingly  
	  
	   //Get the session object  
	   Properties props = new Properties();  
	   props.put("mail.smtp.host",host);  
	   props.put("mail.smtp.auth", "true");
	  // props.put("mail.smtp.port", port);
	   props.put("mail.smtp.ssl.enable", "true");
	     
	   Session session = Session.getDefaultInstance(props,  
	    new javax.mail.Authenticator() {  
	      protected PasswordAuthentication getPasswordAuthentication() {  
	    return new PasswordAuthentication(user,password);  
	      }  
	    });  
	  
	   //Compose the message  
	    try {  
	     MimeMessage message = new MimeMessage(session);  
	     message.setFrom(new InternetAddress(user));  
	     message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
	     message.setSubject("Demo email from Adam");  
	     message.setText("Sorry,Dear User,your reserve request For "+bookname+  " book is approved by the admin");  
	       
	    //send the message  
	     Transport.send(message);  
	  
	     System.out.println("message sent successfully...");  
	   
	     } catch (MessagingException e) {e.printStackTrace();}  
	}
}
