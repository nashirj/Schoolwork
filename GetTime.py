from tkinter import Tk, Frame, Button, Label, Text, BOTTOM, LEFT, RIGHT
from time import strftime, localtime

text = None

def onClick():
    time = strftime('%d %b %Y - %H:%M:%S %p\n', localtime())
    text.insert(0.0, time)


def main():
    global text
    root = Tk()
    frame = Frame(root)
    label = Label(frame, text = "current Date and Time", height = 1)
    text = Text(frame, width = 40, height = 1)
    button = Button(frame, text = 'click here', command = onClick)

    frame.pack()
    button.pack(side=BOTTOM)
    label.pack(side=LEFT)
    text.pack(side=RIGHT)

    root.mainloop()

if __name__ == '__main__': main()