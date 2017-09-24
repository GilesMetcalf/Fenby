package com.lughnasadh.fenby.recognise;

import edu.cmu.sphinx.frontend.util.Microphone;
import edu.cmu.sphinx.recognizer.Recognizer;
import edu.cmu.sphinx.result.Result;
import edu.cmu.sphinx.util.props.ConfigurationManager;

public class FenbyRecogniser {

	public static FenbyRecogniser instance;
	private static Boolean enabled;
	private static Recognizer recognizer; 
	
	
	protected FenbyRecogniser() {
		//Code in here...
        ConfigurationManager cm;
        cm = new ConfigurationManager(FenbyRecogniser.class.getResource("fenby.config.xml"));

        recognizer = (Recognizer) cm.lookup("recognizer");
        recognizer.allocate();

        // start the microphone or exit if the programm if this is not possible
        Microphone microphone = (Microphone) cm.lookup("microphone");
        if (!microphone.startRecording()) {
            System.out.println("Cannot start microphone.");
            recognizer.deallocate();
            System.exit(1);
        }		
		
	}
	
	public static FenbyRecogniser getInstance() {
		if(instance == null) {
			instance = new FenbyRecogniser();
		}
		return instance;
	}
	
	public static void enableRecogniser(Boolean en) {
		enabled = en;
	}
	
	public static String listen() {
       String resultText = "";
       while (enabled) {
            System.out.println("Start speaking. Press Ctrl-C to quit.\n");
            Result result = recognizer.recognize();
            if (result != null) {
                resultText = result.getBestFinalResultNoFiller();
                System.out.println("You said: " + resultText + '\n');
	            } 
            else 
            	{
	                System.out.println("I can't hear what you said.\n");
	            }	
       		}
		return resultText;
	}
	
}
