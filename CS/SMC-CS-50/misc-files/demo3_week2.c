/*
Let's try working with some other datatypes...
*/
#include <stdio.h>

int main()
{
/*
C provides many different datatypes. Each one has a set of "valid values". As a
programmer, you must ensure that you are always within this valid set of values.
*/
short s = 12; /* valid values: -32768 to 32767 */
long l = 12; /* valid values: -2147483648 to 2147483647 */
char c = 'A'; /* valid values: one keyboard leoer, but also 0-255 */
unsigned int posValue = 12; /* valid values: 0 - 65535 */
unsigned long posBigValue = 12; /* valid values: 0 - 4294967295 */
float f = 12.5; /* a real value using single-precision */
double d = 12.5; /* a real value using double-precision */
/*
This next sec;on shows you the formarng string for
the different datatypes shown in this program.
*/
printf( "Here is your short: %hd\n", s);
printf( "Here is your long: %ld\n", l);
printf( "Here is your char: %c\n", c);
printf( "Here is your unsigned int: %u\n", posValue);
printf( "Here is your unsigned long: %lu\n", posBigValue);
printf( "Here is your float: %f\n", f);
printf( "Here is your double: %lf\n", d);
/*
This next sec;on shows you the formarng string for
specifying a width to the values C prints out.
*/
printf("float: %5.2f double: %10.4lf\n", f, d);
printf("No;ce the leading spaces before the value of the double!!\n" );
return(0);
}
