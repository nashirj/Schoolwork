/*
To show a table of temperature conversions from
Celsius to Fahrenheit, where C = 5/9(F-32), you will
need a star1ng value of F, and and end value of F,
and the increment. Let’s use start=0, end=300 and
the step is 20. The output should look something
like:
0 -17
20 -6
40 4
*/

#include "stdio.h"

void cels_to_fahr();

int main()
{
    cels_to_fahr();
    return 0;
}

void cels_to_fahr()
{
    int start = 0, end = 300, step = 20;
    for (int f_temp = start; f_temp <= end; f_temp += step)
    {
        printf("%d  ", f_temp);
        double c_temp_double = (5/9.0)*(f_temp-32);
        int c_temp = (int)c_temp_double;
        printf("%d\n", c_temp);
    }
}
