#include <stdio.h>
#include <string.h>
int main()
{
    char s1[30] = "string 1";
    printf("String s1 is: %s\n", s1); //Output
    char s2[30] = "string 2 : copied into s1";
    strcpy(s1,s2); // func;on copies s2 into s1//
    printf("String s1 is: %s\n", s1); //Output
    return 0;
}
