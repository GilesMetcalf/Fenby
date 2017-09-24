package com.lughnasadh.fenby.announce;

import java.util.Arrays;
import java.util.List;

import kuusisto.tinysound.Sound;
import kuusisto.tinysound.TinySound;

public class WavePlayer {

	public void playNumbers(String numbers, String action) {
		
		List<String> items = Arrays.asList(numbers.split("\\s*,\\s*"));
		
		if (items.get(0) == null){
			items.set(0, "File");
		}
		else
		{
			items.add(0, "File");
		}
		
		items.add(action);
		
		for (int i=0; i<items.size(); i++)
		{
			Sound item = TinySound.loadSound(items.get(i) + ".wav");
			item.play();
		}
		
	}

}


