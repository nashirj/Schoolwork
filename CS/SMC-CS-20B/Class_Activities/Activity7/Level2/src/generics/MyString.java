package generics;

public class MyString implements Appendable<MyString> {

	String str;
	MyString otherList;
	
	public MyString(String s) {
		this.str = s;
	}

	@Override
	public Appendable<MyString> append(Appendable<MyString> a) {
		return new MyString(this.str + ((MyString) a).str);
	}
	
	public String toString() {
		return str;
	}

}
