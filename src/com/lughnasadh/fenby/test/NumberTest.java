package com.lughnasadh.fenby.test;

import java.util.Arrays;
import java.util.List;

import com.lughnasadh.fenby.announce.NumberUtils;

public class NumberTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		NumberUtils nu = new NumberUtils();
		String numbers = nu.getNumber(397);
		String action = "recording";
		List<String> items = Arrays.asList(numbers.split(" "));

		if (items.get(0).length() == 0){
			items.set(0, "File");
		}
		else
		{
			items.add(0, "File");
		}
		
		//items.add(action);

		System.out.println(items.size());
		
		for(int i=0; i<items.size(); i++)
		{
			System.out.println(items.get(i));
		}
		
	}

}
