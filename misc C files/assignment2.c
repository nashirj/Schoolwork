// Assignment2.cpp : Defines the entry point for the console application.
//

#include "stdio.h"
#include "stdlib.h"

/*
Create a new C Console application that asks the end user enters their scores and the code calculates the weighted total score:

Ask the user to enter 3 scores each representing an assignment score.
Ask the user for their midterm and final exam.
Store all above input into variables.
Display the total weighted score as follows where all scores entered will be out of 100:
Total Weighted Score = (average assignments)*40% + (midterm)*30% + (final exam)*30%
Use constants to represent the weigh of assignments, midterm and the final.
Show the output of "Your final score is: X" where x is the final total calculated score.
Add top level comments, and other comments as needed but do not comment every line. Over use of comments is as bad as not using them.
*/

int main()
{
	int score_1, score_2, score_3, score_midterm, score_final;

	printf("Please enter your 3 assignment scores: ");
	//get input for assignment scores
	scanf("%i", &score_1);
	scanf("%i", &score_2);
	scanf("%i", &score_3);
	//value check
	printf("%i, %i, %i\n", score_1, score_2, score_3);

	//get input for midterm score
	printf("Please enter your midterm score: ");
	scanf("%i", &score_midterm);	
	
	printf("Please enter your final score: ");
	//get input for midterm score
	scanf("%i", &score_final);
	printf("%i, %i\n", score_midterm, score_final);
	//value check

	float total_assignments, total_exams, total;

	//Total Weighted Score = (average assignments) * 40 % +(midterm) * 30 % +(final exam) * 30 %
	const float mult_assignments = .4, mult_exams = .3;

	total_assignments = (((score_1 + score_2 + score_3) / 3.0) * mult_assignments);
	total_exams = ((score_midterm + score_final) * mult_exams);

	total = total_assignments + total_exams;

	int to_return = total;

	printf("%i\n", to_return);

	return 0;
}
