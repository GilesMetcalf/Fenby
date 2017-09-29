package com.lughnasadh.fenby.test;

import java.util.Arrays;
import java.util.List;
import com.lughnasadh.fenby.announce.Announcer;
import com.lughnasadh.fenby.announce.NumberUtils;

public class BlockingQueueTest {

	public static void main(String[] args) {
        //Creating BlockingQueue of size 10
        int fileCount = 200;
        
        Announcer announcer = Announcer.getInstance();
		NumberUtils nu = new NumberUtils();
		String numbers = nu.getNumber(fileCount);
		System.out.println("Saying " + numbers);
		String action = "record";
		
		List<String> items = Arrays.asList(numbers.split(" "));
		
		if (items.get(0).length() == 0){
			items.set(0, "file");
		}
		
		for (int i=0; i<items.size(); i++)
		{
			announcer.playItem(items.get(i),350);
		}
		
		
		announcer.playItem(action,350);


	}

}
