package apps;

import collections.ArrayCollection;

public class ArrayCollectionDriver {

	public static void main(String[] args) {
		ArrayCollection<String> s = new ArrayCollection<String>();
		for (int i = 0; i < 100; i++) {
			s.add(Integer.toString(i + 1));
		}
		System.out.println(s);
		for (int i = 0; i < 50; i++) {
			s.remove(Integer.toString(i + 1));
		}
		System.out.println(s);
		for (int i = 50; i < 100; i++) {
			s.remove(Integer.toString(i + 1));
		}
		System.out.println(s);
	}

}
