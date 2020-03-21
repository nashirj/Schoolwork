# Widget Frame – the widget Frame is used to house the keys and the entry field in a grid.
# Widgent Button – it is used to represnent the calculator keys. When user clicks on keys, the key text should
# appear in the entry field.
# Widget Entry – the widget Entry is used to display what expression is calculated and the result of calculation. 
# When calculator application starts, the field displays value 0. When user clicks ‘AC’, the field is reset and
# displays 0. When user clicks on the calculator keys, the full expression that is calculated should be displayed:

# import everything from tkinter module
from tkinter import Tk, StringVar, Entry, Frame, Button, Label, Text

class Calculator(Frame):
    # Function to clear the contents of text entry box
    def clear(self):
        self.expression = ""
        self.equation.set("0")

    # Function to update expression in the text entry box
    def press(self, num):
        # point out the global expression variable
        self.expression += str(num)
 
        # update the expression by using set method
        self.equation.set(self.expression)

    # Function to evaluate the final expression
    def equal(self):
        # Try and except statement is used for handling the errors like zero division, erroneous input, etc...
        try:
            # eval function evaluate the expression and str function convert the result into string
            total = str(eval(self.expression))
            self.equation.set(total)
 
            self.expression = ""
 
        except:
            self.equation.set(" error ")
            self.expression = ""

    def __init__(self,master):
        master.title('C...')
        
        #not sure why we can't just use a string here
        self.equation = StringVar()
 
        # create the text entry box for showing the expression
        self.expression_field = Entry(master, textvariable=self.equation)
        # grid method is used for placing the widgets at respective positions in table like structure .
        self.expression_field.grid(columnspan=4)
        self.equation.set('0')
        self.expression = ""
 
        AC = Button(master, text='AC', command=self.clear, height=1, width=10)
        AC.grid(row=2, column=0, columnspan=2)

        modulo = Button(master, text='%', command=lambda: self.press("%"), height=1, width=5)
        modulo.grid(row=2, column=2)
 
        divide = Button(master, text='/', command=lambda: self.press("/"), height=1, width=5)
        divide.grid(row=2, column=3)
        
        b7 = Button(master, text='7', command=lambda: self.press(7), height=1, width=5)
        b7.grid(row=3, column=0)
 
        b8 = Button(master, text='8', command=lambda: self.press(8), height=1, width=5)
        b8.grid(row=3, column=1)
 
        b9 = Button(master, text='9', command=lambda: self.press(9), height=1, width=5)
        b9.grid(row=3, column=2)
     
        multiply = Button(master, text='*', command=lambda: self.press("*"), height=1, width=5)
        multiply.grid(row=3, column=3)

        b4 = Button(master, text='4', command=lambda: self.press(4), height=1, width=5)
        b4.grid(row=4, column=0)
 
        b5 = Button(master, text='5', command=lambda: self.press(5), height=1, width=5)
        b5.grid(row=4, column=1)
 
        b6 = Button(master, text='6', command=lambda: self.press(6), height=1, width=5)
        b6.grid(row=4, column=2)
 
        minus = Button(master, text='-', command=lambda: self.press("-"), height=1, width=5)
        minus.grid(row=4, column=3)
 
        b1 = Button(master, text='1', command=lambda: self.press(1), height=1, width=5)
        b1.grid(row=5, column=0)
 
        b2 = Button(master, text='2', command=lambda: self.press(2), height=1, width=5)
        b2.grid(row=5, column=1)
 
        b3 = Button(master, text='3', command=lambda: self.press(3), height=1, width=5)
        b3.grid(row=5, column=2)
 
        plus = Button(master, text='+', command=lambda: self.press("+"), height=1, width=5)
        plus.grid(row=5, column=3)
 
        b0 = Button(master, text='0', command=lambda: self.press(0), height=1, width=10)
        b0.grid(row=6, column=0, columnspan=2)

        period = Button(master, text='.', command=lambda: self.press('.'), height=1, width=5)
        period.grid(row=6, column=2)
        
        equal = Button(master, text='=', command=self.equal, height=1, width=5)
        equal.grid(row=6, column=3)

def main():
    root = Tk()
    Calculator(root)
    root.mainloop()


if __name__ == '__main__': main()