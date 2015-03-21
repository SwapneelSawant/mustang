/**
 * 
 */
package org.ateam.scheduler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.ateam.scheduler.AbstractTask;
import org.ateam.scheduler.SchedulerGod;
import org.ateam.scheduler.SimpleTask;

/**
 * @author swaps
 *
 */
public class T1
{
	public static void main(String[] args) throws ParseException,
			InterruptedException
	{
		// this is basic schedular,
		// task are maintain in memory queue
		// consumers, queue, producers would be manage my the SchedularGod
		// user only need to define task
		// and add task to the SchedularGod
		//
		
		SchedulerGod sg = SchedulerGod.getInstance();
		// to run a task after one min
		AbstractTask t = new SimpleTask(1, TimeUnit.MINUTES);
		sg.add(t);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		Date date = sdf.parse("28-02-2015 12:27");
		t = new SimpleTask(date);
		sg.add(t);
		
		date = sdf.parse("28-02-2015 12:28");
		t = new SimpleTask(date);
		sg.add(t);
		sg.shutdownNow();
		
		// need to work on shutdown
		
	}
}
