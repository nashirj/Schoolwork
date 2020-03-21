/*
Write a program that will read in from input file one line at a time until end of file
and output the number of words in the line and the number of occurrences of each letter.
Define a word to be any string of letters that is delimited at each end by either
whitespace, a period, a comma or the beginning or end of the line. You can assume that
the input consists entirely of letters, whitespaces, commas and periods. When outputting
the number of letters that occur in a line, be sure to count upper and lowercase versions
of a letter as the same letter. Output the letters in alphabetical order and list only
those letters that do occur in the input line. For example, the input line: "I say Hi"
should produce output similar to the following:-
3 words
1 a
1 h
2 i
1 s
1 y
 */

import java.util.Scanner;
import java.io.File;

public class WordCount {
	public static void main(String [] args) throws Exception {
		//alternate method for input using command prompt
//		Scanner s = new Scanner(System.in);
//		System.out.println("Please input a sentence");
//		String user_in = s.nextLine();
		
		int [] uniqueChar = new int[26];
		int num_words = 0;
		for (int i = 0; i < 26; i++) {
			uniqueChar[i] = 0; //initialize array
		}
		
		File infile = new File("data.txt");
		Scanner input = new Scanner(infile);
		
		//get input from file
		String user_in = "";
		while(input.hasNext()) {
			user_in += input.nextLine();
		}
		
		if (user_in.length() == 0) {
			System.out.println("no input... Number of words = 0");
			System.exit(-1);
		}
		
		//tokenize input
		for (int i = 0; i < user_in.length(); i++) {
			char current_c = user_in.charAt(i);
			//if current_c is an alphabetic character
			if (current_c != ' ' && current_c != '.' && current_c != ',') {
				//determine whether current_c is the start of a word and if so increment num_words
				if (i == 0)
					num_words++;
				else {
					char prev_c = user_in.charAt(i-1);
					//if user_in[i] is an alphabetic character, and user_in[i-1] is not, increment num_words
					if (prev_c == ' ' || prev_c == '.' || prev_c == ',')
						num_words++;
				}
				//increment array index (UPPER = lower)
				if (current_c >= 'a' && current_c <= 'z') //if lowercase
					uniqueChar[current_c - 'a']++;
				else if (current_c >= 'A' && current_c <= 'Z') //if uppercase
					uniqueChar[current_c - 'A']++;
				else //if not alphabetic and not ' ' and not ',' and not '.'
					System.out.println("invalid token: \'" + current_c + "\'");
			}
			else
				continue;
		}
		
		System.out.println(num_words + " words");
		
		for (int i = 0; i < 26; i++) {
			if (uniqueChar[i] != 0) {
				System.out.println(uniqueChar[i] + " " + (char)(i+'a'));
			}
		}
		
		input.close();
		System.exit(0);
	}

}
