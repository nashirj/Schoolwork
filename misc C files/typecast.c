#include <stdio.h>

int main()
{
    double answer1,answer2;
    int i=5;
    answer1 = (double)i/4;
    answer2 = (double)(i/4);
    printf("%f %f\n", answer1, answer2);
    return 0;
}
