#include "stdio.h"
#include <math.h>

int main()
{
    double x = 12345.6789;
    x *= 100;
    int y = (int)x;
    x = y/100.0;
    printf("%.2f\n", x);
    return 0;
}
