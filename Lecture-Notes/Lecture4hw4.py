
def buildDict(refFileName):
	refDict = dict()
	fd = open(refFileName)
	lines = fd.readlines()
	for line in lines:
		word = line.strip()
		refDict[word] = True

	fd.close()

	return refDict

def parseFile(userFile):
	newDict = dict()
	fd = open(userFile)
	lines = fd.readlines()
	wordList = list()

	for line in lines:
		words = line.lower().split()
		wordList.extend(words)

	for word in wordList:
		word = word.strip()
		while len(word) > 0 and not word[-1].isalpha():
			word = word[:len(word)-1]

		if len(word) > 0:
			if newDict.get(word) == None:
				newDict[word] = 1
			else:
				newDict[word] = newDict[word] + 1

	
	fd.close()
	return newDict()

def spellChecker(refDict, wordFileDict):
	for word in wordFileDict.keys():
		if refDict.get(word) == None:
			print("misspelled '{}'".format(word))

def getWordCount(wordFileDict, word):
	if wordFileDict.get(word) == None:
		return 0
	else:
		return wordFileDict[word]


def main():
	try:
		buildDict('ref.txt')
	except Exception as e:
		print('buildDict Exception: ' + str(e))
		return

	inputFile = input('input file name: ')

	try:
		wordsInFile = parseFile(inputFile)
	except Exception as e:
		print('buildWords Exception: ' + str(e))
		return

	spellChecker(refDict, wordsInFile)

	request = input('Enter word to get word count: ')
	count = getWordCount(wordsInFile.keys(), request.lower())
	print("Word count for {} is {}".format(request, count))

if __name__ == '__main__': main()