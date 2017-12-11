#include <stdio.h>

void dump( int a[], int size );
void sort( int a[], int size );

int main()
{
    int x[10] = {0,9,1,2,5,4,3,7,8,6};
    dump(x, 10);
    sort(x, 10);
    dump(x, 10);
    return 0;
}

void dump( int a[], int size )
{
    int i;
    for (i = 0; i < size; i++)
    {
        printf( "a[ %d ] = %d\n", i, a[i] );
    }
}

void sort( int a[], int size )
{
    int i, j, temp;
    for (i = 0; i < size; i++) 
    {
        for (j = 0; j < size; j++) //Get one pair of values ordered correctly…
        {
            if (a[i] < a[j]) 
            {
                temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        dump(a, 10);
        printf("\n");
    }
}
