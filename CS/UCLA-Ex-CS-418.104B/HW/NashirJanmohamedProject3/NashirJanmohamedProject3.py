'''
In this project, we want to do some preliminary data mining of the prices of Apple stock. Your program will calculate the monthly average
    prices of Apple stock from 1984 to 2013.  A file of Apple's daily stock's prices will be given to you named table.csv. You can open the
    file by notepad or similar text editor, and it is comma delimited. If you open it with Excel, it shows you the data in a spreadsheet.

You must implement the following functions:

getInputDescriptor(): In this function, you are required to repeatedly prompt for the name of an input file until the user
    enters filename and the file can be opened for input. Return a file descriptor attached to the opened file.

getDataList(file_object, column_number): In this function, you are required to read the file of Apple's data. The function
    is flexible as it can read the data for any column of the data (1 through 6). If you read column 6, you are gathering the
    data for the "Adjusted Daily Close". If you read column 5, you are gathering data for the "Volume" that day. The function
    returns a list that consists of tuples. Each tuple is of the form: (date, column_data). For example: ('2013-02-08', 474.98)
    if we were collecting  data from column 6.

averageData(list_of_tuples): In this function, take in an argument that is the list of tuples generated by getDataList above.
    You will average the data for each month, and regenerate a list of tuples. A tuple here will have the form: (data_avg, date).
    For example: (2972945.4545454546, '07:1985') . Note the date does not contain a day any more.

outputAverage(filename, average): In this function, take in an argument that is the list of tuples generated by averageData above.
    You output the date and average data in the tuple to a file. The file name follows the naming convention 'data_x.txt where 'x'
    is the column number. For example, the average data for column 1 will be data_1.txt. For your refernce, these files are attached
    to the assignment. Compare the output of your program with the attached files.

main(): In this function, you:
call getInputDescriptor to get a file descriptor
iterate through columns 1-6 to average
call the getDataList function
call the averageData function
call the OutputAverage

Files to use:
table.csv
data_1.txt
data_2.txt
data_3.txt
data_4.txt
data_5.txt
data_6.txt
Assignment Notes:

When reading the input file, you should be careful about the first line which does not contain any data.
Remember the split() function, which takes as an argument the character to split on, and returns a LIST of STRINGS
Since there are so many fields, do some testing (E.g. output some parsed data) to make sure that you get the correct data.
Remember to close your files after you have opened them
Example Output for data_1.txt
02:2013       458.46
01:2013       502.24
12:2012       534.54
11:2012       566.05
10:2012       640.86
09:2012       682.31
08:2012       640.36
07:2012       599.43
06:2012       574.49
05:2012       565.07
04:2012       610.23
03:2012       575.34
02:2012       492.34
01:2012       427.35
12:2011       392.23
11:2011       386.52
'''

# In this function, you are required to repeatedly prompt for the name of an input file until the user enters
# filename and the file can be opened for input. Return a file descriptor attached to the opened file.
def getInputDescriptor():

    filename = input("Please input the filename where the data is stored: ")
    while(True):
        try:
            infile = open(filename)
            print("Successfully opened file")
            infile.close()
            return filename
        except IOError:
            filename = input('Please enter a valid filename: ')



# In this function, you are required to read the file of Apple's data. The function is flexible as it can read
# the data for any column of the data (1 through 6). If you read column 6, you are gathering the data for the
# "Adjusted Daily Close". If you read column 5, you are gathering data for the "Volume" that day. The function
# returns a list that consists of tuples. Each tuple is of the form: (date, column_data).
# For example: ('2013-02-08', 474.98) if we were collecting  data from column 6.
def getDataList(file_object, column_number):
    infile = open(file_object, 'r')
    strList = infile.readlines()[1:] # ignore firstLine
    infile.close()

    content = [line.split(',') for line in strList]
    date = [line[0] for line in content]
    data = [float(line[column_number]) for line in content]
    
    return [tuple(date), tuple(data)]



# In this function, take in an argument that is the list of tuples generated by getDataList above. You will
# average the data for each month, and regenerate a list of tuples. A tuple here will have the form: (data_avg, date).
# For example: (2972945.4545454546, '07:1985') . Note the date does not contain a day any more.
def averageData(list_of_tuples):

    formatted_dates = [date.split('-') for date in list_of_tuples[0]]
    
    list_len = len(list_of_tuples[0])
    # list_len == len(list_of_tuples[0]) == len(list_of_tuples[1]) == len(formatted_dates)

    months = list()
    avg_per_month = list()

    #initialize monthly variables, loop starts at 1
    monthly_total = list_of_tuples[1][0]
    days_in_current_month = 1

    for i in range(1, list_len):
        if (formatted_dates[i][1] == formatted_dates[i-1][1]):
            monthly_total += list_of_tuples[1][i]
            days_in_current_month += 1
        else:
            months.append('{}:{}'.format(formatted_dates[i-1][1], formatted_dates[i-1][0]))
            avg_per_month.append(monthly_total/days_in_current_month)
            #reset monthly variables
            monthly_total = list_of_tuples[1][i]
            days_in_current_month = 1
    
    return [tuple(avg_per_month), tuple(months)]




# In this function, take in an argument that is the list of tuples generated by averageData above. You output the
# date and average data in the tuple to a file. The file name follows the naming convention 'data_x.txt where 'x'
# is the column number. For example, the average data for column 1 will be data_1.txt. For your refernce, these files
# are attached to the assignment. Compare the output of your program with the attached files.
def outputAverage(filename, average):
    outfile = open(filename, 'w')

    for i in range(len(average[0])):
        outfile.write('{:7} {:13.2f}\n'.format(average[1][i], average[0][i]))
    
    outfile.close()

    


    
def main():
    # call getInputDescriptor to get a file descriptor
    filename = getInputDescriptor()
    print(filename)

    for i in range(1, 7):
        dataList = getDataList(filename, i)
        dataAvg = averageData(dataList)
        outputAverage('data_' + str(i) + '.txt', dataAvg)
        
    print('Successfully created 6 output files')

# entry point for program
if __name__ == '__main__': main()
