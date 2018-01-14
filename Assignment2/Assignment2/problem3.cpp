//
//  Nashir Janmohamed
//  CS 52
//  Assignment #2
//

/*
 PROBLEM #3
 Write a program that calculates the average of numbers inputted by a user. The program keeps
 prompting a user to input a number until -1 is entered. When -1 is entered the program prints out
 the sum and the average of all numbers that where entered excluding -1. Round the average to
 two fractional digits. Introduce one function that prompts the user for input and returns a whole
 number inputted by the user. The functions re-prompts the user if less than -1 is entered and only
 returns when a valid number was entered (x >= -1). Introduce a second function that prints out
 the average and sum. Call both functions from the main.
 */


#include <iostream>
#include <iomanip>
using namespace std;

double getInput();
void sumAndAverage(double sum, int n);

int main()
{
    //variables
    int n = 0;
    double total = 0, temp = 0;
    
    //stay in loop until user enters -1
    while (temp != -1)
    {
        cout << "Number:   ";
        temp = getInput();
        if (temp != -1)
        {
            total += temp;
            n++;
        }
    }
    
    sumAndAverage(total, n);
    
    return 0;
}


double getInput()
{
    double user_in;
    cin >> user_in;
    
    //loop until user enters a valid value
    while (user_in < -1)
    {
        cout << "Invalid! Re-enter: ";
        cin >> user_in;
    }
    
    return user_in;
}

void sumAndAverage(double sum, int n)
{
    cout << "Sum:      " << sum << endl;
    
    //set 2 decimal places for output of average
    cout << fixed << setprecision(2) << "Average:  " << sum/n << endl;
}


