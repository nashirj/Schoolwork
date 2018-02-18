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
    string _description;
public:
    Ingredient(string description){
        setDescription(description);
    }
    void setDescription(string description){this->_description = description;}
    string getDescription(){return _description;}
};

class TomatoSauce : public Ingredient
{
    string _description;
public:
    TomatoSauce(string description) : Ingredient(description){}
};


class Cheese : public Ingredient
{
    string _description;
public:
    Cheese(string description) : Ingredient(description){}
};


class Dough : public Ingredient
{
    string _description;
public:
    Dough(string description) : Ingredient(description)
    {
        //intentionally blank
    }
};


class Pepperoni : public Ingredient
{
    string _description;
public:
    Pepperoni(string description) : Ingredient(description){}
    string getDescription(){return _description;}
};





/*
 Create a class Pizza which consists of a dynamically allocated array of Ingredient object pointers
 (a double pointer). The constructor expects the number of maximum ingredients as int which is
 used to dynamically allocate and initialize the array. Implement a destructor that deletes the
 Ingredient objects and the array. The class has a function void add(Ingredient* ingredient) which
 adds an ingredient to the pizza and a function to print its ingredients to the console.
 */

class Pizza
{
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
        ingredientPtr[_ingredientCount] = ingredient; //something goes wrong here??
        _ingredientCount++;
    }
    
    //prints contents of pizza to console
    void listIngredients(){
        cout << "Pizza with:" << endl;
        for (int i = 0; i < _ingredientCount; i++)
        {
            cout << this->ingredientPtr[i]->getDescription() << endl;
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

class PizzaFactory
{
public:
    //PizzaFactory();
    virtual ~PizzaFactory()
    {
        //intentionally blank
    }
    virtual Pizza* bake() = 0;
};



class CheesePizzaFactory : public PizzaFactory
{
    Pizza *CheesePizzaPtr;
public:
    CheesePizzaFactory()
    {
        Pizza CheesePizza(10);
        CheesePizzaPtr = &CheesePizza;
    }
    ~CheesePizzaFactory(){
        
    }
    virtual Pizza* bake() override
    {
        //these instantiations don't work
        TomatoSauce sauce("chunky tomato glaze");
        CheesePizzaPtr->addIngredient(&sauce);
        /*TomatoSauce sauce1("chunky  glaze");
        CheesePizzaPtr->addIngredient(&sauce1);
        TomatoSauce sauce2("chunky tomato ");
        CheesePizzaPtr->addIngredient(&sauce2);
        CheesePizzaPtr->listIngredients();
        Cheese cheese("mozarella cheese");
        CheesePizzaPtr->addIngredient(&cheese);
        CheesePizzaPtr->listIngredients();
        Dough crust("Cheesy crust");
        CheesePizzaPtr->addIngredient(&crust);
        Dough dough("garlicky dough");
        CheesePizzaPtr->addIngredient(&dough);*/
        return CheesePizzaPtr;
    }
};


class PepperoniPizzaFactory : public PizzaFactory
{
    Pizza *PepperoniPizzaPtr;
public:
    PepperoniPizzaFactory()
    {
        Pizza PepperoniPizza(4);
        PepperoniPizzaPtr = &PepperoniPizza;
    }
    ~PepperoniPizzaFactory(){
        
    }
    virtual Pizza* bake() override
    {
        //these instantiations don't work
        TomatoSauce sauce("Chunky Tomato Sauce");
        PepperoniPizzaPtr->addIngredient(&sauce);
        Cheese cheese("Jalapeño Pepper Cheddar Cheese");
        PepperoniPizzaPtr->addIngredient(&cheese);
        Dough dough("Garlicky Dough");
        PepperoniPizzaPtr->addIngredient(&dough);
        Pepperoni pepperoni("Spicy Pepperoni");
        PepperoniPizzaPtr->addIngredient(&pepperoni);
        return PepperoniPizzaPtr;
    }
};


#endif /* problem2_h */


