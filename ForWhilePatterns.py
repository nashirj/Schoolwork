'''
Iteration structures are execution control structures that enable the
repetitive execution of a statement or a block of statements
For and while loops are examples of iterations structures
'''


'''
Write a “spelling” program that: 
Requests a word from the user
Prints the characters in the word from left to right, one per line
'''


'''

word = input('enter a word: ')
for c in word:
    print(c)

n = 10
for i in range(n):
    print(i)
# prints 0, 1, ..., n-1

i = 5
for j in range(i, n):
    print(j)
# prints i, i+1, ..., n-1


c = 2
for i in range(i, n, c):
    print(i)
# prints i, i + c, i + 2c, ..., n-1

'''


'''
Write for loops that will print the following sequences:
0, 1, 2, 3, 4, 5, 6, 7, 8 , 9, 10
1, 2, 3, 4, 5, 6, 7, 8, 9
0, 2, 4, 6, 8
1, 3, 5, 7, 9
20, 30, 40, 50, 60
'''

'''
for i in range(0, 11):
    print(i)

for i in range(1, 10):
    print(i)

for i in range(0, 10, 2):
    print(i)

for i in range(1, 10, 2):
    print(i)

for i in range(20, 61, 10):
    print(i)
'''




'''
for <variable> in <sequence>:
    <indented code block>
<non-indented code block>

<indented code block> is executed once for every item in <sequence>

If <sequence> is a string then the items are its characters
(each of which is a one-character string)

If <sequence> is a list then the items are the objects in the list

<non-indented code block> is executed after every item in <sequence>
has been processed

'''



'''
# explicit iteration example
for word in ['stop', 'desktop', 'post', 'top']:
    if 'top' in word:
        print(word)
print('Done.')



'''



infile = open('test.txt')
# iterates over each character in text file
content = infile.read()
for char in content:
    print(char, end='')

infile2 = open('test.txt')
lines = infile.readlines()
for line in lines:
    print(line, end='')

