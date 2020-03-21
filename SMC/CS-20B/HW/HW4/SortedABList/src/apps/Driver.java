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

public class Driver
{
  public static void main(String[] args) throws IOException 
  {
    // Instantiate sorted list
    SortedABList<String> strings = new SortedABList<String>(); // sorted in alphabetical order
    
    // Set up file reading
    FileReader fin = new FileReader("input/strings.txt");
    Scanner info = new Scanner(fin);
    info.useDelimiter("[\n]");  // delimiters are newlines
    
    // Read the info from the file and add it to the list
    while (info.hasNext())      
    {
      strings.add(info.next());
    }
    
    // Display the list, using the advanced for loop
    for (String s : strings)
       System.out.println(s);
  }
} 