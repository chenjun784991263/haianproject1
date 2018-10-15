package com.niit.supportclasses;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* created by :-prateek kamdar
created date:-12/9/2018
updated by:-null
updated date:-null 
*/

public class GeneralSupport {

	public static String getDate() {
		 DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
	     Date dateobj = new Date();
	     String date=df.format(dateobj).toString();
	   
	     return date;
	}
	
	public static String getDate(Calendar cal) {
		 DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
	     Date date=cal.getTime();
	     String date1=df.format(date).toString();
	   
	     return date1;
	}
	
	
	public static Calendar getCalTime(String time)
	{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
		  Calendar cal=null;
		try {
			Date date =sdf.parse(time);
		    cal=Calendar.getInstance();
		    cal.setTime(date);
		
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cal;
		
		
	}
	
	public static Date getTime(String time)
	{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
		Date date=null;
		try {
			date =sdf.parse(time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return date;
		
		
	}
	
	
	
	  public static int differentDaysByMillisecond(Date date1,Date date2)
	    {
	        int days = (int) ((date2.getTime() - date1.getTime()) / (1000*3600*24));
	        return days;
	    }
	
	
	
		
		
		
		
		
		
	
	
}
