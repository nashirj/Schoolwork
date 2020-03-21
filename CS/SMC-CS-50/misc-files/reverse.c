#include <stdio.h>

void reverse1();
void reverse2();

int main()
{
    int n = 5;
    int a[n];

    for (int i = 0; i < n; i++)
    {
        a[i] = i+1;
        printf("%d ", a[i]);
    }    
    printf("\n");
    
    int temp;
    for (int k = 0; k < n/2; k++)
    {
        /*
        printf("a[k] is %d ", a[k]);
        printf("\n");
        printf("a[n-k-i] is %d ", a[n-k-1]);
        printf("\n");
	    */
        temp = a[k];
	    a[k] = a[n-k-1];
	    a[n-k-1] = temp;
        /*
        printf("a[k] is %d ", a[k]);
        printf("\n");
        printf("a[n-k-i] is %d ", a[n-k-1]);
        printf("\n");
        */
    }
    
    for (int i = 0; i < n; i++)
    {
        printf("%d ", a[i]);
    }    
    printf("\n");

    return 0;
}


void reverse2(int x[], int n)
{
    int i, temp[n];
    for (i = 0; i < n; i++)
		temp[n-i-1] = x[i];
	for (i = 0; i < n; i++)
		x[i] = temp[i];
}
