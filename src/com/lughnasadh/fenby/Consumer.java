package com.lughnasadh.fenby;

import java.io.File;
import java.util.concurrent.BlockingQueue;

import kuusisto.tinysound.Sound;
import kuusisto.tinysound.TinySound;

public class Consumer implements Runnable{

private BlockingQueue<Message> voiceQueue;
    
    public Consumer(BlockingQueue<Message> q){
        this.voiceQueue=q;
    }

    @Override
    public void run() {
		TinySound.init();

        try{
            Message msg;
            //consuming messages until exit message is received
            while((msg = voiceQueue.take()).getMsg() !="exit"){
            	
            	String thisFile = "resources/" + msg.getMsg() + ".wav"; 
            	ClassLoader classLoader = getClass().getClassLoader();
            	File file = new File(classLoader.getResource(thisFile).getFile());
           	
    			Sound item = TinySound.loadSound(thisFile);
    			item.play();
             	
            Thread.sleep(10);
            System.out.println("Consumed "+ msg.getMsg());
            System.out.println("Trying to play " + thisFile);
            }
        }catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}