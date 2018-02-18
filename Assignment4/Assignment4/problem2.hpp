////
////  problem2.hpp
////  Assignment4
////
////  Created by Nashir Janmohamed on 1/28/18.
////  Copyright © 2018 Nashir Janmohamed. All rights reserved.
////
//
//#ifndef problem2_hpp
//#define problem2_hpp
//
//#include <iostream>
//#include <string>
//using namespace std;
//
////declare class
//class Date
//{
//private:
//    int _day, _month, _year;
//    string _str_month;
//    string intToString(int month);
//public:
//    Date(int day, int month, int year);
//    void printDate1();
//    void printDate2();
//    void printDate3();
//};
//
//string Date::intToString(int month)
//{
//    string months[13] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December", "INVALID"};
//    if (month < 1 || month > 12)
//        return months[12];
//    else
//        return months[month-1];
//}
//
//Date::Date(int day, int month, int year)
//{
//    this->_day = day;
//    this->_month = month;
//    this->_year = year;
//    this->_str_month = intToString(month);
//}
//
//void Date::printDate1()
//{
//    //format 1 i.e. 12/25/2018
//    cout << _month << "/" << _day << "/" << _year;
//}
//
//void Date::printDate2()
//{
//    //format 2 i.e. December 25, 2018
//    cout << _str_month << " " << _day << ", " << _year;
//}
//
//void Date::printDate3()
//{
//    //format 3 25. December 2018
//    cout << _day << ". " << _str_month << " " << _year;
//}
//
//#endif /* problem2_hpp */
//
