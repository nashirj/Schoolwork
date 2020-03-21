def vacation(report):
    if 'large bonuses' in report:
        print('Vacation time!')
    else:
        print('You need to work harder!')

# If string 'large bonuses' appears in string report then print 'Vacation time!’
report = 'no bonuses this quarter'
vacation(report)
report = 'the whole company receives large bonuses'
vacation(report)


# if hits is greater than 10 and shield is 0 then print "You're dead..."
hits = int(10)
shield = 0
if hits > 10 and shield == 0:
    print("You're dead...")
else:
    print("You survive for now")



hits, shield = 12, 2 # cool syntax!
hits = shield = 10
print(str(hits) + " " + str(shield))


# indentation in python are like brackets in other high level languages
# pay close attention to this!!

def temperature(t):
    if t > 86:
        print('It is hot')
    elif t > 32:
        print('It is cool')
    else:
        print('It is freezing')
    print('Goodbye')

# else if is abbreviated as elif in Python

temp0 = 50
temp1 = 100
temp2 = 0
temperature(temp0)
temperature(temp1)
temperature(temp2)



def temperatureRE1(t):
    if t > 32:
        print('It is cool')
    elif t > 86:
        print('It is hot')
    else: # t <= 32
        print('It is freezing')
    print('Goodbye')

temperatureRE1(temp0)
temperatureRE1(temp1)
temperatureRE1(temp2)

def temperatureRE2(t):
    if 86 >= t > 32: # cool syntax!! can specify a range explicitly
        print('It is cool')
    elif t > 86:
        print('It is hot')
    else: # t <= 32
        print('It is freezing')
    print('Goodbye')

temperatureRE2(temp0)
temperatureRE2(temp1)
temperatureRE2(temp2)

# can also specify a range implicitly
def temperatureRE3(t):
    if t > 86:
        print('It is hot')
    elif t > 32: # 86 >= t > 32
        print('It is cool')
    else: # t <= 32
        print('It is freezing')
    print('Goodbye')

temperatureRE3(temp0)
temperatureRE3(temp1)
temperatureRE3(temp2)

'''
Write function BMI() that:
takes as input a person’s height (in inches) and weight (in pounds)
computes the person’s BMI and prints an assessment, as shown below
The function does not return anything.

The Body Mass Index is the value (weight * 703)/height^2 . Indexes below 18.5
or above 25.0 are assessed as underweight and overweight, respectively;
indexes in between are considered normal. 
'''

def BMI(height, weight):
    val = (weight * 703)/(height**2)
    print(val)
    if val > 25.0:
        print('overweight')
    elif val < 18.5:
        print('underweight')
    else:
        print('normal')

height = 73
weight = 167

BMI(height, weight)
