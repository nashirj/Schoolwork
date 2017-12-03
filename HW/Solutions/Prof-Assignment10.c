/*********************************************************
 *  
 * Assignment 10 - String Processing
 * Sample Solution
 * 
 *********************************************************/
#include <stdio.h>
#include <string.h>

// function declaration
int countchars(char str[], char ch);

int main(){

	char str[50], ch; //the array for the sentence and ch for the character to be counted
	int count = 0;
	
	
	printf("Type a sentence:");
	gets(str); //str is an array of char or string and must use gets to assign it
	
	printf("\nEnter a character you want to count: ");
	scanf("%c",&ch);
	
	count=countchars(str, ch);

	if (count != -1) {
		printf( "%c was found %d times", ch, count );
	} else {
		printf("Character %c is not exist in the sentence you have entered", ch);
	}

	getchar();
	getchar();
	return 0;
}

int countchars(char str[], char ch)
{
	int count=0;
	int	k;
	
	for  (k= 0; k < strlen(str) ; k++){
	//when using a while you can stop the loop when ‘\0’ is found 
	//however in our case we don’t know how many chars there are
	//the user may not enter a 50 character sentence
	//hence using for loop with strlen as the condition in stoping it is better

		if (ch == str[k]){
			count++;
		}
	}

	if ( count != 0 ){
		return count;
	} else {
		return -1 ;
	}
}