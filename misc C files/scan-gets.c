#include <stdio.h>
#include <stdlib.h>

int main()
{
    char s[100], t[100];
    char *data;
    scanf("%s", s);
    data = gets(t);
    printf("%s\n%s\n", s, data);
}

