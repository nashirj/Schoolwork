package countnumbers;

public class CountNumbers {
	public static int countNumbers(int[] arr) {
		int numEven = 0;
		for (int i : arr) {
			if (i % 2 == 0)
				numEven++;
		}
		
		return numEven;
	}

}
