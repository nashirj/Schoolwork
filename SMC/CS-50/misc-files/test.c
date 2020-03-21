#include <stdio.h>
#include <assert.h>

int main()
{
    int s[10] = {1,2,4,52};
    int* p = &s[0];
    printf("swag\n");
    for (int i = 0; i < 10; i++)
    {
        printf("%d\n", i+1);
        printf("%p\n", p);
        printf("%c\n", *p);
        p++;
    }
    int x = 10;
    printf("%d\n", (x <= 10));
    printf("%d\n", (x == 11));
    return 0;
}
