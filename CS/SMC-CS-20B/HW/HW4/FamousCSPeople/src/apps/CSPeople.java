package apps;
//---------------------------------------------------------------------------
// CSPeople.java            by Dale/Joyce/Weems                     Chapter 6
//
// Reads information about famous computer scientists from the file 
// input/FamousCS.txt. Allows user to indicate if they wish to see the list 
// sorted by name or by year of birth.
//---------------------------------------------------------------------------


import java.io.*;
import java.util.*;
import collections.SortedABList;
import support.FamousPerson;

public class CSPeople
{
  public static void main(String[] args) throws IOException 
  {
    // Instantiate sorted list
    SortedABList<FamousPerson> people;
    people = new SortedABList<FamousPerson>(FamousPerson.firstNameComparator());
    
    // Set up file reading
    FileReader fin = new FileReader("input/FamousCS.txt");
    Scanner info = new Scanner(fin);
    info.useDelimiter("[,\\n]");  // delimiters are commas, line feeds
    FamousPerson person;
    String fname, lname, fact;
    int year;

    // Read the info from the file and add it to the list
    while (info.hasNext())      
    {
      fname = info.next();
      lname = info.next();
      year = info.nextInt();
      fact = info.next();
      person = new FamousPerson(fname, lname, year, fact);
      people.add(person);
    }
    
    // Display the list, using the advanced for loop
    for (FamousPerson fp: people)
       System.out.println(fp);
    
    // Creating a new SortedABList with an anonymous inner class comparator defined inline.
    SortedABList<FamousPerson>people2 = new SortedABList<FamousPerson>(new Comparator<FamousPerson>() {
		@Override
		public int compare(FamousPerson o1, FamousPerson o2) {
			// Negative sign sorts in decreasing order.
			return -(o1.getFact().compareTo(o2.getFact()));
		}
    });
    
    
    // go to top of file and parse again
    fin.close();
    info.close();
    fin = new FileReader("input/FamousCS.txt");
    info = new Scanner(fin);
    info.useDelimiter("[,\\n]");  // delimiters are commas, line feeds
    
    // Read the info from the file and add it to the list
    while (info.hasNext())      
    {
      fname = info.next();
      lname = info.next();
      year = info.nextInt();
      fact = info.next();
      person = new FamousPerson(fname, lname, year, fact);
      people2.add(person);
    }
    
    System.out.println("-----------------------------");
    for (FamousPerson fp: people2)
        System.out.println(fp);
  }
} 