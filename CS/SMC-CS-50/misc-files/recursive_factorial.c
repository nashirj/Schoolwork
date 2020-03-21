#include <stdio.h>

long long int factorial(int x);

int main()
{
    int a;
    scanf("%d", &a);
    
    if (a < 1)
    {
        printf("invalid input\n");
        return -1;
    }

    printf("%lld\n", factorial(a));

    return 0;
}

long long int factorial(int x)
{
    if (x == 1)
        return 1;
    else
        return x*factorial(x-1);
}
