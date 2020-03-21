//
//  Nashir Janmohamed
//  CS 52
//  Assignment #4
//

/*
 Create a struct called Employee. The struct should have the following members:
 • firstName: string
 • lastName: string
 • pay: int
 Create a dynamic array of n employee variables where n is a number entered by the user. Then
 loop through the array and let the user input the data for each employee. Create a function that
 expects a pointer to the array as input and prints the elements in the array. Remember that arrays
 are passed by reference, that is, any modifications inside the function will be reflected in the
 caller’s array.
 Example: Number of employees: 2
 Employee 1
 First Name: Allen
 Last Name: Harper
 Pay: 1000
 Employee 2
 First Name: John
 Last Name: Doe
 Pay: 500
 Employees:
 Name: Allen Harper (1000)
 Name: John Doe (500)
 */

#include <string>
#include <iostream>
using namespace std;

struct Employee
{
    string firstName, lastName;
    int pay;
};

void print(Employee *arr, int size);

int main()
{
    int n;
    cout << "Number of employees: ";
    cin >> n;
    Employee* roster = new Employee[n];

    for (int i = 0; i < n; i++)
    {
        cin.ignore();
        cout << "Employee " << i+1 << endl;
        cout << "First name: ";
        getline(cin, roster[i].firstName);
        cout << "Last name: ";
        getline(cin, roster[i].lastName);
        cout << "Pay: ";
        cin >> roster[i].pay;
    }
    
    print(roster, n);
    delete [] roster;
}

void print(Employee *arr, int size)
{
    cout << "Employees:" << endl;
    for (int i = 0; i < size; i++)
    {
        cout << "Name: " << arr[i].firstName << " " << arr[i].lastName << " (" << arr[i].pay << ")" << endl;
    }
}
