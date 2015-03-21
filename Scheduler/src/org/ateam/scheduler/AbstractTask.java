package org.ateam.scheduler;

import java.util.Date;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public abstract class AbstractTask implements Delayed
{
	private long runTime;
	
	public AbstractTask(Date scheduledDate)
	{
		this.runTime = scheduledDate.getTime();
	}
	
	public AbstractTask(long delay, TimeUnit timeUnit)
	{
		
		if (timeUnit != TimeUnit.MILLISECONDS)
			delay = TimeUnit.MILLISECONDS.convert(delay, timeUnit);
		this.runTime = System.currentTimeMillis() + delay;
	}
	
	public abstract void execute();
	
	@Override
	public int compareTo(Delayed o)
	{
		long delay2 = ((AbstractTask) o).runTime;
		return (runTime < delay2 ? -1 : (runTime == delay2 ? 0 : 1));
	}
	
	@Override
	public long getDelay(TimeUnit unit)
	{
		return TimeUnit.NANOSECONDS.convert(
				runTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
	}
	
}
