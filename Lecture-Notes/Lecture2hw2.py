def getAverage(data):
    return sum(data)/len(data)

def getLargest(data):
    return max(data)

def getSmallest(data):
    return min(data)

def isOrdered(data):
    if all(data[i] == data[i+1] for i in range(len(data) - 1)):
        return 'all equal elements'
    elif all(data[i] <= data[i+1] for i in range(len(data) - 1)):
        return 'ascending'
    #all function makes a list out of input
        #Return True if bool(x) is True for all values x in the iterable.
        #If the iterable is empty, return True.
    elif all(data[i] >= data[i+1] for i in range(len(data) - 1)):
        return 'descending'
    #if all elements are true, the list is descending
    else:
        return 'out of order'

def main():
    userInput = input('Enter a comma separated list of 5 numbers: ')
    strNumList = userInput.split(',')
    # how does split work?
    numList = [float(i) for i in strNumList]
    # creates a float for every element (each string) in strNumList

    # print(strNumList)
    # print(numList)

    avg = getAverage(numList)
    largest = getLargest(numList)
    
    print('Average is ', avg)
    print('Largest is ', largest)

if __name__ == '__main__': main()



# should never hard code a size for the list, use the len function to get number
# of elements in the list/do any other operations


# if we need to perform arithmetic operations on return value return int or float
# but otherwise it doesn't matter

# // returns the floor
