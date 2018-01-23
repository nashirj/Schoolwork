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
    int a, b, c;
    
    cout << "Please enter three numbers: ";
    cin >> a;
    cin >> b;
    cin >> c;
    
    cout << "The biggest value you entered was: ";
    if (a > b && a > c)
        cout << a << endl;
    else if (b > a && b > c)
        cout << b << endl;
    else
        cout << c << endl;
    
    return 0;
}
