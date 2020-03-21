'''
list and tuple
'''

# block comments can be made in python with 3 apostrophes (i.e. ''')

#lists and tuples are sequences of objects, can be of any type, or combination of any types

# defining a list w/ 6 elements
lst = [-7, -6, -5, -4, -3, -1]
print(lst)
# can access using indexes
print(lst[0])
# python supportss negative index numbers, -1 equals last element, -2 second to last, etc
print(lst[-2])

sumLst = sum(lst) # function that sums all elements in the list
print(sumLst)

lst.append(0) # add an element to the end of the list
print(lst)
lst.remove(-4) # remove a particular value from the list
print(lst)
lst.pop(-1) # remove a value at a particular index (the last one in this case) from the list
print(lst)

# lists can be composed of different types
lst1 = ['one', 2, 3.3]
print(lst1)

# lists are mutable, while tuples are not

lst[0] = 10
print(lst)

# tuples are declared by using parentheses instead of square brackets
tupl = ('one', 'two', 'three')
print(tupl)
# tuple[0] = 'zero'
print(len(tupl))
print(tupl[0])
print(tupl[-1])

# tuples are similar to lists, except the values of tuples are immutable
tupl1 = ('one', 2, 3.000)
print(tupl1)
# tuples are immutable, the following line would crash the program
# tuple[0] = 'zero'
print(len(tupl1))
print(tupl1[0])
print(tupl1[-1])
