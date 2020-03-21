//
//  Nashir Janmohamed
//  CS 52
//  Assignment #2
//

/*
 PROBLEM #1
 Write a program that prints out a simulated candle of the entered size. The program prompts the
 user for two positive int numbers where the first number represents the candle and the second
 number represents the wick.
 Create a function that expects two parameters: one parameter called candleSize defines the size
 of the candle, and the second parameter called wickSize defines the size of the wick. The method
 then draws a candle with wick of the specified sizes.
 */

#include <iostream>
using namespace std;

void drawCandle(int candleSize, int wickSize);

int main()
{
    int candleSize, wickSize;
    
    //prompt user for & get input
    cout << "Candle size:   ";
    cin >> candleSize;
    cout << "Wick size:     ";
    cin >> wickSize;
    
    //print candle
    cout << "Output:   ";
    drawCandle(candleSize, wickSize);
    
    return 0;
}

void drawCandle(int candleSize, int wickSize)
{
    for (int i = 0; i < candleSize; i++)
        cout << "=";
    for (int j = 0; j < wickSize; j++)
        cout << "-";
    cout << endl;
}

