////
////  Nashir Janmohamed
////  CS 52
////  Assignment #3
////
//
///*
// Create a 5x5 matrix of int values as shown below. Write a program that finds the minimum,
// maximum, and average value of all values in the matrix. Create a function for each value that is
// computed (max, min, avg). Print out the results (limit the average to two decimal points!).
// Matrix: [ 7, 2, 10, 3, 6],
// [ 1, 12, 2, 0, 20],
// [ 3,14,19, 5, 4],
// [ 6, 0, 17, 18, 8],
// [ 1, 13, 10, 9, 11];
// Example: Min: 0, Max: 20, Avg: 8.04
// */
//
//#include <iostream>
//#include <ctime>
//#include <iomanip>
//using namespace std;
//
//int maxVal(int arr[][5], int rows);
//int minVal(int arr[][5], int rows);
//double avgVal(int arr[][5], int rows);
//
//int main()
//{
//    //seed random values for matrix
//    srand(time(0));
//    int MAX = 1, MIN = 100; //keep values below 100
//    
//    //INITIALIZE MATRIX
//    int matrix[5][5];
//    for (int i = 0; i < 5; i++)
//    {
//        for (int j = 0; j < 5; j++)
//        {
//            //could have user input values for matrix, but wasn't sure of requirement
//            //cin >> matrix[i][j];
//            matrix[i][j] = (rand() % (MAX-MIN));
//        }
//    }
//    
//    //PRINT MATRIX
//    for (int i = 0; i < 5; i++)
//    {
//        cout << "[ ";
//        for (int j = 0; j < 5; j++)
//        {
//            cout << setw(2) << matrix[i][j];
//            if (j < 4)
//                cout <<  ", ";
//        }
//        if (i < 4)
//            cout << "]," << endl;
//        else
//            cout << "];" << endl;
//    }
//    
//    //PRINT MIN, MAX & AVG VALUES
//    cout << "Min: " << minVal(matrix, 5) << ", Max: " << maxVal(matrix, 5) << ", Avg: " << fixed << setprecision(2) << avgVal(matrix, 5) << endl;
//    
//    return 0;
//}
//
//
//int maxVal(int arr[][5], int rows)
//{
//    int max = arr[0][0];
//    for (int i = 0; i < 5; i++)
//    {
//        for (int j = 0; j < 5; j++)
//        {
//            if (arr[i][j] >= max)
//                max = arr[i][j];
//        }
//    }
//    return max;
//}
//
//
//int minVal(int arr[][5], int rows)
//{
//    int min = arr[0][0];
//    for (int i = 0; i < 5; i++)
//    {
//        for (int j = 0; j < 5; j++)
//        {
//            if (arr[i][j] <= min)
//                min = arr[i][j];
//        }
//    }
//    return min;
//}
//
//double avgVal(int arr[][5], int rows)
//{
//    //avgVal
//    double total = 0;
//    for (int i = 0; i < 5; i++)
//    {
//        for (int j = 0; j < 5; j++)
//        {
//            total += arr[i][j];
//        }
//    }
//    return total/25.0;
//}
//
//
//
//
