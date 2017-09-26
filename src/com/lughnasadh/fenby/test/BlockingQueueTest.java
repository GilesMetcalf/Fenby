package com.lughnasadh.fenby.test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import com.lughnasadh.fenby.Consumer;
import com.lughnasadh.fenby.Message;
import com.lughnasadh.fenby.Producer;
import com.lughnasadh.fenby.announce.NumberUtils;

import kuusisto.tinysound.Sound;
import kuusisto.tinysound.TinySound;

public class BlockingQueueTest {

	public static void main(String[] args) {
        //Creating BlockingQueue of size 10
        BlockingQueue<Message> voiceQueue = new ArrayBlockingQueue<>(10);
        BlockingQueue<Message> commandQueue = new ArrayBlockingQueue<>(10);
        
        
        Message msg;
       
        Consumer consumer = new Consumer(voiceQueue);
        //starting producer to produce messages in queue
        new Thread(consumer).start();
        System.out.println("Producer and Consumer have been started");

		NumberUtils nu = new NumberUtils();
		String numbers = nu.getNumber(397);
		String action = "record";
		
		List<String> items = Arrays.asList(numbers.split(" "));
		
		if (items.get(0).length() == 0){
			items.set(0, "file");
		}
		
		for (int i=0; i<items.size(); i++)
		{
            msg = new Message(items.get(i));
            try {
                voiceQueue.put(msg);
                System.out.println("Produced "+msg.getMsg());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
		}
		
		msg = new Message("record");
		try {
			voiceQueue.put(msg);
            System.out.println("Produced "+msg.getMsg());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
