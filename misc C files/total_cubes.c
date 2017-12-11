//finding the total of all doubles (or cubes...) between a range 0 to n.
#include <stdio.h>
#include <math.h>

void sum_cubes(int x);

int main()
{
    int a;
    scanf("%d", &a);

    sum_cubes(a);

    return 0;
}

void sum_cubes(int x)
{
    int total = 0;

    for (int i = 1; i <= x; i++)
    {
        printf("%d\n", i*i*i);
        total += pow(i, 3);
    }

    printf("%d\n", total);
}
