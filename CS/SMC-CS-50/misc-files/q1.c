#include <stdio.h>
#include <string.h>

void fun(void)
{
    printf("wow\n");
}

int main ()
{
    char x[100];
    char *y = "abc123";
    printf("%s %s\n", x, y);
    int b = fun();
    return 0;
}
