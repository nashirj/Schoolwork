#include "stdio.h"

int main()
{
    int a=1;
    
    while (42) 
    { // loops until the break statement in the loop is executed
        printf("a is %d\n",a);
        a = a*2;
        if(a>100) 
        {
            break;
        } 
        else if(a==64) 
        {
            continue; // Immediately restarts at while, skips next step
        }
        printf("a is not 64\n");
    }
    return 0;
}
