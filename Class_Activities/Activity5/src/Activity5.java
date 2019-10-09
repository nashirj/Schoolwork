
public class Activity5 {

	public static void incrementIntegerByOne(Integer c){
		c = c + 1;
	}
	
	public static void swap(Integer a, Integer b){
		Integer temp = a;
		a = b;
		b = temp;
	}
	
	public static void main ( String [] args ){
//		Integer b = new Integer(3);
//		incrementIntegerByOne(b);
//		System.out.println(b);
		Integer a = 1;
		Integer b = 2;
		swap(a, b);
		System.out.println(a + " and " + b);
	}
}