#include <stdio.h>

int IsAMultiple(int x, int y){
    int total = 1;
    
    if (x <= 1) //if x is less than or equal to 1, could cause an infinite loop
    {
        return 0;
    }

    do
    {
        total *= x;
    }while (total < y);
        
    if (total == y)
        return 1;
    else
        return 0;
}

int main()
{
    int a, b, result;
    printf("please input two numbers: ");
    scanf("%d %d", &a, &b);
    result = IsAMultiple(a, b);

    if (result == 1)
        printf("%d is a multiple of %d\n", a, b);
    else
        printf("%d is NOT a multiple of %d\n", a, b);

    return 0;
}
