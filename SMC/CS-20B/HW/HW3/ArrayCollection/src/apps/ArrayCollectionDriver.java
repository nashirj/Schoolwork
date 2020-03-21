package apps;

import collections.ArrayCollection;

public class ArrayCollectionDriver {

	public static void main(String[] args) {
		//test toString
		System.out.println("--------------------------");
		System.out.println("test toString");
		System.out.println("--------------------------\n");
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
		
		//test count
		System.out.println("\n--------------------------");
		System.out.println("test count");
		System.out.println("--------------------------\n");
		for (int i = 0; i < 10; i++) {
			s.add(Integer.toString(i + 1));
			s.add("30");
		}
		System.out.println(s);
		System.out.println(s.count("30"));
		
		//test removeAll
		System.out.println("\n--------------------------");
		System.out.println("test removeAll");
		System.out.println("--------------------------\n");
		s.removeAll("30");
		System.out.println(s);
		s.removeAll("1");
		System.out.println(s);
		
		//test combine
		System.out.println("\n--------------------------");
		System.out.println("test combine");
		System.out.println("--------------------------\n");
		System.out.println("this = " + s);
		ArrayCollection<String> s1 = new ArrayCollection<String>();
		for (int i = 1000; i < 1010; i++) {
			s1.add(Integer.toString(i + 1));
		}
		System.out.println("other = " + s1);
		ArrayCollection<String> combo = s1.combine(s);
		System.out.println("combo = " + combo);
	}

}
