//
//  Nashir Janmohamed
//  CS 52
//  Assignment #3
//

/*
Write a program that dynamically allocates an array based on a size determined by the user. You
must declare the array as a pointer to get full credit! The program then uses a pointer to initialize
each element in the array with a value that is also entered by a user. Finally, sort the array and
print it to the console.
Example:
Enter a size: 5     Enter a size: 3
Item 1: 3           Item 1: 15
Item 2: 8           Item 2: 3
Item 3: 5           Item 3: 7
Item 4: 2           Sorted: 3, 7, 15
Item 5: 9
Sorted: 2, 3, 5, 8, 9
*/

#include <iostream>
#include <string>
using namespace std;

void sort(int* list, int size);

int main()
{
    int SIZE;
    cout << "Enter a size: ";
    cin >> SIZE;
    cin.ignore();

    int* items = new int[SIZE];

    for (int i = 0; i < SIZE; i++)
    {
        cout << "Item " << i+1 << ": ";
        cin >> items[i];
    }

    sort(items, SIZE);

    cout << "Sorted: ";
    for (int i = 0; i < SIZE; i++)
    {
        if (i != 0)
            cout << ", ";
        cout << items[i];
    }
    cout << endl;
}

void sort(int* list, int size)
{
    for (int i = 0; i < size; i++)
    {
        for (int k = i + 1; k < size; k++)
        {
            if (list[k] < list[i])
            {
                int tmp = list[i];
                list[i] = list[k];
                list[k] = tmp;
            }
        }
    }
}




