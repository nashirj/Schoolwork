//
//  Nashir Janmohamed
//  CS 52
//  Assignment #3
//

/*
 Write a program that counts the number of upper case letters, lower case letters, digits, spaces,
 and any other chars in a file. The program prompts the user to enter a file name (including file
 path). The program then opens the file and counts each of the before mentioned categories, then
 prints the output.
 */

#include <iostream>
#include <fstream>
#include <cctype>
using namespace std;

int main()
{
    //file for testing - /Users/nashish/testing.txt

    int upper = 0, lower = 0, digits = 0, spaces = 0, other = 0;
    
    string line;
    ifstream inputFile;
    
    cout << "Please input a file path: ";
    string filename;
    getline(cin, filename);
    
    inputFile.open(filename);
    //can be used to test if opening file failed:
    if (inputFile.fail())
    {
        cout << "Failed to open " << filename << endl;
        return -1;
    }
    // OR
    if (inputFile)
    {
        while (inputFile >> line)
        {
            // process line
            size_t count = 0, len = line.length();
            while (count < len)
            {
                if (islower(line[count]))
                    lower++;
                else if (isupper(line[count]))
                    upper++;
                else if (isdigit(line[count]))
                    digits++;
                else if (line[count] == ' ') //this doesn't work... not sure why but need to fix
                    spaces++;
                else
                    other++;
                count++;
            }
        }
        inputFile.close();
    }
    
    cout << "File contains\n" << "Lowercase letters: " << lower << endl << "Uppercase letters: " << upper << endl << "Digits: " << digits << endl << "Spaces: " << spaces << endl << "Other: " << other << endl;
    
    return 0;
}
