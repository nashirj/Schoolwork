/********************************************************************************
* Write a function to take a string of no more than 50 characters and a        *
* character and returns the count of a letter the user inputs. If the letter   *
* is not found, the function returns -1.                                       *
*                                                                              *
* Use the function in main to get two inputs from the user, a sentence and     *
* a character, then show the count of that character.                          *
********************************************************************************/

#include <stdio.h>
#include <string.h>

int char_count(char word[], int limit, char letter);

int main()
{
	printf("Hello! Please input a string of no more than 50 characters:\n");

	char user_word[51]; //make size 51 so that we have space for null terminator
	fgets(user_word, 51, stdin);
	/*I read online that gets is unsafe, because it's possible for the user to
	  enter a value too large for the declared variable. I want to use fgets to
	  avoid potential buffer overflow, but either way this could be problematic.
	  if the user inputs too many characters, then the invocation of scanf for
	  the char we're searching for will get an erroneous value (leftover character(s)
	  which was left unread by fgets), but if I use gets, then there might be a buffer
	  overflow. what is the best way to handle this?
	 */

	printf("Please input a letter to be shown how many times the letter "
		"appeared in the given string: ");
	char user_char;
	scanf("%c", &user_char);

	int len = strlen(user_word);

	int result = char_count(user_word, len, user_char);

	if (result != -1)
	{
		if (result == 1)
			printf("There is 1 occurrence of that char\n");
		else
			printf("There are %d occurrences of that char\n", result);
	}
	else
		printf("There were no occurrences of that char\n");

	return 0;
}


int char_count(char word[], int limit, char letter)
{
	char key[94];
	for (int i = 0; i < 94; i++)
		key[i] = 0; //initialize key

	for (int i = 0; i < limit; i++)
		key[word[i] - 32]++;

	if (key[letter - 32] != 0)
		return key[letter - 32];
	else
		return -1;
}


