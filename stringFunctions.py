string.strip(s[, chars])
'''
Return a copy of the string with leading and trailing characters removed. If chars is omitted or None, whitespace
characters are removed. If given and not None, chars must be a string; the characters in the string will be stripped
from the both ends of the string this method is called on.
'''

string.swapcase(s)
#Return a copy of s, but with lower case letters converted to upper case and vice versa.

string.upper(s)
#Return a copy of s, but with lower case letters converted to upper case.

string.find(s, sub[, start[, end]])
'''
Return the lowest index in s where the substring sub is found such that sub is wholly contained in s[start:end].
Return -1 on failure. Defaults for start and end and interpretation of negative values is the same as for slices.
'''

string.count(s, sub[, start[, end]])
#Return the number of (non-overlapping) occurrences of substring sub in string s[start:end]. Defaults for start
#and end and interpretation of negative values are the same as for slices.

string.lower(s)
#Return a copy of s, but with upper case letters converted to lower case.

string.split(s[, sep[, maxsplit]])
'''
Return a list of the words of the string s. If the optional second argument sep is absent or None, the words are
separated by arbitrary strings of whitespace characters (space, tab, newline, return, formfeed). If the second
argument sep is present and not None, it specifies a string to be used as the word separator. The returned list
will then have one more item than the number of non-overlapping occurrences of the separator in the string. If
maxsplit is given, at most maxsplit number of splits occur, and the remainder of the string is returned as the
final element of the list (thus, the list will have at most maxsplit+1 elements). If maxsplit is not specified
or -1, then there is no limit on the number of splits (all possible splits are made).

The behavior of split on an empty string depends on the value of sep. If sep is not specified, or specified as
None, the result will be an empty list. If sep is specified as any string, the result will be a list containing
one element which is an empty string.
'''

string.join(words[, sep])
#Concatenate a list or tuple of words with intervening occurrences of sep. The default value for sep is a single
#space character. It is always true that string.join(string.split(s, sep), sep) equals s.

#to determine whether or not a char is a letter (works for other scripts as well, i.e. hangul, spanish, kanji)
s = "a123b"
for char in s:
    print(char, char.isalpha())


#Use the join method of the empty string to join all of the strings together with the empty string in between, like so:

a = ['a', 'b', 'c', 'd']
astr = ''.join(a) #returns 'abcd'

#removing spaces from a list of strings
#method 1 - replace
for i in hello:
    j = i.replace(' ','')
    k.append(j)

#method 2 - list comprehension, removes leading and trailing spaces from every string in the list using strip:
hello = [x.strip(' ') for x in hello]


#given a list:
mylist = ['dog', 'cat', 'mouse_bear', 'lion_tiger_rabbit', 'ant']
#first join the list with underscores and then re-split it:
"_".join(mylist).split('_')
#to get:
['dog', 'cat', 'mouse', 'bear', 'lion', 'tiger', 'rabbit', 'ant']