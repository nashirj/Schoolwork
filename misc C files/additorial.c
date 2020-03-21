#include <stdio.h>

int additorial(int x)
{
    if (x == 0)
        return 0;
    else if (x >= 1)
    {
        x += additorial(x-1);
        return x;
    }
    else
    {
        printf("error\n");
        return -1;
    }
}

int main()
{
    int a;
    scanf("%d", &a);
    printf("%d\n", additorial(a));
    return 0;
}
