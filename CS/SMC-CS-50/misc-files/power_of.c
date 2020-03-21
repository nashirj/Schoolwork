#include <stdio.h>

int PowerOf(int x, int y){

    int total = 1, z = 0;
    
    if (x <= 1) //if x is less than or equal to 1, could cause an infinite loop
    {
        return 0;
    }

    do
    {
        total *= x;
        z++;
    }while (total < y);
        
    if (total == y)
        return z;
    else
        return 0;
}

int main()
{
    int a, b, result;
    printf("please input two numbers: ");
    scanf("%d %d", &a, &b);
    result = PowerOf(a, b);

    if (result == 0)
        printf("%d is NOT a multiple of %d\n", a, b);
    else
        printf("%d to the power of %d is equal to %d\n", a, result, b);

    return 0;
}

