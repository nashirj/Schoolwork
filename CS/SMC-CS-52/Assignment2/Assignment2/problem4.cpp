//
//  Nashir Janmohamed
//  CS 52
//  Assignment #2
//

/*
 PROBLEM #4
 Fibonacci numbers are a sequence of numbers where each number is represented by the sum of
 the two preceding numbers, starting with 0 and 1: 0, 1, 1, 2, 3, 5, 8, etc.
 Write a program that repeatedly prompts the user for a positive integer and prints out whether or
 not that integer is a Fibonacci number. The program terminates when -1 is entered.
 Create a method with the following signature. The method tests whether the number passed to it
 is a Fibonacci number or not. It returns true if the number is indeed a Fibonacci number and it
 returns false otherwise.
 */

#include <iostream>
#include <climits>
using namespace std;

bool isFibonacci(int number);

int main()
{
    int user_in = 0;
    bool isFib;
    
    //loop until user quits program
    while (user_in != -1)
    {
        cout << "Input: ";
        cin >> user_in;
        if (user_in != -1)
        {
            isFib = isFibonacci(user_in);
            if (isFib == true)
                cout << "Output: " << user_in << " is a Fibonacci number" << endl;
            else
                cout << "Output: " << user_in << " is not a Fibonacci number" << endl;
        }
    }
    
    cout << "Goodbye!\n";
    return 0;
}

bool isFibonacci(int number) //calculate Fibonacci up to INT_MAX
{
    //fib = 1 + 1 + 2 + 3 + 5 + 8 + 13 + 21
    int fib = 0, num1 = 1, num2 = 0;

    while (fib < INT_MAX && fib <= number)
    {
        if (number == fib)
            return true;
        fib = num1 + num2;
        num2 = num1;
        num1 = fib;
    }
    return false;
}

