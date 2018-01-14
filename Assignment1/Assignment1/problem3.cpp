//
// Nashir Janmohamed
// CS 52
// Assignment #1
//

/* PROBLEM SPEC
 Write a program that can be used as a calculator. Prompt the user to enter which operation he/she
 would like to perform, that is addition, subtraction, multiplication, or division. Use a switch
 statements to properly handle the operator entered by the user. Then prompt the user to enter two
 operands. An example of the program may look like this:
 */

#include <iostream>
using namespace std;

int main()
{
    char user_oper;
    double oper1, oper2, result;
    cout << "Calculator\n" << "-------------------\n" << "What operation would you like to perform?\n";
    cout << "Addition (+), Subtraction (-), Multiplication (*), or Division (/)\n";
    cout << "Enter an operator: ";
    cin >> user_oper;
    cout << "Enter operand 1: ";
    cin >> oper1;
    cout << "Enter operand 2: ";
    cin >> oper2;
    
    switch (user_oper)
    {
        case '*':
            result = oper1*oper2;
            break;
        case '/':
            result = oper1/oper2;
            break;
        case '+':
            result = oper1+oper2;
            break;
        case '-':
            result = oper1-oper2;
            break;
        default:
            cout << "You entered an invalid operator\n";
            return 0;
    }
    
    //problem spec had typo - instead of "The result is" said "The results is"
    cout << "The result is: " << oper1 << " " << user_oper << " " << oper2 << " = " << result << endl;
    return 0;
}





