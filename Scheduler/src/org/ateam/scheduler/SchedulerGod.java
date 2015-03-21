package org.ateam.scheduler;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class SchedulerGod
{
	private final static SchedulerGod sg = new SchedulerGod();
	
	public static SchedulerGod getInstance()
	{
		return sg;
	}
	
	private DelayQueue<AbstractTask> queue = new DelayQueue<AbstractTask>();
	private ExecutorService es;
	
	private SchedulerGod()
	{
		es = Executors.newFixedThreadPool(Constants.CONSUMERS);
		for (int i = 0; i < Constants.CONSUMERS; i++)
		{
			es.execute(new Consumer(i));
		}
	}
	
	public void add(AbstractTask t)
	{
		if (es.isShutdown() || es.isTerminated())
			return;
		queue.add(t);
	}
	
	public void shutdown()
	{
		es.shutdown();
	}
	
	public void shutdownNow()
	{
		queue.clear();
		es.shutdownNow();
	}
	
	private final class Consumer extends Thread
	{
		
		private Consumer(int i)
		{
			super("Consumer : " + i);
			setDaemon(true);
		}
		
		public void run()
		{
			AbstractTask task;
			// problem with this is thread will keep waiting after the scheduler
			// has been shut down
			// solu will be provide the queue implementation with  default time for wait. so thread wil chek if scheduler is shutdown after timeouts
			while (!es.isShutdown() || !es.isTerminated())
			{
				try
				{
					task = queue.take();
					task.execute();
				} catch (Exception e)
				{
					// TODO: give call back to task stating it is failed...
				}
			}
		}
	}
}
