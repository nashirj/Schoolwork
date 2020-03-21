#include <stdio.h>

int f(int x)
{
    int y;
    if(x==0)
        return 1;
    else
    {
        y = 2 * f(x-1);
        return y+1;
    }
}

int main()
{
    int a;
    printf("input a number: "); 
    scanf("%d", &a);
    printf("%d\n", f(a));
    return 0;
}
