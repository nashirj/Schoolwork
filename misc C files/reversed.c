#include <stdio.h>

void dump(int a[], int size);
int isReverse(int x[], int y[], int n);

int main()
{
    int a[10], b[10];

    for (int i = 0; i < 10; i++)
        a[i] = i;
    for (int i = 0; i < 10; i++)
        b[10-i-1] = i;

    //dump(a, 10);
    //dump(b, 10);

    int temp = isReverse(a, b, 10);

    printf("result is %d\n", temp);
    
    return 0;
}

int isReverse(int x[], int y[], int n)
{
	int i, j, result = 1;
	for (i = 0; i < n; i++)
	{
        if (x[i] != y[n-i-1])
        {
            result = 0;
        }
    }
	return result;
}

void dump( int a[], int size )
{
    int i;
    for (i = 0; i < size; i++)
    {
        printf("a[%d] = %d\n", i, a[i]);
    }
}
