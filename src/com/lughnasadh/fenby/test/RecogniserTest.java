package com.lughnasadh.fenby.test;

import com.lughnasadh.fenby.recognise.FenbyRecogniser;

public class RecogniserTest {

	public static FenbyRecogniser recog;
	
	public static void main(String[] args) {
		String heard = "";
		recog = FenbyRecogniser.getInstance();
		recog.enableRecogniser(true);
		while(heard.isEmpty()) {
			heard = recog.listen();
			System.out.println("Heard:" + heard);		
		}
		recog.enableRecogniser(false);
		
		
	}

}
