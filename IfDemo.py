import random

knownUsers = ['sue', 'joe', 'hani', 'sophie']
user = input('Enter username: ')

if user in knownUsers:
    print('welcome, ' + user)
else:
    print('invalid username')
    exit()
    # exit() function will quit the program



rn = random.randint(50, 100)
print(rn)


# very cool that python allows you to compare in a range instead of using and
if 90 <= rn <= 100:
    grade = 'A'
elif 80 <= rn:
    grade = 'B'
elif 70 <= rn:
    grade = 'C'
elif 60 <= rn:
    grade = 'D'
else:
    grade = 'F'
    
print(user + "'s grade is " + grade)
# we use " here to enclose the string so that python doesn't get confused
# when we use ' for an apostrophe
