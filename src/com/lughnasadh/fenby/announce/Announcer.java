package com.lughnasadh.fenby.announce;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import com.lughnasadh.fenby.VoiceMessage;

public class Announcer {

	   private static Announcer instance = null;
	   
	   static BlockingQueue<VoiceMessage> voiceQueue;
	   
	   protected Announcer() {
	      // Exists only to defeat instantiation.
	   }
	   public static Announcer getInstance() {
	      if(instance == null) {
	          //Creating BlockingQueue of size 10
	          voiceQueue = new ArrayBlockingQueue<>(10);
	          SpeechPlayer sp = new SpeechPlayer(voiceQueue);
	          //starting producer to produce messages in queue
	          new Thread(sp).start();	
	          System.out.println("Speech player been started");
	         instance = new Announcer();
	      }
	      return instance;
	   }
	   
	   public void playItem(String item, int len) {
          VoiceMessage msg = new VoiceMessage(item, len);
          
            try {
                voiceQueue.put(msg);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

	   }
}
