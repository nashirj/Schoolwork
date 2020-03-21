//finding the prime numbers from 0 to n where n is the input. Do this using loops, and recursive functions
#include <stdio.h>

void find_primes(int n);

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

    find_primes(user_in);

    return 0;
}

void find_primes(int n)
{
    //check whether or not all primes have been found
    if (n == 1)
    {
        printf("%d is not prime\n", n);
        return;
    }
    
    for (int i = n - 1; i > 1; i--)
    {
        if (n % i == 0)
        {
            printf("%d is not prime\n", n);
            n--;
            find_primes(n);
            return;
        }
    }

    printf("%d is prime\n", n);
    n--;
    find_primes(n);
    return;
}
