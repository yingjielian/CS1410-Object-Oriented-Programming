package lab02;
/**
 * This class implements this cool idea: Playing the rock-paper-scissors game. The game will ask user
 * put their guess and compare to the computer guess. The rules followed by the basic rules people
 * player in real world.
 * 
 * 
 * @author Yingjie Lian
 * @version January 17, 2017
 */

import java.util.Scanner;

public class RockPaperScissors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Create two String variables, one named playerGuess and the other
	//   named computerGuess, set them equal to empty strings:  ""
		
		String playerGuess, computerGuess;
		
		playerGuess = "";
		computerGuess = "";

	// Make a random integer between [0...2].  If the random integer is a
	//   0, set the computer guess to "rock", if it's a 1, set the computer
	//   guess to "paper", otherwise set the computer guess to "scissors".
		
		int value = (int) (Math.random() * 3);
		
		if (value == 0)
			computerGuess = "rock";
		
		else if (value == 1)
			computerGuess = "paper";
		
		else
			computerGuess = "scissors";

	// Using a Boolean flag, create an input loop that asks the player to enter
	//   their guess.  Don't allow the program to proceed until the player
	//   enters either "rock", "paper", or "scissors".
		Scanner in = new Scanner(System.in);
		
		boolean userInputIsOK = false;
		
		while (! userInputIsOK )
		{
			System.out.println("Enter rock, paper, or scissors: ");
			playerGuess = in.next();
			
			if (playerGuess.equals("rock") || playerGuess.equals("paper") || playerGuess.equals("scissors"))
				userInputIsOK = true;
		}
		
	// Print out the computer's guess:  "I picked rock.", etc.
		
		System.out.println("I picked " + computerGuess + ".");

	// Write a few 'if' statements to determine the result of the game and
	//   print out the winner:  "I win",  "You win", "It's a tie"
	// If the strings are the same, its a tie.
	//  else if the player picks "rock" and the computer picks "scissors", the player wins,
	//  else if ... (etc.)
		if (playerGuess.equals("rock") && computerGuess.equals("scissors"))
			System.out.println("You win.");
		
		else if (playerGuess.equals("rock") && computerGuess.equals("paper"))
			System.out.println("I win.");
		
		else if (playerGuess.equals("paper") && computerGuess.equals("scissors"))
			System.out.println("I win.");
		
		else if (playerGuess.equals("paper") && computerGuess.equals("rock"))
			System.out.println("You win.");
		
		else if (playerGuess.equals("scissors") && computerGuess.equals("rock"))
			System.out.println("I win.");
		
		else if (playerGuess.equals("scissors") && computerGuess.equals("paper"))
			System.out.println("You win.");
		
		else
			System.out.println("It's a tie.");
	}

}
