val = 3
# in python, variables do not have a data type, only objects do
# initially, val (variable) = 3 (object of type <int>)

print(val)

val = 'abc'
# then, val (variable) = 'abc' (object of type <str>)

print(val)

# variables do not have a data type, they are just a name and can reference any object type

lst = [4, 2, 5, 1, 8]
# lst (variable) references an object of type <list> [4, 2, 5, 1, 8]

print(lst)

#can get type of an object with the type() function, e.g.
print(type(val))
print(type(lst))

val = int(4) # constructor notation
print(val) # prints 4

fval = 2.3
print(type(fval))

strval = str(fval)
print(type(strval))
print(strval)

'''
Double quotes for text
Single quotes for anything that behaves like an identifier
Double quoted raw string literals for regexps
Tripled double quotes for docstrings
'''
