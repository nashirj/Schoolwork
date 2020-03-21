/*k
 *j
 *zipcodeList[]
 *nZips
 *duplicates
 *if any two elements in zipcodeList are duplicates,x
 *set duplicates = 1; else, set duplicates = 0
*/

#include <stdio.h>

int duplicate(int nZips, int zipcodeList[]) 
{
    int duplicates = 0;
    for (int j = 0; j < nZips; j++)
    {
	    for (int k = 0; k < nZips; k++)
	    {
	    	if (zipcodeList[j] == zipcodeList[k] && j != k)
	    	{
	       		duplicates = 1;
		    	break;
		    }
        }
	    if (duplicates == 1)
		    break;
    }
    return duplicates;
}

int consec_dup(int nZips, int zipcodeList[])
{
    int duplicates = 0;
    for (int k = 0; k < nZips; k++)
    {
    	if (zipcodeList[k] == zipcodeList[k+1])
    		duplicates = 1;
    }
    return duplicates;
}

int three_consecutive(int n, int x[])
{
    for (int i = 0; i < n-1; i++)
    //set bound at n-1 so we don't go out of bounds 
    //when checking the last element
    {
        if (x[i] == x[i+1] && x[i] == x[i+2])
            return 1;
    }
    return 0;
}

int main()
{
    int list[] = {1,2,4,4,4};
    int size = (sizeof(list)) / 4;
    printf("%d\n", size);
    int temp = duplicate(size, list);
    if (temp == 1)
        printf("there are duplicates\n");
    else if (temp == 0)
        printf("there are no duplicates\n");
    else
        printf("error\n");

    temp = consec_dup(size, list);
    if (temp == 1)
        printf("there are consecutive duplicates\n");
    else if (temp == 0)
        printf("there are no consecutive duplicates\n");
    else
        printf("error\n");

    temp = three_consecutive(size, list);
    if (temp == 1)
        printf("there are 3 consecutive duplicates\n");
    else if (temp == 0)
        printf("there are not 3 consecutive duplicates\n");
    else
        printf("error\n");
    
    return 0;
}
