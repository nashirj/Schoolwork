from tkinter import Tk, Frame, Button, Entry, END

class CalcButton(Button):
	def __init__(self, frame, entry, row, col, text, columnspan=1, width=5):
		self.text = text
		self.entry = entry
		super().__init__(frame, text=text, width=width, command=self.clicked)
		self.grid(row=row, column=col, columnspan=columnspan)

	def clicked(self):
		if self.text == '=':
			inputExpr = self.entry.get()
			result = eval(inputExpr)
			self.entry.delete()
			self.entry.insert(str(result))
		elif self.text == 'AC':
			self.entry.delete()
			self.entry.insert('0')
		else:
			if self.entry.get() == '0':
				self.entry.delete()
				self.entry.insert(self.text)
			else:
				self.entry.insert(self.text)


class CalcEntry(Entry):
	def __init__(self, frame):
		super().__init__(frame, width=20)
		self.grid(row=0, column=0, columnspan=4)
		self.index = 0
		self.insert('0')

	def insert(self, text):
		super().insert(self.index, text)
		self.index = self.index + len(text)

	def delete(self):
		super().delete(0, END) 
		self.index = 0

class Calculator(Frame):
	def __init__(self):
		root = Tk()
		root.title('Calculator')
		super().__init__(root)

		entryField = CalcEntry(self)

		#displayed at row 1 column 0
		CalcButton(self, entryField, 1, 0, text='AC', columnspan=2, width=12)
		CalcButton(self, entryField, 1, 2, text='%')
		CalcButton(self, entryField, 1, 3, text='/')
		CalcButton(self, entryField, 2, 0, text='7')
		CalcButton(self, entryField, 2, 1, text='8')
		CalcButton(self, entryField, 2, 2, text='9')
		CalcButton(self, entryField, 2, 3, text='*')
		CalcButton(self, entryField, 3, 0, text='4')
		CalcButton(self, entryField, 3, 1, text='5')
		CalcButton(self, entryField, 3, 2, text='6')
		CalcButton(self, entryField, 3, 3, text='-')
		CalcButton(self, entryField, 4, 0, text='1')
		CalcButton(self, entryField, 4, 1, text='2')
		CalcButton(self, entryField, 4, 2, text='3')
		CalcButton(self, entryField, 4, 3, text='+')
		CalcButton(self, entryField, 5, 0, text='0', columnspan=2, width=12)
		CalcButton(self, entryField, 5, 2, text='.')
		CalcButton(self, entryField, 5, 3, text='=')

		self.pack(expand=True)
		self.mainloop()

def main():
	Calculator()


if __name__ == '__main__':main()