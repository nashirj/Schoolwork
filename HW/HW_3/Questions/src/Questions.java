
public class Questions {

	public static void main(String[] args) {
//		Integer a = new Integer(1);
//		Integer b = new Integer(1);
//		Integer c = new Integer(2);
//		Integer d = null;
//		System.out.println(a == a);
//		System.out.println(a == b);
//		System.out.println(a == c);
//		System.out.println(a == d);
//		System.out.println(a.equals(a));
//		System.out.println(a.equals(b));
//		System.out.println(a.equals(c));
//		System.out.println(a.equals(d));
		
		System.out.println(exer(7));
	}


	public static int exer(int num)
	{
	if ( num == 0)
	  return 0;
	else
	  return num + exer (num + 1);
	}
}
