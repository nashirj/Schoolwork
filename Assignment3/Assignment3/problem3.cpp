//
//  Nashir Janmohamed
//  CS 52
//  Assignment #3
//

/*
 Write a program that prompts the user for a string (the string may consist of multiple words).
 Implement a function that finds and returns the first non-repeated char in the string. The program
 calls the function and prints out the returned char.
 */

#include <iostream>
#include <string>
using namespace std;

char repeat(string str);

int main()
{
    string user_in;
    cout << "Please enter a string: ";
    getline(cin, user_in);
    
    char unique_char = repeat(user_in);
    
    if (unique_char == '\0')
    {
        cout << "There were no repeated characters..." << endl;
        return -1;
    }
    
    cout << "The first non-repeated char in the string is '" << unique_char << "'!" << endl;
    return 0;
}

char repeat(string str)
{
    int len = str.length();
    bool repeated[len];
    for (int i = 0; i < len; i++)
    {
        for (int j = i+1; j < len; j++)
        {
            if (str[i] == str[j])
            {
                repeated[i] = true;
                repeated[j] = true;
            }
        }
    }
    
    for (int k = 0; k < len; k++)
    {
        if (repeated[k] == false && str[k] != ' ') //not sure if we should count space as a repeatable character?
            return str[k];
    }
    
    return '\0';
}

