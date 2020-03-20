//
//  question36.cpp
//
//  Nashir Janmohamed
//  CS 52
//

/*
 Write a program that prompts the user for three integers, calculates the maximum and prints it out to the console.
 */

#include <iostream>
using namespace std;

int main()
{
    int max, tmp;
    
    cout << "Please enter three numbers: ";
    cin >> tmp;
    max = tmp;
    
    for (int i = 0; i < 2; i++)
    {
        cin >> tmp;
        if (tmp > max)
            max = tmp;
    }
    cout << "The biggest value you entered was " << max << endl;
    
    return 0;
}
