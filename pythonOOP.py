'''
self & this have the same purpose except that self must be received explicitly.

Python is a dynamic language. So you can add members to your class. Using self explicitly let you define if you work
in the local scope, instance scope or class scope.

As in C++, you can pass the instance explicitly. In the following code, #1 and #2 are actually the same. So you can
use methods as normal functions with no ambiguity.

Note that self is not a keyword, you can call it as you wish, unlike C++'s this which is a keyword
'''
class Foo :
    def call(self) :
        print('hi')

foo = Foo()
foo.call() #1
Foo.call(foo) #2



'''
__str()__ is very similar to the toString() method in Java for an object. If you override the __str__ method inside
a class definition in Python, you get the see the friendly name of the object.
'''

class Person:
    pass
 
p = Person()
print(p)
# prints "<__main__.Person instance at 0x7faffb3ac5f0>"

class Person2:
    def __str__(self):
        return 'Person class'
 
p = Person2()
 
print(p)
# prints "Person class"

'''
Initially, the Person class had nothing implemented. Creating an object from the class Person and printing
will just show a Person instance at some memory reference.

By redefining the class and overriding the __str__ method, print() will display the string returned from __str__
'''


'''
str() is used for creating output for end user while repr() is mainly used for debugging and development. repr’s goal
is to be unambiguous and str’s is to be readable. 
'''

import datetime
today = datetime.datetime.now()
 
# Prints readable format for date-time object
print(str(today))
 
# prints the official format of date-time object
print(repr(today))