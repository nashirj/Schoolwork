#include <stdio.h>

void swap(int * x, int * y)
{
    int temp = *x;
    *x = *y;
    *y = temp;
}

int main()
{
    int i = 0, j = 20;
    printf("%d, %d\n", i, j);
    swap( &i, &j );
    printf("%d, %d\n", i, j);

    int a, b, c;
    printf("%p, %p, %p\n", &a, &b, &c);
    return 0;
}
