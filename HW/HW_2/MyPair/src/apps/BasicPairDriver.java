package apps;

import mypair.BasicPair;
import mypair.PairInterface;

public class BasicPairDriver {
	public static void main(String[] args) {
		PairInterface<String> myPair = new BasicPair<String>("apple", "peach");
		System.out.print(myPair.getFirst() + " ");
		myPair.setSecond("orange");
		System.out.println(myPair.getSecond());
	}
}
