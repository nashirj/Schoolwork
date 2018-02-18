//
//  Nashir Janmohamed
//  CS 52
//  Final Exam - Question 31
//

#include <iostream>
#include <string>
using namespace std;

/*
Write a program that prompts the user to enter a line of text (including whitespace). The program then replaces the following vocals with numbers: a = 1, e = 2, i = 3, o = 4, u = 5 and outputs the result to the console. The program does not consider case, so a = 1, A = 1, e = 2, E = 2, etc.
*/

string replaceLetters(string s);

int main()
{
    cout << "Input: ";
    string user_in;
    getline(cin, user_in);
    
    cout << "Output: " << replaceLetters(user_in) << endl;
    
    return 0;
}

string replaceLetters(string s)
{
    size_t len = s.length();
    for (int i = 0; i < len; i++)
    {
        switch(s[i])
        {
            case 'a':
            case 'A':
                s[i] = '1';
                break;
            case 'e':
            case 'E':
                s[i] = '2';
                break;
            case 'i':
            case 'I':
                s[i] = '3';
                break;
            case 'o':
            case 'O':
                s[i] = '4';
                break;
            case 'u':
            case 'U':
                s[i] = '5';
                break;
                //default:
                //do nothing
        }
    }
    return s;
}


