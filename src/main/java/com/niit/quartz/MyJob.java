package com.niit.quartz;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.Set;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;


import com.niit.dao.AdminDao;
import com.niit.dao.UserDAO;
import com.niit.model.BorrowRecord;

public class MyJob implements Job {

	public void execute(JobExecutionContext context) throws JobExecutionException {
		try {
			Set<BorrowRecord> set=UserDAO.QueryOverdueBorrowRecord();
		    Iterator<BorrowRecord> iterator =set.iterator();
		    while(iterator.hasNext())
		    {
		    	
		    	WarningEmail.sendEmail(AdminDao.getUser(iterator.next().getUserid()));
		    	
		    	
		    	
		    }
		
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
	}

}
