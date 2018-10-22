package com.niit.quartz;


import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzService {

	public static void main(String[] args) {
		
		JobDetail jobdetail=(JobDetail) JobBuilder.newJob(MyJob.class).withIdentity("job1","group1").build();
		
		TriggerBuilder<Trigger> triggerBuilder=TriggerBuilder.newTrigger();
		triggerBuilder.withIdentity("tirgger1","group1");
		triggerBuilder.startNow();
		
		triggerBuilder.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInHours(4).withRepeatCount(10000000));
		
		Trigger trigger=triggerBuilder.build();
		
		SchedulerFactory sf= new StdSchedulerFactory();
		try {
			
			Scheduler scheduler=sf.getScheduler();
			scheduler.scheduleJob(jobdetail,trigger);
			scheduler.start();
			
			
			
			
			
		}catch(SchedulerException se)
		{
			se.printStackTrace();
		}
	
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
}
