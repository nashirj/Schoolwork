// 
//  Assignment3.cpp : Defines the entry point for the console application.
//
//  Created by Nashir Janmohamed on 10/10/17.
//

#include "stdafx.h"

/*
Write C code to repeatedly ask the user for a number, then once the user enters 0, the code
displays the min, max and average of all values entered. To get proper credit, name the variables
as listed below and follow the directions carefully. Do not use any break or similar type of
statements. To implement the above code, you will need to count the entries - name the num_count
variable num_count. You will also need to use a variable, name it min_in so each time the user gives
input, and the input is not 0, then compare min_in with the input, if the min_in is > input, then
assign min_in to the input. Similarly name another variable max_in, and compare it to the input, but
assign max_in to the input only if max_in is < input. To calculate the average, accumulate each input
into a variable, total. Then after the loop the average is the total divided by the number of entries.
Once the loop is over, display the calculated values (min, max and the average) with a proper wording
in three lines. The input is not restricted to integer value so declare the variables above with a
proper type. Show the output using two decimal places, and align the three output values as in this
sample output:

The minimum entry was:          2.30
The maximum entry was:          62.51
The average of all entries was: 52.81
*/

#include <stdio.h>

int main() {
	//declare variables
	double temp_in, average, min_in = 0, max_in = 0, total = 0;
	int num_count = 0;

	//1st iteration to initialize min_in and max_in
	printf("Input a number: ");
	scanf_s("%lf", &temp_in);
	if (temp_in == 0)
	{
		//print values in the case that 1st input is 0
		printf("The minimum entry was:          0.00\n");
		printf("The maximum entry was:          0.00\n");
		printf("The average of all entries was: 0.00\n");
		return 0;
	}
	else //if (temp_in != 0)
	{
		//initialize values
		min_in = temp_in;
		max_in = temp_in;
		total = temp_in;

		//2nd-nth iteration
		do
		{
			//num_count++ is at the beginning so that loop iteration containing exit code is not
			//included in calculation of average
			num_count++;

			printf("Input a number: ");
			scanf_s("%lf", &temp_in);
			if (min_in > temp_in && temp_in != 0)
				min_in = temp_in;
			else if (max_in < temp_in)
				max_in = temp_in;
			total += temp_in; //don't need to worry about last iteration changing value -> x + 0 = x
		} while (temp_in != 0);
	}

	//calculate average
	average = total / num_count;

	//print final values
	printf("The minimum entry was:          %.2lf\n", min_in);
	printf("The maximum entry was:          %.2lf\n", max_in);
	printf("The average of all entries was: %.2lf\n", average);

	//hang program so that user can see values
	printf("press CTRL + C to terminate the program\n");
	int dummy;
	scanf_s("%d", &dummy);

	return 0;
}