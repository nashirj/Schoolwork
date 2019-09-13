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
	protected int d1;
	protected int d2;
	protected int numFaces = 6;
	
	public PairOfDice() {
		this.roll();
	}
	
	public void roll() {
		d1 = rollDie();
		d2 = rollDie();
	}
	
	private int rollDie() {
		// allows range [1, numFaces]
		return (int)(Math.random() * numFaces + 1);
	}
	
	@Override
	public String toString() {
		return (d1 + " : " + d2 + " = " + this.value());
	}
	
	public int value() {
		return d1 + d2;
	}
}
