#include <stdio.h>
#include <string.h>

int foo(char * c)
{
    int x = 0, temp; //wasn't sure what the initial value of x should be
    do
    {
    if ((*c == '\0') || (check1(*c) == 0))
        return x;
    else if (check1(*c) == 1)
        x++;
    c++;
    } while (*c != '\0');
}

int main()
{
    char mystr[50]; //am I supposed to get input from the user for this?

    fgets(mystr, 50, stdin);
    printf("mystr is %s", mystr);
    //char *send;

    //send = &mystr[0]; //could just do send = mystr
    return 0;
}
