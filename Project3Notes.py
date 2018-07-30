'''
project 3 notes!
'''


main():
	print('in main')



# To split a string:
# 1) use the str.split method
my_string = 'A,B,C,D,E'
print (my_string)
my_list = my_string.split(",")
print (my_list)
# ['A', 'B', 'C', 'D', 'E']

# In the case of integers that are included at the string, if you want to avoid casting them to int individually you can do:
mList = [int(e) if e.isdigit() else e for e in my_string.split(',')]

# above example uses equivalent of ternary operator:
# i.e. a if condition else b
print('true' if True else 'false')
# prints true
print('true' if False else 'false')
# prints false

# i.e. x = 4 if b > 8 else 9 is read aloud as x will be 4 if b is greater than 8 otherwise 9
b = 7
x = 4 if b > 8 else 9
print(x)
#prints 9
b = 10
x = 4 if b > 8 else 9
print(x)
#prints 4

# f(x) = |x| = x if x > 0 else -x
abs_x = x if x > 0 else -x
print(abs_x)

# split notation
print('testing split notation')
y = range(50)
for i in y[::2]:
	print(i)
for i in y[::3]:
	print(i)
for i in y[10:40:6]:
	print(i)
for i in y[:25:5]:
	print(i)
# y[startAt:endBefore:skip]
'''
 +---+---+---+---+---+---+
 | P | y | t | h | o | n |
 +---+---+---+---+---+---+
 0   1   2   3   4   5   6
-6  -5  -4  -3  -2  -1
think about indices living in between set elements, i.e. y[1:1] begins after 0th element and ends before 1st element, keep in mind you can't reference 6th or -6th index

a = [i for i in range(100)]
a[start:end] # items start through end-1
a[start:]    # items start through the rest of the array
a3 = a[:end]      # items from the beginning through end-1
a[:]         # a copy of the whole array
a[start:end:step]
'''

print('printing a backwards')
a = [i for i in range(21)]
for i in a[-1::-1]: # prints list backwards starting at last element
	print(i)
# same as
for i in a[::-1]:
	print(i)

# start or end may be a negative number, which means it counts from the end of the array instead of the beginning. So:
a[-1]    # last item in the array
a[-2:]   # last two items in the array
a[:-2]   # everything except the last two items
# step can be a negative number
a[::-1]    # all items in the array, reversed
a[1::-1]   # the first two items, reversed
a[:-3:-1]  # the last two items, reversed
a[-3::-1]  # everything except the last two items, reversed


# can assign to a slice, but the value must have the same length as the slice you are replacing

a[::3]=[0,0,0,0,0,0,0]
for i in a:
	print(i)

# can delete every 3rd element like this
del a[::3]
for i in a:
	print(i)



print('testing split')
L = range(20)
for i in L:
	print(i)

iList = [i for i in L[::2]]
print('iList is: ')
print(iList)

# set-builder notation is more memory efficient for large lists
source_list = [i for i in range(0, 100)]
tuple_list = (source_list[i] for i in range(0, len(source_list), 5))
for i in tuple_list:
	print(i)


# to test if a list is empty
a = []
if not a:
  print("List is empty")
# Using the implicit booleanness of the empty list is quite pythonic.


fname = 'test.txt'
# skip first line of input
f = open(fname,'r')
lines = f.readlines()[1:]
f.close()
for line in lines:
	print(line, end='')
# or
f = open(fname).readlines()
firstLine = f.pop(0) #removes the first line
for line in f:
    print(f)

# with statement
with open('output.txt', 'w') as f:
	f.write('Hi there!')
'''
The above with statement will automatically close the file after the nested block of code.
(Continue reading to see exactly how the close occurs.) The advantage of using a with statement
is that it is guaranteed to close the file no matter how the nested block exits. If an exception
occurs before the end of the block, it will close the file before the exception is caught by an
outer exception handler. If the nested block were to contain a return statement, or a continue
or break statement, the with statement would automatically close the file in those cases, too.
'''

if __name__ == "__main__": main()
'''
The global variable, __name__, in the module that is the entry point to your program, is '__main__'. Otherwise, it's the name you import the module by.
So, code under the if block will only run if the module is the entry point to your program.
It allows the code in the module to be importable by other modules, without executing the code block beneath on import.
'''