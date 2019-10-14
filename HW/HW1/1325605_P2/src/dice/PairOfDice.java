package dice;

/**
 * Create a class called PairOfDice in Java. Objects of this class represent a single pair of six-sided dice.
 * The only attributes of such an object are the face values of the pair of dice. Provide a constructor. Provide
 * a roll method that simulates rolling the dice (you need to use a random number generator). Provide a value
 * method that returns the sum of the current face values of the dice. Provide a toString method that returns a
 * nicely formatted string representing the pair of dice, for example "5 : 3 = 8". Finally, create a "test driver"
 * class containing the main method that demonstrates that your PairOfDice class performs correctly.
 * @author Nashir Janmohamed
 */

public class PairOfDice {
	// face value of each of the two dice
	protected int d1;
	protected int d2;
	// num of faces of dice, can be modified in subclasses for twenty sided die, etc...
	protected int numFaces = 6;
	
	/**
	 * The default constructor initializes two superclass members d1 and d2 to integer values.
	 */
	public PairOfDice() {
		this.roll();
	}
	
	/**
	 * Roll a dice with 1/6 probability for any given side to be chosen.
	 */
	public void roll() {
		d1 = rollDie();
		d2 = rollDie();
	}
	
	/**
	 * Simulate a dice roll.
	 * @return an int in the range of [1, numFaces]
	 */
	private int rollDie() {
		return (int)(Math.random() * numFaces + 1);
	}
	
	/**
	 * Nice formatting of string showing current value of dice.
	 */
	@Override
	public String toString() {
		return (d1 + " : " + d2 + " = " + this.value());
	}
	
	/**
	 * Value of the sum of the two dice.
	 * @return
	 */
	public int value() {
		return d1 + d2;
	}
}
