package com.lughnasadh.fenby;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import com.lughnasadh.fenby.announce.Announcer;
import com.lughnasadh.fenby.announce.SpeechPlayer;
import com.lughnasadh.fenby.test.FakeUI;

import kuusisto.tinysound.Music;
import kuusisto.tinysound.Sound;
import kuusisto.tinysound.TinySound;

public class Fenby {

	public static void main(String[] args) {
		//Boot up config
		
		//Start up fake UI... (Needs to be replaced with RaspPi GPIO setup)
		FakeUI fui = new FakeUI();
		
		//Set up speech stuff..
		Announcer announcer = Announcer.getInstance();
		announcer.playItem("welcome",500);

		//Set up recogniser
		

		
		
		
	}

}
