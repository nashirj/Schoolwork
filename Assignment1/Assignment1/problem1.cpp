//
// Nashir Janmohamed
// CS 52
// Assignment #1
//

/*
 Find and fix the error(s) in the following program.
 using namespace std;
 int MAIN()
 cout << “Hello << World;
 int name;
 cout << “Type your name:”;
 cin << name;
 cout >> “Hello, “ << << name;
 }
 */

#include <iostream>
#include <string> //the program compiles without this - why is that?
using namespace std;

int main()
{
    cout << "Hello World" << endl;
    string name;
    cout << "Type your name: ";
    getline(cin, name);
    cout << "Hello, " << name << endl;
    return 0;
}

