#include <stdio.h>
#include <stdlib.h>

int main()
{
    char x[50];
    scanf("%s", x);
    printf("%s\n", x);
    int i = atoi(x);
    printf("%d\n", i);
    
    char y[50];
    scanf("%s", y);
    printf("%s\n", y);
    double f = atof(y);
    printf("%f\n", f);
    
    return 0;
}
