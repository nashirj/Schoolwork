//
//  question39.cpp
//
//  Nashir Janmohamed
//  CS 52
//

/*
Implement a program that finds the shortest string in a dynamically allocated array of strings. The program first asks the user for the number of names needed. Afterwards, the user is prompted to enter each name. The program then passes the array to a function. The function returns the index of the shortest element. The program then prints out the shortest element and the index where it is stored in the array.
 */

#include <iostream>
using namespace std;

int shortest(string* names, int n);

int main()
{
    int n;
    cout << "How many names are needed? ";
    cin >> n;
    cin.ignore(1000,'\n'); //ignores enter character after input of n
    
    string* names = new string[n];
    
    cout << "Please input all the names: \n";
    for (int i = 0; i < n; i++)
    {
        getline(cin, names[i]);
    }
    
    int index = shortest(names, n);
    cout << "The smallest element was at index " << index << " and it was " << names[index] << "!" << endl;
    
    delete [] names;
    return 0;
}

int shortest(string* names, int n)
{
    int tmp = 0;
    for (int i = 0; i < n; i++)
    {
        if (names[tmp].length() > names[i].length())
            tmp = i;
    }
    
    return tmp;
    
}

