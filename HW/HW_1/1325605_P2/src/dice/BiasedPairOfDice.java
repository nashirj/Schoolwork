package dice;

/**
 * (b) Now imagine that we also want to include an unfair or biased dice in our solution. This means that rolling
 * the dice doesn't have equal probabilities for each possible value (in a fair dice each value has the equal
 * probability of 1/6 to be rolled). You don't need to implement the method of rolling an unbiased roll. The
 * question is how would you reorganize your program to include this BiasedDice-Pair class? Add that new class to
 * your project and leave the rolling method empty if you don't want to implement it
 */

public class BiasedPairOfDice extends PairOfDice {
	public BiasedPairOfDice() {
		this.roll(); // initializes d1 and d2
	}
	
	@Override
	public void roll() {
		d1 = rollBiasedDie();
		d2 = rollBiasedDie();
	}
	
	private int rollBiasedDie() {
//		int ans = (int)(Math.random() * (numFaces * 2) + 1);
//		//odds of 1 are 1/4: [1,3] == 1
//		if (ans <= 3) {
//			return 1;
//		}
//		//odds of 2 are 1/4: [4, 6] == 2
//		else if (ans <= 6) {
//			return 2;
//		}
//		//odds of 3 are 1/6: [7, 8] == 3
//		else if (ans <= 8) {
//			return 3;
//		}
//		//odds of 4 are 1/6: [9, 10] == 4
//		else if (ans <= 10) {
//			return 4;
//		}
//		//odds of 5 are 1/12: [11] == 5
//		else if (ans == 11) {
//			return 3;
//		}
//		//odds of 6 are 1/12: [12] == 6
//		//only one possibility at this point
//		return 6;
		
		/**
		 * This implementation inspired by https://introcs.cs.princeton.edu/java/13flow/RollLoadedDie.java.html
		 * This approach is cleaner and more explicit about the probability than the solution I came up with above.
		 */
		double rand = Math.random();
		//rolls one through four have 1/9 probability of happening
		if (rand < 1/9.0) return 1;
		else if (rand < 2/9.0) return 2;
		else if (rand < 3/9.0) return 3;
		else if (rand < 4/9.0) return 4;
		//roll five has 2/9 probability of happening
		else if (rand < 6/9.0) return 5;
		//roll six has 1/3 probability of happening
		else return 6;
	}
}
