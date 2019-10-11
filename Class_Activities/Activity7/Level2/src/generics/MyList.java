package generics;

import java.util.LinkedList;
import generics.Appendable;

public class MyList<T> implements Appendable<MyList<T>> {
	
	LinkedList<T> list;

	public MyList() {
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public Appendable<MyList<T>> append(Appendable<MyList<T>> a) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String toString() {
		return list.toString();
	}

}
