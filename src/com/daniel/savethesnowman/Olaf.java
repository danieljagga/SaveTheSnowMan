package com.daniel.savethesnowman;

import java.util.Scanner;

public class Olaf {
	// Setup Stuff
	String[] phraseList = { "CURIOUSITYKILLEDTHECAT", "BETTERLATETHANNEVER", "BREAKALEG", "CALLITADAY",
			"CUTTINGCORNERS" };
	private int snowParts = 10;
	private boolean olafIsAlive = true;
	private boolean weArePlaying = true;
	private String secret;
	private String displaySecret = "";

//methods
	private void choosePhrase() {
		System.out.println("Choose a number from 0 - 4");
		Scanner phraseNumber = new Scanner(System.in);
		int phrase = phraseNumber.nextInt();
		secret = phraseList[phrase];
	}


	private String formDisplay() {
		for (int i = 0; i < secret.length(); i++) {
			displaySecret += "*";
		}
		return displaySecret;
	}

	public void startGame() {
		choosePhrase();
		formDisplay();
		if (olafIsAlive) {
			System.out.println("Olaf has " + snowParts + " parts remaining");
			System.out.println("Guess a letter (case does not matter):");
		}
	}
}
