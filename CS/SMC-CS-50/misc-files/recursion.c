#include <stdio.h>

void print_me(int j, int depth)
{
    if(depth <= j) {
    printf("Recursion! depth = %d j = %d\n",depth,j); //j keeps its value
    print_me(j, ++depth);
}
}

int main(void)
{
    print_me(3, 1);
    return 0;
}
