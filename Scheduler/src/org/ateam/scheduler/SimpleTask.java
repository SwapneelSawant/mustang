package org.ateam.scheduler;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class SimpleTask extends AbstractTask
{
	
	public SimpleTask(Date scheduledDate)
	{
		super(scheduledDate);
	}
	
	public SimpleTask(long delay, TimeUnit timeUnit)
	{
		super(delay, timeUnit);
	}
	
	@Override
	public void execute()
	{
		System.out.println(new Date());
		
	}
	
}
