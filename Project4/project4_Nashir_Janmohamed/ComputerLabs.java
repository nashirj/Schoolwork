//Nashir Janmohamed

//Project 4

/*
 *Each user has a unique five-digit ID Number. Whenever a user logs on,
 *the user's ID, Lab Number, and the computer station are transmitted
 *to your station. For example, if user 49193 logs onto station 2 in
 *Lab 3, your system receives (49193, 2, 3) as input data. Similarly,
 *when a user logs off a station, your system receives the Lab Number
 *and computer station number.
 *
 *Write a computer program that could be used to track, by lab, which
 *user is logged onto which computer. For example, if user 49193 is
 *logged into station 2 in lab 3 and user 99577 is logged into station
 *1 of lab 4, then your system might display the following:-
 *Lab Number   Computer Stations
 *1            1: empty  2: empty  3: empty  4: empty  5: empty
 *2            1: empty  2: empty  3: empty  4: empty  5: empty  6: empty
 *3            1: empty  2: 49193  3: empty  4: empty
 *4            1: 99577  2: empty  3: empty
 *Task:-
 *1. Create a menu that allows the administrator to simulate the
 *transmission of information by manually typing in the login or logoff
 *data. Whenever someone logs in or out, the display table should be
 *updated.
 *2. Write a search option so the administrator can type in a user Id
 *and the system will output what Lab Number and station number the user
 *is logged into, or "None" if the user Id is not logged into any computer
 *station.
 *You should use a fixed array of length 4 for the labs. Each array entry
 *points to a dynamic array that stores the user login information for
 *each respective computer station.
 *
 */

import java.util.Scanner;

public class ComputerLabs {
	
	//global variable(s)
	private static int LABSIZE = 4; //encapsulation makes it easier to do edits later

	private static Scanner input = new Scanner(System.in);
	
	public static void main(String [] args) {
		Lab [] labs = new Lab[LABSIZE];
		//create Labs
		labs[0] = new Lab(5);
		labs[1] = new Lab(6);
		labs[2] = new Lab(4);
		labs[3] = new Lab(3);
		
		int menuChoice, labNumber, cpuStation;
		String ID;
		//boolean success; //used to test whether or not user is loggedIn
		
		//logIn(), isLoggedIn(), and search() are very similar, but how to combine into one?
		do {
			printLabs(labs);
			printMenu(); 
			menuChoice = input.nextInt();
			if (menuChoice == 0) {
				System.out.println("Goodbye!");
				break; //end program
			}
			else if (menuChoice == 1) {
				//get ID
				System.out.println("Enter the 5 digit ID number of the user logging in:");
				ID = input.next();

				//make sure user is not logged in to another station already
				if (isLoggedIn(labs, ID)) {
					System.out.println("That user is already logged in...\n");
					continue;
				}
				
				//which station?
				System.out.println("Enter the lab number the user is logging in from (1-" + LABSIZE + "):");
				labNumber = input.nextInt();
				//check for valid input
				labNumber = validateInput(labNumber, LABSIZE);
				
				//which computer?
				int numStations = labs[labNumber-1].getNumberStations(); //number of cpu stations for specified lab
				System.out.println("Enter computer station number the user is logging in to (1-"+ numStations + "):");
				cpuStation = input.nextInt();
				//check for valid input
				cpuStation = validateInput(cpuStation, numStations);
				
				//log the user in
				labs[labNumber-1].logIn(ID, cpuStation-1);
			}
			else if (menuChoice == 2) {
				//get ID
				System.out.println("Enter the 5 digit ID number of the user to find:");
				ID = input.next();
				logOff(labs, ID);
				
//				if (isLoggedIn(labs, iD)) {
//					logOff(labs, iD);
//					System.out.println("User " + iD + " is logged off");
//				}
//				else
//					System.out.println("That user could not be found");
			}
			else if (menuChoice == 3) {
				//get ID
				System.out.println("Enter the 5 digit ID number of the user to find:");
				ID = input.next();
				search(labs, ID);
				
//				if (isLoggedIn(labs, iD)) {
//					search(labs, iD);
//					System.out.println("Lab #" + (i+1) + ", Station #" + (j+1) + "\n");
//				}
//				else
//					System.out.println("None");
			}
			System.out.println(); //newline for formatting purposes
		}while (menuChoice != 0);
		
		input.close(); //close Scanner object
		System.exit(0);
	}
	
	
	
	
	//display status of all labs
	public static void printLabs(Lab [] tempLab) {
		System.out.println("LAB STATUS");
		System.out.println("Lab # Computer Stations");
		for (int i = 0; i < LABSIZE; i++) {
			System.out.print((i+1) + " "); //i+1 for formatting purposes
			tempLab[i].printStatus(); //print status of each lab individually
			System.out.println();
		}
		System.out.println();
	}
	public static void printMenu() {
		System.out.println(
							"MAIN MENU\n"
						  + "0) Quit\n"
						  + "1) Simulate login\n"
						  + "2) Simulate logoff\n"
						  + "3) Search"
						  );
	}
	//check input
	public static int validateInput(int user_in, int upper) { //don't need parameter for lower bound, always 1
		while (user_in < 1 || user_in > upper) {
			System.out.println("Invalid input, choose from (1-" + upper + "):");
			user_in = input.nextInt();
		}
		return user_in;
	}
	
	//TRY REWRITING BY RETURNING AN INT ARRAY
	//search for specified user ID
	public static boolean search(Lab [] labs, String ID) {
		//iterate through all stations
		for (int i = 0; i < LABSIZE; i++) {
			for (int j = 0; j < labs[i].getNumberStations(); j++) {
				if (labs[i].getID(j).equals(ID)) {
					//if passed in iD is found, print out the lab and station they are using
					System.out.println("Lab #" + (i+1) + ", Station #" + (j+1)); //i+1 & j+1 for formatting purposes
					return true;
				}
			}
		}
		//if ID is not found
		System.out.println("None");
		return false;
	}
	public static boolean logOff(Lab [] labs, String ID) {
		//iterate through all stations
		for (int i = 0; i < LABSIZE; i++) {
			for (int j = 0; j < labs[i].getNumberStations(); j++) {
				if (labs[i].getID(j).equals(ID)) {
					//if passed in iD is found
					labs[i].clearID(j); //log them off
					System.out.println("User " + ID + " is logged off");
					return true;
				}
			}
		}
		//if ID is not found
		System.out.println("That user could not be found");
		return false;
	}
	public static boolean isLoggedIn(Lab [] labs, String ID) {
		//iterate through all stations
		for (int i = 0; i < LABSIZE; i++) {
			for (int j = 0; j < labs[i].getNumberStations(); j++) {
				if (labs[i].getID(j).equals(ID)) {
					//if passed in iD is found
					return true;
				}
			}
		}
		//if ID is not found
		return false;
	}
}
class Lab{
	//member variables
	private int numStations;
	private String [] iD;
	
	//constructor
	Lab(int numStations){
		this.numStations = numStations;
		iD = new String[numStations]; //creates appropriate memory for iD based on numStations
		for (int i = 0; i < numStations; i++) {
			iD[i] = "empty"; //initialize all stations in Lab to "empty"
		}
	}
	//prints status of all stations for a given Lab
	public void printStatus() {
		for (int j = 0; j < numStations; j++) {
			System.out.print((j+1) + ": " + iD[j] + " ");
		}
	}
	//set iD
	public void logIn(String ID, int cpuStation) {
		iD[cpuStation] = ID;
	}
	//logs user off by clearing iD
	public void clearID(int stationNumber) {
		iD[stationNumber] = "empty";
	}
	//getter functions
	public int getNumberStations() {
		return numStations;
	}
	public String getID(int stationNumber) {
		return iD[stationNumber];
	}
}