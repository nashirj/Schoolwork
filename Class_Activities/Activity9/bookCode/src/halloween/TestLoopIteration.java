package halloween;

import java.util.ArrayList;
import java.util.Iterator;

public class TestLoopIteration {

	public static void main(String[] args) {
		ArrayList<String> strings = new ArrayList<String>();
		strings.add("alpha");
		strings.add("gamma");
		strings.add("beta");
		strings.add("delta");
		
		System.out.println(strings);
		Iterator<String> iter = strings.iterator();
		String hold;
		while (iter.hasNext()) {
			hold = iter.next();
			if (hold.equals("gamma"))
				iter.remove();
			else
				System.out.println(hold);
		}
		System.out.println(strings);
		
		ArrayList<String> strings1 = new ArrayList<String>();
		strings1.add("alpha");
		strings1.add("gamma");
		strings1.add("beta");
		strings1.add("delta");
		
		System.out.println(strings1);
//		for (int i = 0; i < strings1.size(); i++) {
//			hold = strings1.get(i);
//			if (hold.equals("gamma")) {
//				strings1.remove(i);
//				i--;
//			}
//			else
//				System.out.println(hold);
//		}
		for (String s : strings1) {
			if (s.equals("gamma")) {
				strings1.remove(s);
			}
			else
				System.out.println(s);
		}
		System.out.println(strings1);
	}

}
