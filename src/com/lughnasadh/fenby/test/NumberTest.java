package com.lughnasadh.fenby.test;

import com.lughnasadh.fenby.announce.NumberUtils;

public class NumberTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		NumberUtils nu = new NumberUtils();
		
		System.out.println(nu.getNumber(7));
		System.out.println(nu.getNumber(14));
		System.out.println(nu.getNumber(27));
		System.out.println(nu.getNumber(84));
		System.out.println(nu.getNumber(100));
		System.out.println(nu.getNumber(106));
		System.out.println(nu.getNumber(28));
		System.out.println(nu.getNumber(397));
		System.out.println(nu.getNumber(300));		
		
	}

}
