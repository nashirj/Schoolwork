#include <stdio.h>

#define PANIC printf("PANIC\n");
#define ABSOLUTE_VALUE( x ) (((x) < 0) ? -(x) : (x))

void terminate()
{
    printf("OH NO\n");
}

int main()
{
    int x = -20;
    PANIC;
    printf("all good\n");
    printf("%d, %d\n", x, ABSOLUTE_VALUE(x));
    return 0;
}
