def getAverage(lst):
    return "The average of all values in the list is " + str(sum(lst)/(len(lst)))

def getLargest(lst):
    return "The max value in the list is " + str(max(lst))

def getSmallest(lst):
    return "The min value in the list is " + str(min(lst))

def isOrdered(lst):
    # 1) check ascending
    if (isAscending(lst)):
        return('The list is in ascending order')

    # 2) check descending    
    elif (isDescending(lst)):
        return('The list is in descending order')

    # 3) if neither above cases are true, the list must be out of order
    else:
        return('The list is out of order')

def isAscending(lst):
    temp = lst[0]
    for i in lst:
        if i >= temp:
            temp = i
        else:
            return False
    # if loop didn't break before iterating through all elements
    return True

def isDescending(lst):
    temp = lst[0]
    for i in lst:
        if i <= temp:
            temp = i
        else:
            return False
    # if loop didn't break before iterating through all elements    
    return True
    

'''
Write a program that prompts the user to enter 5 numbers.
The numbers must be entered as a comma separated list ( e.g. 4, 5, -2, 3, 7).
The program must calculate and output the average, the largest, and smallest
number the user entered. The program must also determine if the numbers are
entered in ascending, descending order, or out of order. You must use
functions to complete the work.  Define the functions listed below in your
program.
'''

user_list = eval(input("Please enter five numbers: "))

print(getAverage(user_list))
print(getLargest(user_list))
print(getSmallest(user_list))
print(isOrdered(user_list))
