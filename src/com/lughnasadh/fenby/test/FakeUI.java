package com.lughnasadh.fenby.test;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class FakeUI {

	public static void main(String[] args) {
	JFrame myFrame = new JFrame("Fenby UI tester");
		myFrame.setSize(200,200);
		myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		myFrame.setVisible(true);
	}
}
