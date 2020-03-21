#include <stdio.h>

int main()
{
    void *pa;
    char *ptemp;
    printf("%p\n", pa);
    printf("%p\n", ptemp);
    char x = 'a';
    char z = 't';
    ptemp = &z;
    printf("%p\n", ptemp);
    pa = &x;
    ptemp = (char *)pa;
    printf("%p\n", pa);
    printf("%p\n", ptemp);
}
