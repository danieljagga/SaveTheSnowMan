package com.daniel.savethesnowman;

import java.util.Scanner;

public class SaveTheSnowman {

	public static void main(String[] args) {

		// Setup Stuff

		String[] phraseList = { "CURIOUSITYKILLEDTHECAT",
				"BETTERLATETHANNEVER",
				"BREAKALEG",
				"CALLITADAY",
				"CUTTINGCORNERS" };
		System.out.println("Choose a number from 0 - 4");
		Scanner phraseNumber = new Scanner(System.in);
		int phrase = phraseNumber.nextInt();
		String secret = phraseList[phrase];
		String displaySecret = "";
		String checking;
		int snowParts = 10;
		int numberOfGuesses = 0;
		int numberOfTimesFound = 0;
		boolean olafIsAlive = true;
		boolean weArePlaying = true;
		boolean gameWon = false;
		for (int i = 0; i < secret.length(); i++) {
			displaySecret += "*";
		}

		// Game Starts

		System.out.println("Olaf is finally doing whatever snow does in summer!\n"
				+ "Help him before it's too late by guessing the secret phrase.");
		while (weArePlaying && olafIsAlive) {
			if (olafIsAlive) {
				if (snowParts > 0) {

					System.out.println("The secret phrase is " + displaySecret);
					System.out.println("Olaf has " + snowParts + " snow parts remaining.\n"
							+ "Guess a letter (all letters are uppercase):");

					Scanner keyboardInput = new Scanner(System.in);
					String guess = keyboardInput.nextLine();

					int uniCodeValue = (guess.charAt(0));

					if (guess.length() != 1 || uniCodeValue < 65 || uniCodeValue > 90) // Not A Valid Letter
						System.out.println("That's not a valid letter! Try again:\n");
					else { // Check the guess
						numberOfGuesses += 1;
						String newDisplaySecret = "";
						for (int i = 0; i < secret.length(); i++) {
								checking = secret.substring(i, secret.length());
								int position = checking.indexOf(guess);
								if (position == 0) {
									newDisplaySecret += secret.charAt(i); // newly guessed character
									numberOfTimesFound += 1;
								} else {
									newDisplaySecret += displaySecret.charAt(i);
								} // replaces it with the '*'
							}
							displaySecret = newDisplaySecret;
							if (numberOfTimesFound > 0) {
								System.out.println("Congrats " + guess + " was found " + numberOfTimesFound
										+ " times in the secret phrase!");
								numberOfTimesFound = 0;
							} else {
								System.out.println("Yikes your guess was wrong");
								snowParts -= 1;
							}
							if (displaySecret.contains("*") == false) {
								weArePlaying = false;
								gameWon = true;
							}
						} // end of checking the letter
					} else { // we ran out of snow parts
					olafIsAlive = false;
				System.out.println("Olaf has melted, you guessed this much of the secret phrase:\n" + displaySecret);
			}
			} // end of olaf is alive
			else {
				weArePlaying = false;
			}
		}
		if (gameWon == true)
			System.out.println("You saved Olaf, you guessed the secret phrase : " + secret + " in " + numberOfGuesses
					+ " tries. Game Over"); // end of we are playing

	}// end of main method
}// end of class