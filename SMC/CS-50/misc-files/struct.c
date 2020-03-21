#include <stdio.h>
#include <string.h>
 
struct student 
{
            int id;
            char name[20];
            float percentage;
};
 
void func(struct student record);
struct student no2(struct student name);
 
int main() 
{
            struct student record;
            struct student Nashir;
 
            record.id=1;
            strcpy(record.name, "Raju");
            record.percentage = 86.5;

            Nashir = no2(record);
 
            func(record);
            func(Nashir);
            return 0;
}
 
void func(struct student record)
{
            printf(" Id is: %d \n", record.id);
            printf(" Name is: %s \n", record.name);
            printf(" Percentage is: %f \n", record.percentage);
}

struct student no2(struct student name)
{
            return name;
}