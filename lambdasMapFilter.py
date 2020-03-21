#lambda arguments : expression
def add(x, y): 
    return x + y
  
# Call the function
print(add(2, 3))  # Output: 5

add1 = lambda x, y : x + y 
print(add1(2, 3)) # Output: 5

'''
In lambda x, y: x + y; x and y are arguments to the function and x + y is the expression which gets executed
and its values is returned as output. lambda x, y: x + y returns a function object which can be assigned to
any variable, in this case function object is assigned to the add variable.
'''

print(type (add1)) # Output: function

'''
Mostly lambda functions are passed as parameters to a function which expects a function objects as parameter
like map, reduce, and filter functions.
'''

# 