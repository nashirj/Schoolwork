//
//  Nashir Janmohamed
//  CS 52
//  Assignment #5
//  problem2.cpp
//

/*
 Implement a program that creates pizzas based on user order. First, create class called
 Ingredient with one instance variable description of type string which is set in the constructor
 and can be get using a getter function. Create the following classes that derive from Ingredient:
 TomatoSauce, Cheese, Dough, and Pepperoni; each with a constructor that passes the
 description argument to the base constructor. Use proper access modifiers!
 */

#include "problem2.h"

int main()
{
    char choice;
    cout << "Would you like a pepperoni or cheese pizza (c/p)? ";
    cin >> choice;

    PizzaFactory* factory;
    if (choice == 'p')
    {
        factory = new PepperoniPizzaFactory();
    }
    else
    {
        factory = new CheesePizzaFactory();
    }
    
    Pizza* pizza = factory->bake(); //bad access??
    pizza->listIngredients();
    delete pizza;
    delete factory; //not sure what to do about destruction
    return 0;
}


