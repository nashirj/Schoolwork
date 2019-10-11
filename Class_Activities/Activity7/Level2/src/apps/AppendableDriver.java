package apps;

import generics.MyString;
import generics.Appendable;
//import generics.MyList;

public class AppendableDriver {

	public static void main(String[] args) {
		MyString s = new MyString("A");
		Appendable<MyString> sNew = s.append(new MyString ("B"));
//		System.out.println(sNew);
//		Appendable sNew1 = s.append(new MyList ("B"));
	}

}
