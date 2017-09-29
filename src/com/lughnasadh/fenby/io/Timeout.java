package com.lughnasadh.fenby.io;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Timeout {

	   private static Timeout instance = null;
	   
	   ScheduledExecutorService executor;
	   
	   //timer thresholds in seconds
	   private static int warning = 15;
	   private static int done = 20;
	     
	   protected Timeout() {
	      // Exists only to defeat instantiation.
	   }
	   public static Timeout getInstance() {
	      if(instance == null) {
	         instance = new Timeout();
	      }
	      return instance;
	   }

	   public void timerStart() {
		   
		   executor = Executors.newSingleThreadScheduledExecutor();

		   // Start the Warning task
		   Runnable warningTask = new Runnable() {
               public void run() {
                   //your code

               }
          };
		   executor.schedule(warningTask, warning, TimeUnit.SECONDS);

		   // Start the Warning task
		   Runnable killTask = new Runnable() {
               public void run() {
                   //your code

               }
          };
		   executor.schedule(killTask, done, TimeUnit.SECONDS);
		   

	   }		   
		   
	public void reset() {	   
		   // and finally, when your program wants to exit
		   executor.shutdown();
		   
		   
	   }
}
