#include <stdio.h>

int main()
{
    int a = 12;
    int* intPtr;
    intPtr = &a;
    printf("%d\n", *intPtr);
    return 0;
}
