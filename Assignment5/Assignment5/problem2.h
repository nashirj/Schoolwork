//
//  Nashir Janmohamed
//  CS 52
//  Assignment #5
//  problem2.hpp
//

/*
 Implement a program that creates pizzas based on user order. First, create class called
 Ingredient with one instance variable description of type string which is set in the constructor
 and can be get using a getter function. Create the following classes that derive from Ingredient:
 TomatoSauce, Cheese, Dough, and Pepperoni; each with a constructor that passes the
 description argument to the base constructor. Use proper access modifiers!
 */

#ifndef problem2_h
#define problem2_h

#include <iostream>
#include <string>
using namespace std;

class Ingredient {
private:
    string _description;
public:
    Ingredient(string description){
        setDescription(description);
    }
    void setDescription(string description){this->_description = description;}
    string getDescription(){return this->_description;} //thread 1 signal SIGABRT
};

class TomatoSauce : public Ingredient{
public:
    TomatoSauce(string description) : Ingredient(description){}
};


class Cheese : public Ingredient{
public:
    Cheese(string description) : Ingredient(description){}
};


class Dough : public Ingredient{
public:
    Dough(string description) : Ingredient(description){}
};


class Pepperoni : public Ingredient{
public:
    Pepperoni(string description) : Ingredient(description){}
};





/*
 Create a class Pizza which consists of a dynamically allocated array of Ingredient object pointers
 (a double pointer). The constructor expects the number of maximum ingredients as int which is
 used to dynamically allocate and initialize the array. Implement a destructor that deletes the
 Ingredient objects and the array. The class has a function void add(Ingredient* ingredient) which
 adds an ingredient to the pizza and a function to print its ingredients to the console.
 */

class Pizza{
private:
    int _ingredientCount, _MAX;
    Ingredient** ingredientPtr;
public:
    //constructor
    Pizza(int MAX){
        this->_MAX = MAX;
        this->_ingredientCount = 0;
        ingredientPtr = new Ingredient*[MAX];
    }
    
    //destructor
    ~Pizza(){
        for (int i = 0; i < _ingredientCount; i++)
            delete ingredientPtr[i];
        delete [] ingredientPtr;
    }
    
     //Adds ingredients to pizza
    void addIngredient(Ingredient *ingredient){
        ingredientPtr[_ingredientCount] = ingredient;
        _ingredientCount++;
    }
    
    //prints contents of pizza to console
    void listIngredients(){
        cout << "Pizza with:" << endl;
        for (int i = 0; i < _ingredientCount; i++){
            cout << this->ingredientPtr[i]->getDescription() << endl; //double pointer, have to dereference twice
        }
    }
};


/*
 Create an abstract class PizzaFactory with a pure virtual function called bake() that returns a
 Pizza* object pointer. Create the two subclasses CheesePizzaFactory and
 PepperoniPizzaFactory which both explicitly override the bake() function. Both functions
 should remain virtual. The CheesePizzaFactory instantiates Pizza and adds Dough,
 TomatoSauce, and Cheese to it. The PepperoniPizzaFactory creates a pizza and adds all
 ingredients including pepperoni to it.
 */

class PizzaFactory{
public:
    virtual ~PizzaFactory(){
        //need to have some definition for destructor to work
    }
    virtual Pizza* bake() = 0;
};



class CheesePizzaFactory : public PizzaFactory{
public:
    ~CheesePizzaFactory(){
        //need to have some definition for destructor to work
    }
    virtual Pizza* bake() override{
        Pizza* pizza = new Pizza(3);
        TomatoSauce* sauce = new TomatoSauce("Chunky Tomato Sauce");
        pizza->addIngredient(sauce);
        Cheese* cheese = new Cheese("Jalapeño Pepper Cheddar Cheese");
        pizza->addIngredient(cheese);
        Dough* dough = new Dough("Garlicky Dough");
        pizza->addIngredient(dough);
        //pizza->listIngredients(); //works fine when called from here, but not from main
        return pizza;
    }
};


class PepperoniPizzaFactory : public PizzaFactory{
public:
    ~PepperoniPizzaFactory(){
        //need to have some definition for destructor to work
    }
    virtual Pizza* bake() override{
        Pizza* pizza = new Pizza(4);
        TomatoSauce* sauce = new TomatoSauce("Chunky Tomato Sauce");
        pizza->addIngredient(sauce);
        Cheese* cheese = new Cheese("Jalapeño Pepper Cheddar Cheese");
        pizza->addIngredient(cheese);
        Dough* dough = new Dough("Garlicky Dough");
        pizza->addIngredient(dough);
        Pepperoni* pepperoni = new Pepperoni("Spicy Pepperoni");
        pizza->addIngredient(pepperoni);
        //pizza->listIngredients(); //works fine when called from here, but not from main
        return pizza;
    }
};


#endif /* problem2_h */


