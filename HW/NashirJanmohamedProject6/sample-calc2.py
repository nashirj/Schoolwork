# Python program to  create a simple GUI 
# calculator using Tkinter
 
# import everything from tkinter module
from tkinter import *
 
# globally declare the expression variable
expression = ""
 
 
# Function to update expressiom
# in the text entry box
def press(num):
    # point out the global expression variable
    global expression

    expression += str(num)
 
    # update the expression by using set method
    equation.set(expression)
 
 
# Function to evaluate the final expression
def equalpress():
    # Try and except statement is used for handling the errors like zero division error etc.
    try:
        global expression
        # eval function evaluate the expression and str function convert the result into string
        total = str(eval(expression))
        equation.set(total)
 
        expression = ""
 
    except:
        equation.set(" error ")
        expression = ""
 
 
# Function to clear the contents
# of text entry box
def clear():
    global expression
    expression = ""
    equation.set("")
 
 
# Driver code
if __name__ == "__main__":
    # create a GUI window
    gui = Tk()
 
    # set the title of GUI window
    gui.title("Simple Calculator")
 
    # StringVar() is the variable class
    # we create an instance of this class
    equation = StringVar()
 
    # create the text entry box for
    # showing the expression .
    expression_field = Entry(gui, textvariable=equation)
 
    # grid method is used for placing
    # the widgets at respective positions
    # in table like structure .
    expression_field.grid(columnspan=4)
 
    equation.set('enter your expression')
 
    # create a Buttons and place at a particular
    # location inside the root window .
    # when user press the button, the command or
    # function affiliated to that button is executed .
    button1 = Button(gui, text='1', command=lambda: press(1), height=1, width=3)
    button1.grid(row=2, column=0)
 
    button2 = Button(gui, text='2', command=lambda: press(2), height=1, width=3)
    button2.grid(row=2, column=1)
 
    button3 = Button(gui, text='3', command=lambda: press(3), height=1, width=3)
    button3.grid(row=2, column=2)
 
    button4 = Button(gui, text='4', command=lambda: press(4), height=1, width=3)
    button4.grid(row=3, column=0)
 
    button5 = Button(gui, text='5', command=lambda: press(5), height=1, width=3)
    button5.grid(row=3, column=1)
 
    button6 = Button(gui, text='6', command=lambda: press(6), height=1, width=3)
    button6.grid(row=3, column=2)
 
    button7 = Button(gui, text='7', command=lambda: press(7), height=1, width=3)
    button7.grid(row=4, column=0)
 
    button8 = Button(gui, text='8', command=lambda: press(8), height=1, width=3)
    button8.grid(row=4, column=1)
 
    button9 = Button(gui, text='9', command=lambda: press(9), height=1, width=3)
    button9.grid(row=4, column=2)
 
    button0 = Button(gui, text='0', command=lambda: press(0), height=1, width=3)
    button0.grid(row=5, column=0)
 
    plus = Button(gui, text='+', command=lambda: press("+"), height=1, width=3)
    plus.grid(row=2, column=3)
 
    minus = Button(gui, text='-', command=lambda: press("-"), height=1, width=3)
    minus.grid(row=3, column=3)
 
    multiply = Button(gui, text='*', command=lambda: press("*"), height=1, width=3)
    multiply.grid(row=4, column=3)
 
    divide = Button(gui, text='/', command=lambda: press("/"), height=1, width=3)
    divide.grid(row=5, column=3)
 
    equal = Button(gui, text='=', command=equalpress, height=1, width=3)
    equal.grid(row=5, column=2)
 
    clear = Button(gui, text='AC', command=clear, height=1, width=3)
    clear.grid(row=5, column='1')
 
    # start the GUI
    gui.mainloop()