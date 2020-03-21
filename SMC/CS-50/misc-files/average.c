#include <stdio.h>

int main()
{
    float in, temp, average = 0;
    printf("please input a value: ");
    scanf("%f %f", &in, &temp);
    
    if (in == 0)
        return 0;
    else if (in != 0 && temp == 0)
        printf("average is %f\n", in);               
    else if (in != 0 && temp != 0)
    {
        temp += in;
        average = (temp)/2;
        printf("please input a value: ");
        scanf("%f", &in);

        for (int i = 3; in != 0; i++)
        {
            temp += in;
            average = (temp)/i;
            printf("please input a value: ");
            scanf("%f", &in);
        }
    }
    
    printf("average is %f\n", average);

    return 0;
}

