'''
In this project, you will develop a simple spell checker program that spots misspelled words in a file
by checking each word in the file against a provided reference dictionary.

A list of correctly spelled English words is provided as a reference (ref.txt). There is one word per 
line in this file. The user file to be checked is a text file where each space-separated word of the file
is to be examined.  Punctuations, case, and numbers should be ignored. If a word from the file does not
exist in the provided list then it is assumed to be misspelled.

After identifying the misspelled words, the program should prompt the user to enter a word and it should
report the number of times the word appeared in the file.

Your program must do the following:

Read the refernece file “ref.txt”. This file consists of words, one word per line. Use a dictaionry container
to store the words that are in the ref.txt.
Prompt the user for the name of the file to spell check. Program should read the words in the file and store
the words in a dictionary container where the keys are the words in the file and values are the number of times
the word is used in the file.
Spellcheck each word and then display the words that were misspelled.
Prompt the user to enter a word and return the number of times the word was used in the file
Notes:

Make sure to eliminate the punctuation when constructing the dictionary from the input file
If numbers are being use in the input file, they shouldn’t be spellchecked
sample.txt file is provided as a test case. Make sure your program provides the same results as shown below:
You can download the ref.txt and sample.txt from the links below:
'''

def format_dictionary(user_in):
	infile = open(user_in)
	lst_ref_dictionary = infile.read().split('\n')
	infile.close()
	lst_ref_dictionary.pop(-1)
	# is there a better way to create a dictionary?
	ref_dictionary = {}
	for word in lst_ref_dictionary:
		if word not in ref_dictionary:
			ref_dictionary[word] = True
	return ref_dictionary


def get_user_in():
	# Prompt the user for the name of the file to spell check.
	filename = input('input file name: ')
	
	while(True):
		try:
			infile = open(filename)
			break;
		except:
			filename = input('please input a valid file name: ')

	#Program should read the words in the file
	lst_user_in = infile.read().split()
	infile.close()

	#Program should store the words in a dictionary container where the keys are the words in the file and values are the
	#number of times the word is used in the file.
	#what about words with punctuation in them? i.e. "shouldn't" or "space-separated"?

	for word in lst_user_in:
		if not (all(word[i].isalpha() for i in range(len(word)))):
			#take care of words separated by/ending with/beginning with punctuation
			temp_word = ''.join([i if i.isalpha() else ' ' for i in word])
			if temp_word == '':
				lst_user_in.remove(word)
			else:
				lst_user_in[lst_user_in.index(word)] = temp_word
	#found on stackoverflow - makes list a string separated by spaces, then splits using space as a delimiter, then gets
	#rid of list entries separated by a space
	lst_user_in = ' '.join(lst_user_in).split(' ')
	lst_user_in = [word for word in lst_user_in if word != '']

	return lst_user_in


def spell_check(user_in, dictionary):
	# Spellcheck each word and then display the words that were misspelled.
	# if one word is misspelled multiple times, should we print it every time?
	for word in user_in:
		word_no_caps = word.lower()
		if word_no_caps not in dictionary:
			print("misspelled word '", end='')
			print(word + "'")


def create_user_dictionary(user_in):
	user_dict = {}
	for word in user_in:
		word_no_caps = word.lower()
		if word_no_caps in user_dict:
			user_dict[word_no_caps] += 1
		else:
			user_dict[word_no_caps] = 1
	return user_dict


def word_count(user_dict):
	#Prompt the user to enter a word and return the number of times the word was used in the file
	repeated_word = input('enter word to get word count: ')
	word_no_caps = repeated_word.lower()
	if word_no_caps in user_dict:
		if user_dict[word_no_caps] == 1:
			print("the word '" + repeated_word + "' is repeated " + str(user_dict[word_no_caps]) + " time")
		else:
			print("the word '" + repeated_word + "' is repeated " + str(user_dict[word_no_caps]) + " times")
	else:
		print("there were no occurences of '" + repeated_word + "' in the input.")


def main():
	# Read the reference file “ref.txt”. This file consists of words, one word per line. Use a dictionary container
	# to store the words that are in the ref.txt.
	ref_dictionary = format_dictionary('ref.txt')

	# Prompt the user for the name of the file to spell check. Program should read the words in the file and store
	# the words in a dictionary container where the keys are the words in the file and values are the number of times
	# the word is used in the file.
	user_in = get_user_in()

	#Spellcheck each word and then display the words that were misspelled.
	spell_check(user_in, ref_dictionary)
	
	#Prompt the user to enter a word and return the number of times the word was used in the file
	word_count(create_user_dictionary(user_in))

if __name__ == '__main__': main()



