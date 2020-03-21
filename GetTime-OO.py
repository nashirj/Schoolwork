from tkinter import Tk, Frame, Button, Label, Text, BOTTOM, LEFT, RIGHT
from time import strftime, localtime

class WallClock(Frame):
    def __init__(self,parent):
        #super().__init__(parent)
        Frame.__init__(self, parent)
        self.label = Label(self, text='Current Date and Time', height = 1) #why self?? i didn't understand
        self.text = Text(self, width = 40, height = 1)
        self.button = Button(self, text = 'click here', command = self.onClick)
        self.pack()
        self.button.pack(side=BOTTOM)
        self.label.pack(side=LEFT)
        self.text.pack(side=RIGHT)

    def onClick(self):
        time = strftime('%d %b %Y - %H:%M:%S %p\n', localtime())
        self.text.insert(0.0, time)


def main():
    root = Tk()
    WallClock(root) 
    root.mainloop()

if __name__ == '__main__': main()