#include <stdio.h>
#include <string.h>

int main()
{
    char s[70] = "howie!";
    int x = sizeof(s)/sizeof(char);
    printf("%d\n", x);
    printf("%d\n", strlen(s));
}
