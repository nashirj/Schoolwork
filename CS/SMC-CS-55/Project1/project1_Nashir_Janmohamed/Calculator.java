import java.util.Scanner;

//import javax.swing.JOptionPane; //for pretty output

public class Calculator {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		//create variables
		float n1, n2, result = 0;
		char operator, again = 'y';
		
		///do while user wants to keep playing
		do
		{
			//create operation in loop so that we can modify from iteration to iteration
			String operation = "";
			
			System.out.println("Hi, I am really good at math! Put me to the test.");
			//used print() for second statement to prevent newline & follow format of spec
			System.out.print("Please enter two numbers and then press Enter: ");
			
			n1 = input.nextFloat();
			n2 = input.nextFloat();
			
			System.out.print("Please enter one of the operations +, -, * or / and press Enter: ");
			
			operator = input.next().charAt(0);
			
			//initialize operation based on value of operator
			switch(operator)
			{
			case '+':
				result = n1+n2;
				operation += "addition";
				break;
			case '-':
				result = n1-n2;
				operation += "subtraction";
				break;
			case '*':
				result = n1*n2;
				operation += "multiplication";
				break;
			case '/':
				result = n1/n2;
				operation += "division";
				break;
			default:
				//invalid operator
				System.out.println("I can compute really well, but what you entered is not one of the operations I know...");
				//play again?
				again = playAgain(again, input);
				if (again == 'y' || again == 'Y')
					continue;
				else if (again == 'n' || again == 'N')
				{
					System.out.println("Bye bye!");
					System.exit(0);
				}
			}
			
			//format and return output
			String out = formatOutput(n1, n2, result, operator);
			System.out.println(out);
			//JOptionPane.showMessageDialog(null, out);
			
			//play again?
			again = playAgain(again, input);
			
		}while (again == 'y' || again == 'Y');
		
		//exit loop and end program
		System.out.println("Bye bye!");
		System.exit(0);
	}
	
	public static char playAgain(char again, Scanner input) {
		System.out.print("Play again [Y/N]?: ");
		again = input.next().charAt(0);
		while(again != 'y' && again != 'Y' && again != 'n' && again != 'N')
		{
			System.out.println("Sorry, I don't understand...");
			System.out.print("Play again [Y/N]?: ");
			again = input.next().charAt(0);
		}
		return again;
	}
	
	//function that formats user input into a single string to be printed from main
	public static String formatOutput(float n1, float n2, float result, char operator)
	{
		String out = "";
		
		//"<n1>"
		if (n1 == (long)n1) //if n2 has no fractional value
			out += (long)n1;
		else
			out += n1;
		
		//" + "
		out += " " + operator + " ";
		
		//"<n2>"
		if (n2 == (long)n2) //if n1 has no fractional value
			out += (long)n2;
		else
			out += n2;
		
		//" = <result>"
		out += " = ";
		if (result == (long)result) //if result has no fractional value
			out += (long)result;
		else
			out += result;
		
		//out = "<n1> + <n2> = <result>"
		return out;
	}	
}
