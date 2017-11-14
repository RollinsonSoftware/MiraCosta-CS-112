/****************************************************
 *====ALGORITHM====
 *import the scanner for user input
 *out put the current result to show that it starts at
 *zero.
 *have the user select an operation: add, subtract,
 *multiply, and divide.
 *if the user enters an invalid operation sign then.
 *throw an exception, and tell the user what they did 
 *wrong.
 *have them try again until they enter a valid operation.
 *then have the user enter a double to complete the equation.
 *loop to have the user repeat this proccess until they enter "R".
 *if the user enters r then, the instance of that loop ends.
 *and the final result is outputted to the screen.
 *the result is then cleared to zero, incase there is another loop.
 *loop to see if the user would like to enter another equation.
 *if the user enters yes then repeat the algorithm, if no
 *the program exits.
 ****************************************************/
import java.util.Scanner;
public class Driver
{
	public static final char ADD = '+';
	public static final char SUBTRACT = '-';
	public static final char MULTIPLY = '*';
	public static final char DIVIDE = '/';
	
	public static void main(String[] args)
	{
		Calculator result = new Calculator();
		Scanner keyboard = new Scanner(System.in);
		String input = "";
		String again = "";
		
		System.out.println("Calculator is on...");
		System.out.println(result);
		do
		{
			do
			{
				try
				{
					System.out.print("\nPlease pick an operation (+ - * /): ");
					input = keyboard.nextLine();
					
					if((input.indexOf(ADD) == 0))
					{
						System.out.println("How much would you like to add?");
						result.add(keyboard.nextDouble());
						keyboard.nextLine();
						System.out.println(result);
					}
					else if((input.indexOf(SUBTRACT) == 0))
					{
						System.out.println("How much would you like to subtract?");
						result.subtract(keyboard.nextDouble());
						keyboard.nextLine();
						System.out.println(result);
					}
					else if((input.indexOf(MULTIPLY) == 0))
					{
						System.out.println("How much would you like to multiply by?");
						result.multiply(keyboard.nextDouble());
						keyboard.nextLine();
						System.out.println(result);
					}
					else if((input.indexOf(DIVIDE) == 0))
					{
						System.out.println("How much would you like to divide by?");
						result.divide(keyboard.nextDouble());
						keyboard.nextLine();
						System.out.println(result);
					}
					else if(input.equalsIgnoreCase("r"))
					{
						System.out.println("The final result was: " + result.getResult());
						result.clear();
					}
					else
					{
						throw new UnknownOperatorException();
					}
				}
				catch (UnknownOperatorException e)
				{
					System.out.println("\nThat is an unknown operation. \nTry again.");
				}	
			}while(input.equalsIgnoreCase("r") == false);
			
			System.out.print("Again? (y/n): ");
			again = keyboard.nextLine();
					
		}while(again.equalsIgnoreCase("no") == false
				&& again.equalsIgnoreCase("n") == false);
		keyboard.close();
		
		System.out.println("Closing Calculator...");
	}
}