'''
In this project your will create a simple bank applications that creates accounts for customers and performs simple
actions such as deposit, withdraw, and applying annual interest. The objective is to use object oriented programming
and inheritance in the program.
You shall define a Customer class. A customer has a first name, last name, and social security number. You must
override __str__ operator to return the customer first name, last name and ssn.

You shall define a BankAccount base class. A BankAccount has a customer, account number, and a balance.  A bank account can
 be opened with any amount of initial deposit.  For each bank account, a 10 digit random account number must be created.
 Bank account shall define the following methods: deposit, withdraw. applyAnnualInterest. Note that the amount withdrawn
 cannot exceed the balance. If it does, the amount should not be withdrawn and insufficient funds should be reported. You
 must override __str__ operator to return a pretty string representation of a bank account.

You shall define two types of account subclasses: Checking Account and Saving Account. These subclasses inherit from the
BankAccount base class. Each account accrues interest.  A saving account accrues 5% fixed interest and a checking account
accrues 2% for any amount in excess of $10000 (For example, if there is $11000 in the checking account, the interest is
only applied to $1000).
'''

import random

class Customer:
    def __init__(self, fName, lName, SSN):
        self.fName = fName
        self.lName = lName
        self.SSN = SSN

    def __str__(self):
        return ("{} {} (ssn: {})".format(self.fName, self.lName, self.SSN))


class BankAccount:
    def __init__(self, customer):
        self.customer = customer
        self.accountNumber = random.randrange(10**9, 10**10-1)
        self.balance = 0

    def deposit(self, amount):
        if amount <= 0:
            print("You must enter a positive (greater than zero) amount of money to deposit")
        self.balance += amount

    def withdraw(self, amount):
        if amount <= 0:
            print("You must enter a positive (greater than zero) amount of money to withdraw")
        if (self.balance - amount >= 0):
            self.balance -= amount
        else:
            print('Insufficient funds to withdraw $' + str(amount))


    def applyInterest(self, amount, rate):
        return amount * rate

    def __str__(self):
        return("{}, account number {}, balance ${}".format(self.customer, self.accountNumber, self.balance))


class CheckingAccount(BankAccount):
    def applyInterest(self):
        if (self.balance > 10000):
            self.balance += BankAccount.applyInterest(self, self.balance - 10000, .02)
        else:
            print('Balance = $' + str(self.balance) + ', interest only applied on amount greater than $10000...')


class SavingAccount(BankAccount):
    def applyInterest(self):
        self.balance += BankAccount.applyInterest(self, self.balance, .05)
        

    


def main():
    alin = Customer('Alin', 'Smith', '111-11-1111')
    mary = Customer('Mary', 'Lee', '222-22-2222')
    alinAccnt = CheckingAccount(alin)
    maryAccnt = SavingAccount(mary)

    alinAccnt.deposit(15000)
    print(alinAccnt)
    #Alin Smith (ssn: 111-11-1111), account number 1702660396, balance $20000
    alinAccnt.withdraw(5000)
    print(alinAccnt)
    #Alin Smith (ssn: 111-11-1111) , account number 1702660396, balance $15000
    alinAccnt.applyInterest()
    print(alinAccnt)
    #Alin Smith (ssn: 111-11-1111) , account number 1702660396, balance $15100.0


    maryAccnt.deposit(10000)
    print(maryAccnt)
    #Mary Lee (ssn: 222-22-2222) , account number 2552619508, balance $10000
    maryAccnt.withdraw(15000)
    #Mary Lee (ssn: 222-22-2222) , insufficent funds to withdraw $ 15000
    print(maryAccnt)
    #Mary Lee (ssn: 222-22-2222) , account number 2552619508, balance $10000

    maryAccnt.applyInterest()
    print(maryAccnt) 
    #Mary Lee (ssn: 222-22-2222) , account number 2552619508, balance $10500.0
    






if __name__ == '__main__': main()
