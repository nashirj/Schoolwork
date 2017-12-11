#include <stdio.h>
#include <string.h>
int main()
{
char mystr[30] = "an example of function strchr";
printf ("%s", strchr(mystr, 'f'));
// output is from first f from start of string: f function strchr
getchar();
return 0;
}
