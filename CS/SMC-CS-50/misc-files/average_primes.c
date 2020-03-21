#include <stdio.h>

void add_primes(int n);

int main()
{
    int user_in;

    printf("input an integer greater than 1: ");
    scanf("%d", &user_in);

    if (user_in <= 1)
    {
        printf("input is not greater than 1!\n");
        return -1;
    }

    add_primes(user_in);

    return 0;
}

void add_primes(int n)
{
    double total = 0, count = 0;

    while (n > 2)
    {

        for (int i = n - 1; i >= 2; i--)
        {
            if (n % i == 0)
            {
                printf("%d is not prime\n", n);
                break;
            }
            else if (i == 2 && n % i != 0)
            {
                printf("%d is prime\n", n);
                total += n;
                count++;
                break;
            }
        }
        n--;
    }

    if (n == 2)
    {
        printf("2 is prime\n");
        total += 2;
        count++;
    }
    
    printf("average of primes between 1 and %d is %.2f\n", n, total/count);
}

