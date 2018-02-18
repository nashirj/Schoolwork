//
//  Nashir Janmohamed
//  CS 52
//  Final Exam - Question 32
//

#include <iostream>
using namespace std;

/*
Write a program that draws a plus sign using the letter X in a size entered by a user. The size must always be an odd number. If the user enters an even number, it should be the next higher odd number.

Example 1:
Input: 3
 X
XXX
 X

Example 2:
Input: 5
  X
  X
XXXXX
  X
  X

Example 3
Input: 6
   X
   X
   X
XXXXXXX
   X
   X
   X

*/

void draw(int x);

int main()
{
    cout << "Input: ";
    int user_in;
    cin >> user_in;
    if (user_in <= 0)
    {
        cout << "Invalid input..." << endl;
        return -1;
    }
    draw(user_in);

    return 0;
}

void draw(int x)
{
    if (x%2 == 0)
        x++;

    for (int i = 0; i < x; i++)
    {
        for (int j = 0; j < x; j++)
        {
            if (i == x/2 || j == x/2)
                cout << "X";
            else
                cout << " ";
        }
        cout << endl;
    }
}

