package dice;

public class BiasedPairOfDiceDriver {
	/**
	 * Driver code to demonstrate functionality of BiasedPairofDice class.
	 * @param args
	 */
	public static void main(String[] args) {
		PairOfDice dice = new BiasedPairOfDice();
		
		// test value()
		System.out.println("Initial dice state: " + dice + "\n");
		
		// test toString()
		System.out.print("Print using implicit toString(): ");
		System.out.println(dice);
		System.out.print("Print using explicit toString(): ");
		System.out.println(dice.toString() + "\n");
		
		int total = 0;
		
		// test distribution of scores
		for (int i = 0; i < 10; i++) {
			dice.roll();
			System.out.println("Dice state: " + dice);
			System.out.println("Dice value: " + dice.value() + "\n");
			total += dice.value();
		}
		
		System.out.println("average roll: " + total/10.0);
	}

}
