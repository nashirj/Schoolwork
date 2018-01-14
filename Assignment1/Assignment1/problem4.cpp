//
// Nashir Janmohamed
// CS 52
// Assignment #1
//

/* PROBLEM SPEC
 Write a program that determines the season based on the month. The program prompts a user to
 enter a month (1-12) and then prints if that month is in spring, summer fall or winter. The
 program must also check if a valid month was entered. For simplicity, assume: 1-3: spring, 4-6:
 summer, 7-9 fall, 10-12 winter.
 */

#include <iostream>
using namespace std;

int main()
{
    int month;
    cout << "Enter a month (1-12): ";
    cin >> month;
    if (month < 0)
        cout << "That is not a valid month!\n";
    else if (month > 12)
        cout << "That month must be in the future.\n";
    else
    {
        cout << "The " << month << ". month is in ";
        if (month >= 1 && month <= 3)
            cout << "spring";
        else if (month >= 4 && month <= 6)
            cout << "summer";
        else if (month >= 7 && month <= 9)
            cout << "fall";
        else if (month >= 10 && month <= 12)
            cout << "winter";
        cout << "!\n";
    }
    return 0;
}



