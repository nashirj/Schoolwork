package apps;

import mypair.ArrayPair;
import mypair.PairInterface;

public class ArrayPairDriver {
	public static void main(String[] args) {
		PairInterface<String> myPair = new ArrayPair<String>("apple", "peach");
		System.out.print(myPair.getFirst() + " ");
		myPair.setSecond("orange");
		System.out.println(myPair.getSecond());
	}
}
