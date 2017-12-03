#include <stdio.h>

float deposit(float bal, float amt);

float withdraw(float bal, float amt);

int main()
{
    int menu_num; //user input for menu selection
    float balance, amount;
    
    //initialize balance
    printf("please input the initial balance: $");
    scanf("%f", &balance);

    do
    {
        //display menu
        printf("pick a number 1 through 4\n");
        printf("1: show balance\n");
        printf("2: make a deposit\n");
        printf("3: make a withdrawal\n");
        printf("4: quit\n");

        scanf("%d", &menu_num);

        switch(menu_num)
        {
            case 1: //show balance
                printf("your balance is currently $%.2f\n", balance);
                break;
            case 2: //make a deposit
                printf("input amount to be deposited\n");
                scanf("%f", &amount);
                if (amount >= 10000 || amount <= 0)
                {
                    printf("invalid input\n");
                    break;
                }
                balance = deposit(balance, amount);
                break;
            case 3: //make a withdrawal
                printf("input amount to be withdrawn\n");
                scanf("%f", &amount);
                if (amount <= 0 || (balance-amount) < 10)
                {
                    printf("invalid input\n");
                    break;
                }
                balance = withdraw(balance, amount);
                break;
            case 4: //quits
                break;
            default: //error message for invalid input
                printf("ERROR\n");
                break;
        }
    }while (menu_num != 4);

    //get rid of escape character from switch statements
    char dummy;
    scanf("%c", &dummy);

	scanf("%c", &dummy);
	
    return 0;
}


float deposit(float bal, float amt)
{
    bal += amt;
    return bal;
}

float withdraw(float bal, float amt)
{
    bal -= amt;
    return bal;
}
