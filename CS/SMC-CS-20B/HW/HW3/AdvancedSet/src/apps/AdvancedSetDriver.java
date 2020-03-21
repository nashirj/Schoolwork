package apps;

import collections.AdvancedSet;

public class AdvancedSetDriver {

	public static void main(String[] args) {
		AdvancedSet<String> as = new AdvancedSet<String>();
		as.add("hi");
		System.out.println(as);
		as.add("there");
		System.out.println(as);
		as.add("hi");
		System.out.println(as);
		as.remove("there");
		System.out.println(as);
		as.add("there");
		System.out.println(as);
		
		AdvancedSet<String> as1 = new AdvancedSet<String>(10);
		as1.add("hello");
		as1.add("there");
		System.out.println(as1);
		
		AdvancedSet<String> union = (AdvancedSet<String>) as.union(as1);
		System.out.println(union);
		AdvancedSet<String> intersection = (AdvancedSet<String>) as.intersection(as1);
		System.out.println(intersection);
		AdvancedSet<String> difference = (AdvancedSet<String>) as.difference(as1);
		System.out.println(difference);
		
		AdvancedSet<String> a = new AdvancedSet<String>(100000000);
		AdvancedSet<String> a1 = new AdvancedSet<String>(100000000);
		for (int i = 0; i < 10000; i++) {
			a.add("hi" + i);
			a1.add("bye" + i);
		}
		difference = (AdvancedSet<String>) a.difference(a1);
		a = new AdvancedSet<String>(100000000);
		a1 = new AdvancedSet<String>(100000000);
		for (int i = 0; i < 10000; i++) {
			a.add("hi" + (10000-i-1));
			a1.add("hi" + i);
		}
		difference = (AdvancedSet<String>) a.difference(a1);
	}

}
