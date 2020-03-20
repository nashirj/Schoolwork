//
//  question33.cpp
//  FinalExam
//
//  Created by Nashir Janmohamed on 2/8/18.
//  Copyright © 2018 Nashir Janmohamed. All rights reserved.
//

#include <iostream>
#include <string>
using namespace std;

/*
 Create a class named Shape with one public pure virtual function area() that returns a double value. Create the two classes Square and Rectangle that both publicly inherit from Shape. Both classes should have appropriate instance member variable(s) which are set in the constructor. Both classes should override the area() function of their base class and use the instance variables in their area computation. Use appropriate access modifiers in each class to enforce information hiding.
 */

class Shape
{
public:
    Shape(){}
    virtual double area() = 0;
};

class Square : public Shape
{
private:
    double m_side;
public:
    Square(double side)
    {
        this->m_side = side;
    }
    double area() override
    {
        return m_side * m_side;
    }
    double getSideLength(){return this->m_side;}
    void setSideLength(double side){this->m_side = side;}
};

class Rectangle : public Shape
{
private:
    double m_length, m_width;
public:
    Rectangle(double length, double width)
    {
        this->m_length = length;
        this->m_width = width;
    }
    double area() override
    {
        return m_length * m_width;
        //not sure if this is appropriate or overkill
    }
    double getLength(){return this->m_length;}
    void setLength(double length){this->m_length = length;}
    double getWidth(){return this->m_width;}
    void setWidth(double width){this->m_width = width;}
};

int main()
{
    Square s(10.5);
    Rectangle r(50.4, 5.13);
    cout << "r's area (" << r.getLength() << " * " << r.getWidth() << ") is " << r.area() << " and s's area (" << s.getSideLength() << " * " << s.getSideLength() << ") is " << s.area() << "!" << endl;
    return 0;
}
