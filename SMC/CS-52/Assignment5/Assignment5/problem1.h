////
////  Nashir Janmohamed
////  CS 52
////  Assignment #5
////  problem1.h
////
//
///*
// Implement a program that tracks customers’ purchases. Create the following classes. Use
// appropriate access modifiers (instance variables should be private!) and data types for each.
// Don’t forget to add getter and setter functions.
// • Item: This class has the attributes (member variables) called title, description, and price.
// o Book: This class inherits from Item. It has an instance variable called pageCount.
// o Movie: This class inherits from Item. It has an instance variable called length.
// o CD: This class inherits from Item. It has an instance variable called trackCount.
// • ShoppingCart: This class keeps track of items that were bought. You may limit the
// number of items in the cart. The cart should have functions to add an item and print the
// items currently in the cart to the console.
// • Customer: The customer class stores an id, the first name and the last name and a
// pointer to a shopping cart object.
// Finally, implement a main function that creates a customer. Then add one item of each type to
// the customer’s shopping cart and list the items in the cart on the console.
// */
//
//#ifndef problem1_h
//#define problem1_h
//
//#include <iostream>
//#include <string>
//using namespace std;
//
//
//class Item
//{
//private:
//    string _title, _description;
//    double _price;
//public:
//    //constructor prototype
//    Item(string title, string description, double price){
//        setTitle(title);
//        setDescription(description);
//        setPrice(price);
//        //increment itemCount in ShoppingCart class
//    }
//
//    //getter && setter functions
//    void setDescription(string description) {this->_description = description;}
//    void setTitle(string title) {this->_title = title;}
//    void setPrice(double price) {this->_price = price;}
//    string getTitle() {return _title;};
//    string getDescription() {return _description;};
//    double getPrice() {return _price;};
//
//    //print individual items
//    void printItem(){
//        //The "item name" -- supplied by child class
//        cout << "The title is " << this->_title << ", it is " << this->_description;
//        cout << ", and it costs $" << this->_price << "." << endl;
//    }
//};
//
//
//
//
//class Book : public Item
//{
//private:
//    int _pageCount;
//public:
//    //constructor
//    Book(string title, string description, double price, int pageCount) : Item(title, description, price){
//        setPages(pageCount);
//    }
//
//    //getter && setter functions
//    void setPages(int pageCount) {this->_pageCount = pageCount;}
//    int getPages() {return _pageCount;}
//
//    //redefine Item::printItem()
//    void printItem(){
//        cout << "Book - ";
//        Item::printItem();
//        cout << "There are " << getPages() << " pages in " << getTitle() << "." << endl;
//    }
//};
//
//
//
//
//class Movie : public Item
//{
//private:
//    int _length;
//public:
//    //constructor
//    Movie(string title, string description, double price, int length) : Item(title, description, price){
//        setLength(length);
//    }
//
//    //getter && setter functions
//    void setLength(int length) {this->_length = length;}
//    int getLength() {return _length;}
//
//    //redefine Item::printItem()
//    void printItem(){
//        cout << "Movie - ";
//        Item::printItem();
//        cout << getTitle() << " is " << getLength() << " minutes long." << endl;
//    }
//};
//
//
//
//
//class CD : public Item
//{
//private:
//    int _trackCount;
//public:
//    //constructor
//    CD(string title, string description, double price, int trackCount) : Item(title, description, price){
//        setTracks(trackCount);
//    }
//
//    //getter && setter functions
//    void setTracks(int trackCount){this->_trackCount = trackCount;};
//    int getTracks(){return _trackCount;}
//
//    //redefine Item::printItem()
//    void printItem(){
//        cout << "CD - ";
//        Item::printItem();
//        cout << getTitle() << " has " << getTracks() << " tracks." << endl;
//    }
//};
//
//
//
//
////This class keeps track of items that were bought. You may limit the number of items in the cart. The cart should have functions to add an item and print the items currently in the cart to the console.
//class ShoppingCart
//{
//    int _itemCount;
//    Item* itemPtr[10];
//public:
//    ShoppingCart(){_itemCount = 0;}
//    void incrementCount(){_itemCount++;}
//
//    void addItem(Item* item){
//        itemPtr[_itemCount] = item;
//        incrementCount();
//    }
//
//    void printNumberOfItems(){
//        if (_itemCount == 1)
//            cout << "There is " << _itemCount << " item currently in the cart." << endl;
//        else
//            cout << "There are " << _itemCount << " items currently in the cart." << endl;
//    }
//
//    void printItemsInCart(){
//        for (int i = 0; i < _itemCount; i++)
//        {
//            cout << i+1 << " - ";
//            itemPtr[i]->printItem();
//        }
//    }
//
//    void printCartSubtotal()
//    {
//        double subTotal = 0;
//        for (int i = 0; i < _itemCount; i++)
//        {
//            subTotal += itemPtr[i]->getPrice();
//        }
//        cout << "The subtotal of your items is $" << subTotal << "." << endl;
//    }
//
//};
//
//
//
////The customer class stores an id, the first name and the last name and a pointer to a shopping cart object.
//class Customer
//{
//private:
//    int _ID;
//    string _firstName, _lastName;
//    ShoppingCart* _cartPtr;
//public:
//
//    //constructor
//    Customer(int ID, string firstName, string lastName)
//    {
//        setID(ID);
//        setFirstName(firstName);
//        setLastName(lastName);
//        _cartPtr = new ShoppingCart;
//        cout << "Thanks for shopping with us, " << firstName << " " << lastName << "! You are allowed a maximum of 10 items in your shopping cart." << endl;
//    }
//
//    //getter && setter functions
//    void setID(int ID){this->_ID = ID;}
//    void setFirstName(string firstName){this->_firstName = firstName;}
//    void setLastName(string lastName){this->_lastName = lastName;}
//    void setCartPtr(ShoppingCart* cartPtr){_cartPtr = cartPtr;}
//    int getID(){return this->_ID;}
//    string getFirstName(){return this->_firstName;}
//    string getLastName(){return this->_lastName;}
//    ShoppingCart* getCartPtr(){return _cartPtr;}
//};
//
//
//
//#endif /* problem1_h */
//
//
//
