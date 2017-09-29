package com.lughnasadh.fenby.announce;

import java.util.concurrent.BlockingQueue;

import com.lughnasadh.fenby.VoiceMessage;

import kuusisto.tinysound.Sound;
import kuusisto.tinysound.TinySound;

public class SpeechPlayer implements Runnable{

private BlockingQueue<VoiceMessage> voiceQueue;
    
    public SpeechPlayer(BlockingQueue<VoiceMessage> q){
        this.voiceQueue=q;
    }

  	@Override
    public void run() {
		TinySound.init();

        try{
            VoiceMessage msg;
            //consuming messages until exit message is received
            while((msg = voiceQueue.take()).getMsg() !="exit"){
            	
            	String thisFile = "resources/" +  msg.getMsg() + ".wav"; 
           	
            	System.out.println("About to say " + thisFile);
    			Sound item = TinySound.loadSound(thisFile);
    			item.play();
           	
            Thread.sleep(msg.getLen());
            }
        }catch(InterruptedException e) {
            e.printStackTrace();
        } 
   }
}