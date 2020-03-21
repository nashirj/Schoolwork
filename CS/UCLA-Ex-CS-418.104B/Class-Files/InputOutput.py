'''
name = input('please enter your name: ')
print(name)

print('please enter your name')
name = input()
print('hello, ' + name)

list1 = eval(input('please enter a sequence of comma separated numbers: '))

print(list1)
print('the sum of list1 is ' + str(sum(list1)))
'''

'''
Requests the user’s name
Requests the user’s age
Computes the user’s age one year from now and prints the message shown
'''
name = input('Hello! What''s your name? ')
age = int(input('Nice to meet you ' + name + '... how old are you? '))
print('In one year, you will be ' + str(age + 1) + ' years old! Congratulations ' + name + '!')


# ASK ABOUT OPERATIONS ON LIST I.E. SHALLOW VS DEEPCOPY AND IMPORTING
# eval() Takes a string as input and evaluates it as a Python expression
