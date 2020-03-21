#include <time.h>
#include <stdio.h>

int main()
{
    clock_t tic = clock();

    int x = 5, y = 7, z;
    z = x+y;
    
    clock_t toc = clock();
    
    double time = (double)(toc - tic) / CLOCKS_PER_SEC;

    printf("Elapsed: %lf seconds\n", time); 

    return 0;
}
