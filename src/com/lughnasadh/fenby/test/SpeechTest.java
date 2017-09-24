package com.lughnasadh.fenby.test;

import com.lughnasadh.fenby.announce.NumberUtils;
import com.lughnasadh.fenby.announce.WavePlayer;

import kuusisto.tinysound.TinySound;

public class SpeechTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//initialize TinySound
		TinySound.init();
		NumberUtils nu = new NumberUtils();
		WavePlayer player = new WavePlayer();
		
		player.playNumbers(nu.getNumber(84), "ready");
		
	}

}
