//
// Nashir Janmohamed
// CS 52
// Assignment #1
//

/* PROBLEM SPEC
 There are three tickets for a concert. The VIP tickets cost $120, premium tickets cost $80, and
 regular tickets cost $40. Prompt the user how many tickets of each category he would like. Then
 print an invoice with overview of the order and total price. Include a sales tax of 9.25%.
 */

#include <iostream>
#include <iomanip>
using namespace std;

int main()
{
    //sets 2 decimal places for float values (i.e. dollar amounts)
    cout << fixed;
    cout << setprecision(2);
    
    int VIP_tickets, pre_tickets, reg_tickets;
    
    //prompt user for input
    cout << "How many tickets would you like to order?\n";
    cout << "VIP Tickets ($120): ";
    cin >> VIP_tickets;
    cout << "Premium Tickets ($80): ";
    cin >> pre_tickets;
    cout << "Regular Tickets ($40): ";
    cin >> reg_tickets;
    cout << endl; // separate input from invoice
    
    //do operations
    
    double total_VIP = VIP_tickets * 120, total_pre = pre_tickets * 80, total_reg = reg_tickets * 40;
    double total = (total_reg + total_pre + total_VIP);
    double tax = total * .0925;
    total += tax;
    
    //output invoice for user
    cout << "Invoice:\n";
    cout << "VIP:       $120 x " << VIP_tickets << " = $" << setw(6) << total_VIP << endl;
    cout << "Premium:   $ 80 x " << pre_tickets << " = $" << setw(6) << total_pre << endl;
    cout << "Regular:   $ 40 x " << reg_tickets << " = $" << setw(6) << total_reg << endl;
    cout << "Sales Tax:    9.25% = $" << setw(6) << tax << endl;
    cout << "-----------------------------" << endl;
    cout << "Total Price:          $" << setw(6) << total << endl;
    return 0;
}




