/********************************************************************************
* 1. Write code for a function that receives two parameters (a,and b) by       *
* value and has two more parameters (c and d) by reference. All parameters     *
* are double.                                                                  *
* The function works by assigning c to (a/b) and assigning d to (a*b).         *
* From main, use scanf to get two numbers, then call the function, and then    *
* display both returned values to the output in a printf statement.            *
* 2. After part 1 is completed, write code to get 20 integer numbers from      *
* the user. The code then displays how many of those numbers are above the     *
* numbers average. To get proper credit you must follow these steps:           *
*   a. write a for loop to fill the array with numbers from the user. Use      *
*      a pointer                                                               *
*   b. use an index to pass through all array elements to calculate the        *
*      average in another loop.                                                *
*   c. write a function, then pass the array, its size, and the average to     *
*      the function. The function returns the count of the number of elements  *
*      that are above the average.                                             *
********************************************************************************/

#include <stdio.h>

void func1(double a, double b, double *c, double *d);

int aboveAverage(int num[], int size, int average);

int main()
{
	//PART 1
	double num1, num2, *ref1, *ref2;
	ref1 = &num1;
	ref2 = &num2;
	printf("Please input 2 values:\n");
	scanf("%lf %lf", &num1, &num2);
	func1(num1, num2, ref1, ref2);
	printf("The quotient of the two numbers is %.2lf and the product is %.2lf\n", num1, num2);

	//PART 2
	int arr[20], arr_size = 20, num_above_average;
	int *arr_ptr;
	double arr_total = 0, arr_average;

	arr_ptr = &arr[0];
	//pointer to arr[0] is the same as a pointer to arr but compiler was giving an error

	//initialize array values
	printf("Please input 20 integers:\n");

	for (int i = 0; i < arr_size; i++)
	{
		scanf("%d", arr_ptr);
		arr_ptr++;
	}

	for (int j = 0; j < arr_size; j++)
		arr_total += arr[j];

	arr_average = arr_total / 20.0;

	num_above_average = aboveAverage(arr, arr_size, arr_average); //function call

	printf("There are %d array elements that are above average.\n", num_above_average);

	return 0;
}

void func1(double a, double b, double *c, double *d)
{
	*c = a / b;
	*d = a*b;
}

int aboveAverage(int num[], int size, int average)
{
	int count = 0;
	for (int i = 0; i < size; i++) //traverses array and compare elements to average
	{
		if (num[i] > average)
			count++;
	}

	return count;
}
