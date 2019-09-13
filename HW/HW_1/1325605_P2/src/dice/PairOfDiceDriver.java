package dice;

public class PairOfDiceDriver {

	public static void main(String[] args) {
		PairOfDice dice = new PairOfDice();
		
		System.out.println("Initial dice state: " + dice + "\n");
		
		System.out.print("Print using implicit toString(): ");
		System.out.println(dice);
		System.out.print("Print using explicit toString(): ");
		System.out.println(dice.toString() + "\n");
		
		int total = 0;
		
		for (int i = 0; i < 10; i++) {
			dice.roll();
			System.out.println("Dice state: " + dice);
			System.out.println("Dice value: " + dice.value() + "\n");
			total += dice.value();
		}
		
		System.out.println("average roll: " + total/10.0);
		
	}

}
