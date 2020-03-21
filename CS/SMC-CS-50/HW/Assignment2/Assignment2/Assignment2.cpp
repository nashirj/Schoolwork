/*
Create a new C Console application that asks the end user to enter their scores and the code calculates the weighted total score:

Ask the user to enter 3 scores each representing an assignment score.
Ask the user for their midterm and final exam.
Store all above input into variables.
Display the total weighted score as follows where all scores entered will be out of 100:
Total Weighted Score = (average assignments)*40% + (midterm)*30% + (final exam)*30%
Use constants to represent the weight of assignments, midterm and the final.
Show the output of "Your final score is: X" where x is the final total calculated score.
Add top level comments, and other comments as needed but do not comment every line. Over use of comments is as bad as not using them.
*/

#include "stdafx.h"
#include "stdio.h"
#include "stdlib.h"

int main()
{
	int score_1, score_2, score_3, score_midterm, score_final;

	printf("Please enter your 3 assignment scores: ");
	//get input for assignment scores
	scanf_s("%d", &score_1);
	scanf_s("%d", &score_2);
	scanf_s("%d", &score_3);

	printf("Please enter your midterm and final exam scores: ");
	//get input for midterm and final score
	scanf_s("%d", &score_midterm);
	scanf_s("%d", &score_final);

	//calculate total weighted score = ((average assignments) * 40 %) + ((midterm * 30 %) + (final * 30 %))
	const float mult_assignments = .4, mult_exams = .3;

	float total_assignments, total_exams, total;

	total_assignments = (((score_1 + score_2 + score_3) / 3.0) * mult_assignments);
	total_exams = ((score_midterm + score_final) * mult_exams);
	total = total_assignments + total_exams;

	printf("Your final score is: %f\n", total);

	//leaves the output on screen for user to read until they decide to terminate the program
	printf("press CTRL + C to terminate the program\n");
	int x;
	scanf_s("%d", &x);

	return 0;
}