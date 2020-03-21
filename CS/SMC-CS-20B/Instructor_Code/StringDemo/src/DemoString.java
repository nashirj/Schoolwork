import java.io.IOException;

public class DemoString
{ 
	public static void main(String args[]) throws IOException 
	{ 
		final int ITERATION = 100; 

		String s = ""; // String Concatenation using + operator 
		long startTime = System.nanoTime(); 
		for (int i = 0; i < ITERATION; i++) 
		{ 
			s = s + Integer.toString(i); 
		} 
		long duration = (System.nanoTime() - startTime) / 1000; 
		System.out.println("Time taken to concatenate " + ITERATION + " Strings using + operator (in micro) : " + duration); 

		// Using String concat() method
		startTime = System.nanoTime();
		for (int i = 0; i < ITERATION; i++)
		{
			s.concat(Integer.toString(i));
		} 
		duration = (System.nanoTime() - startTime) / 1000; 
		System.out.println("Time taken to concatenate " + ITERATION + " Strings using concat method (in micro) : " + duration); 
		
		// StringBuffer example to concate String in Java
		StringBuffer buffer = new StringBuffer(); // default size 16 
		startTime = System.nanoTime(); 
		for (int i = 0; i < ITERATION; i++) 
		{ 
			buffer.append(i); 
		} 
		duration = (System.nanoTime() - startTime) / 1000; 
		System.out.println("Time taken to concatenate " + ITERATION + " Strings using StringBuffer (in micro) : " + duration); 
		
		// StringBuilder example to concate two String in Java 
		StringBuilder builder = new StringBuilder(); //default size for worst case 
		startTime = System.nanoTime(); 
		for (int i = 0; i < ITERATION; i++) 
		{ 
			builder.append(i); 
		} 
		duration = (System.nanoTime() - startTime) / 1000; 
		System.out.println("Time taken to concatenate " + ITERATION + " Strings using StringBuilder append in micro) : " + duration); 
		} 
}

