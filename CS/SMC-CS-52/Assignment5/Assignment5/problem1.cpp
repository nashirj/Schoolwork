////
////  Nashir Janmohamed
////  CS 52
////  Assignment #5
////  problem1.cpp
////
//
///*
// Implement a program that tracks customers’ purchases. Create the following classes. Use appropriate access modifiers (instance variables should be private!) and data types for each.
// Don’t forget to add getter and setter functions.
// • Item: This class has the attributes (member variables) called title, description, and price.
// o Book: This class inherits from Item. It has an instance variable called pageCount.
// o Movie: This class inherits from Item. It has an instance variable called length.
// o CD: This class inherits from Item. It has an instance variable called trackCount.
// • ShoppingCart: This class keeps track of items that were bought. You may limit the number of items in the cart. The cart should have functions to add an item and print the items currently in the cart to the console.
// • Customer: The customer class stores an id, the first name and the last name and a pointer to a shopping cart object.
// Finally, implement a main function that creates a customer. Then add one item of each type to the customer’s shopping cart and list the items in the cart on the console.
// */
//
//#include "problem1.h"
//
///*
//Finally, implement a main function that creates a customer. Then add one item of each type to
//the customer’s shopping cart and list the items in the cart on the console.
// */
//
//int main()
//{
//
//
//    //create customer
//    Customer user(1325605, "Nashir", "Janmohamed");
//
//    //create generic Item
//    Item videoGame("Halo 3", "a FPS set in the future", 29.99);
//    user.getCartPtr()->addItem(&videoGame);
//
//    //create Movie
//    Movie movie("Interstellar", "a thought-provoking movie about space travel", 15.00, 169);
//    user.getCartPtr()->addItem(&movie);
//
//    //create Book
//    Book book("The Perks of Being a Wallflower", "a coming of age story told through a series of diary entries", 7.89, 224);
//    user.getCartPtr()->addItem(&book);
//
//    //create CD
//    CD cd("Mockroot", "a musical work by pianist Tigran Hamasyan that blends jazz, Armenian folk music, and Western classical tradition", 13.45, 12);
//    user.getCartPtr()->addItem(&cd);
//
//    user.getCartPtr()->printNumberOfItems();
//    user.getCartPtr()->printItemsInCart();
//    user.getCartPtr()->printCartSubtotal();
//
//    return 0;
//}
//
//
//
