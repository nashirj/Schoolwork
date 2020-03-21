#include "stdio.h"

int main()
{
    printf("please input a number: ");
    int x;
    long long factorial;
    scanf("%d", &x);
    factorial = x;

    for (int i = x-1; i > 0; i--)
        factorial *= i;

    printf("you typed %d; the factorial of %d is %lld\n", x, x, factorial);
    return 0;
}

