////
////  Nashir Janmohamed
////  CS 52
////  Assignment #4
////
//
///*
// Implement a program that lets the user enter a number and then prints the result calculated by the
// following function. Write a recursive function that n * n/3 * n/9 * ... where n/x > 0 and n is a
// nonnegative integer. For example:
// 27: 27 * 9 * 3 * 1 = 729
// 8: 8 * 2 = 16
// 100: 100 * 33 * 11 * 3 * 1 = 108900
// The function prototype should be: int recursive(unsigned int n);
// */
//
//int recursive(unsigned int n);
//
//#include <iostream>
//using namespace std;
//
//int main()
//{
//    int user_signed;
//    unsigned int user_in;
//    
//    cout << "Input: ";
//    cin >> user_signed;
//    //check input
//    if (user_signed < 0)
//    {
//        cout << "please input a positive integer..." << endl;
//        return -1;
//    }
//    else
//        user_in = user_signed;
//    
//    int answer = recursive(user_in);
//    cout << "Result: " << answer << endl;
//    
//    return 0;
//}
//
//int recursive(unsigned int n)
//{
//    //calculate n * n/3 * n/9 * ... where n/x > 0 and n is a nonnegative integer
//    
//    if (n/3 > 0)
//        n *= recursive(n/3);
//    else if (n == 0) //base case
//        return 1;
//    return n;
//}
//
//
