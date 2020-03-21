import java.util.Scanner;

import javax.swing.JOptionPane;

public class RockPaperScissors {

	static int victories = 0, losses = 0, draws = 0, gamesPlayed = 0;
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		boolean again = true;
		Character userChoice, cpuChoice;
		
		System.out.println("Welcome to Rock/Paper/Scissors simulator!");
		
		do
		{
			userChoice = userChoice();
			cpuChoice = computerChoice();
			determineWinner(userChoice, cpuChoice);
			again = playAgain();
		} while (again == true);
		
		//print statistics
		JOptionPane.showMessageDialog(null, getStatistics());
		
		System.out.println("Thanks for playing!");
		
		System.exit(0);
		
	}
	
	public static char userChoice()
	{
		///////////////////////////////////////////////////////////////////////////
		// When the program begins, the user enters his or her choice of “rock”,
		// “paper”, or “scissors” at the keyboard using a menu in a function, 
		// userChoice, that returns a character.
		///////////////////////////////////////////////////////////////////////////
		
		System.out.print("Please choose [rock/paper/scissors]: ");
		String userIn;
		
		Character userChoice = null; //(compiler warns - "might reach end of non-void function")
		
		do
		{
			userIn = input.nextLine();
			if (userIn.equalsIgnoreCase("rock"))
				userChoice = 'r';
			else if (userIn.equalsIgnoreCase("paper"))
				userChoice = 'p';
			else if (userIn.equalsIgnoreCase("scissors"))
				userChoice = 's';
			else
				System.out.print("Please pick one of [rock/paper/scissors]: ");
		} while (!(userIn.equalsIgnoreCase("rock")) && !(userIn.equalsIgnoreCase("paper")) && !(userIn.equalsIgnoreCase("scissors")));
		
		System.out.print("You chose " + userIn + " and ");
		
		return userChoice;
	}
	
	public static char computerChoice()
	{
		////////////////////////////////////////////////////////////////////////////////
		// There should be a function, computerChoice, that generates the computer’s
		// play. A random number in the range of 1 through 3 is generated. If the
		// number is 1, then the computer has chosen rock. If the number is 2, then
		// the computer has chosen paper. If the number is 3, then the computer has
		// chosen scissors. The computer’s choice is returned as a character.
		////////////////////////////////////////////////////////////////////////////////
		int MAX = 3, MIN = 1; //abstraction
		int n = (int)(Math.random()*(MAX-MIN+1) + MIN);
		
		Character cpuChoice = null; //(compiler warns - "might reach end of non-void function")
		String out = "the computer chose ";
		
		switch (n)
		{
		case 1:
			cpuChoice = 'r';
			out += "rock";
			break;
		case 2:
			cpuChoice = 'p';
			out += "paper";
			break;
		case 3:
			cpuChoice = 's';
			out += "scissors";
			break;
		}
		
		System.out.println(out);
		
		return cpuChoice;
	}
	
	public static void determineWinner(char user, char cpu)
	{
		/////////////////////////////////////////////////////////////////////////////////////
		// determineWinner will determine the winner between the user’s choice vs.
		// the computer’s choice. (NOTE: It will return nothing, but it will take in
		// the user’s choice and the computer’s choice as the two arguments.) The result
		// is selected according to the following rules:
		// If one player chooses rock and the other player chooses scissors, then rock
		//  	 wins. (The rock smashes the scissors.)
		// If one player chooses scissors and the other player chooses paper, then scissors
		// 	 wins. (Scissors cuts paper.)
		// If one player chooses paper and the other player chooses rock, then paper wins.
		//   (Paper wraps rock.)
		// If both players make the same choice, the game ends in a draw and there is no
		//   winner.
		/////////////////////////////////////////////////////////////////////////////////////
		
		gamesPlayed++;
		
		//if tie
		if (user == cpu)
		{
			String out = "you both chose ";
			switch(user)
			{
			case 'r':
				out += "rock => ";
				break;
			case 's':
				out += "scissors => ";
				break;
			case 'p':
				out += "paper => ";
				break;
			}
			out += "it's a draw...";
			System.out.println(out);
			draws++;
			return;
		}
		//else if not tie
		else if ((user == 'r' && cpu == 's') || (user == 's' && cpu == 'r'))
			System.out.print("[rock smashes scissors] => ");
		else if ((user == 's' && cpu == 'p') || (user == 'p' && cpu == 's'))
			System.out.print("[scissors cut paper ] => ");
		else if ((user == 'r' && cpu == 'p') || (user == 'p' && cpu == 'r'))
			System.out.print("[paper wraps rock] => ");
		
		//if user wins
		if ((user == 'r' && cpu == 's') || (user == 's' && cpu == 'p') || (user == 'p' && cpu == 'r'))
		{
			System.out.println("you won!");
			victories++;
		}
		//if computer wins
		else
		{
			System.out.println("the computer won...");
			losses++;
		}
	}
	
	public static Boolean playAgain()
	{
		////////////////////////////////////////////////////////////////////////////////
		// playAgain prompts the user to see if they want to play again. The function
		// returns a boolean.
		////////////////////////////////////////////////////////////////////////////////
		System.out.print("Play again? [yes/no]: ");
		boolean again = true;
		
		while (true)
		{
			String userIn = input.nextLine();
			if (userIn.equalsIgnoreCase("yes"))
			{
				again = true;
				break;
			}
			else if (userIn.equalsIgnoreCase("no"))
			{
				again = false;
				break;
			}
			else
				System.out.print("please pick from [yes/no]: ");	
		}
		
		return again;
	}
	
	public static String getStatistics()
	{
		///////////////////////////////////////////////////////////////////////////
		//getStatistics returns the number of victories out of total games played
		///////////////////////////////////////////////////////////////////////////
		String out = "Out of " + gamesPlayed;
		
		//account for proper grammar
		String game, lost, won;
		if (gamesPlayed == 1)
			game = " game";
		else
			game = " games";
		if (losses == 1)
			lost = " game";
		else
			lost = " games";
		if (victories == 1)
			won = " game";
		else
			won = " games";
		
		out += game + " played, you won " + victories + won + ", lost " + losses + lost + ", and tied the computer " + draws + " times.";
		return out;
	}

}