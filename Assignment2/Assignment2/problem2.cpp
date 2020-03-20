//
//  Nashir Janmohamed
//  CS 52
//  Assignment #2
//

/*
 PROBLEM #2
 Write a program that prints a triangle of *. The program prompts the user to input a size and then
 prints out a triangle of that size. Create a function that expects the size parameter and prints out
 the triangle.
 */

#include <iostream>
using namespace std;

void drawTriangle(int size);

int main()
{
    int size;
    
    //prompt user for input
    cout << "Enter size: ";
    cin >> size;
    
    //draw triangle
    cout << "Triangle:\n";
    drawTriangle(size);
    return 0;
}

void drawTriangle(int size)
{
    for (int i = 0; i < size; i++)
    {
        for (int j = 0; j <= i; j++)
        {
            cout << "*";
        }
        cout << endl;
    }
}



