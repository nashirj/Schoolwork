


def getInputDescriptor():
    while True:
        inputFile = input('Enter a file name: ')
        try:
            fd = open(inputFile)
            return fd
        except:
            print('unable to print file' + inputFile)


def getDataList(fd, colNum):
    dataList = list()
    dataTuple = list()

    fd.seek(0,0)

    #lines = fd.readlines()
    #need to get rid of \n at end of line
    lines = fd.read.split('\n')
    #print(lines)

    for line in lines:
        dataList.append(line.split(','))

    #print(dataList)
    for elem in dataList:
        dataTuple.append((elem[0], elem[colNum]))

    dataTuple.pop(0)
    #gets rid of first line

    return dataTuple


def averageData(data):
    avg = list()
    avgSum = 0
    count = 0

    date = data[0][0].split('-')

    prevMonth = date[1]
    prevYear = date[0]

    print(date)


def main():
    fd = getInputDescriptor() #file descriptor, name of file we're opening



if __name__ == '__main__': main()
