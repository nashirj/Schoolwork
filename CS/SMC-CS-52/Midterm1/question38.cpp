////
////  question38.cpp
////
////  Nashir Janmohamed
////  CS 52
////
//
///*
// Implement a program that calculates N! (N-factorial) according to the following instructions:
//
//Hint: Factorial: N! = N * (N-1) * (N-2) * …. * 1
//
//Examples:
//7! = 7 * 6 * 5 * 4 * 3 * 2 * 1 = 5040
//6! = 6 * 5 * 4 * 3 * 2 * 1 = 720
//4! = 4 * 3 * 2 * 1 = 24
//*/
//
//#include <iostream>
//using namespace std;
//
//long long factorial(int n);
//
//int main()
//{
//    int n;
//    cout << "Please input a number: ";
//    cin >> n;
//    cout << n << "! = ";
//    for (int i = n; i >= 1; i--)
//    {
//        cout << i;
//        if (i != 1)
//            cout << " * ";
//    }
//    cout << " = " << factorial(n) << endl;
//    return 0;
//}
//
//long long factorial(int n)
//{
//    if (n > 1)
//        n *= factorial(n-1);
//    //else if (n == 1)
//    return n;
//}
//
