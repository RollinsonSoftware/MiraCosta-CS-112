/*****************************
 *CHAPTER NUMBER: 11 Recursion
 *FILE NAME: Project #1 Handout #3
 *PROGRAMMER: Jack Rollinson
 *DATE LAST MODIFIED: 10/18/2016
 *
 *====PROBLEM======
 *Write a static method that implements a recursive formula for
 *factorials. Place the method in a test program that allows the user
 *to compute n! (with an invocation of your static method) where the user
 *inputs the value of n. Your program should allow the user to enter another
 *value for n and repeat the calculation until they want to end the program.
 *
 *====ALGORITHM====
 *	LOOP to ask the user for a integer value
 *	make 'done' the stopping case for the do/while loop
 *	IF the user enters a valid entry, convert the string to an int
 *	IF the user enters zero or one, return 1.
 *	ELSE find the factorial of (n - 1) * n
 *	with n representing the users input.
 *****************************/

//imports
import java.util.Scanner;

public class Driver
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		String temp;
		int userNum;
		
		System.out.println("Welcome to the factorial calculator!\n");
		System.out.println("Enter a number you would like to know the factorial of...\n");
		System.out.println("============");
		
		do
		{
			System.out.print("\nEnter a number ('done' to exit): ");
			temp = keyboard.nextLine();
			
			if(temp.equalsIgnoreCase("done"))
			{
				System.out.println("\nClosing program...");
				keyboard.close();
				break;	
			}
			else
			{
				try
				{
					userNum = Integer.parseInt(temp);
					System.out.println(userNum + "! = " + fact(userNum));
					continue;
				}
				catch(NumberFormatException e)
				{
					System.out.println("\nError! You must enter an integer, try again...");
					continue;
				}
			}
			
		}while(temp.equalsIgnoreCase("done") == false);
		keyboard.close();
	}
	public static int fact(int n)
	{
		int result;
		
		if(n == 1 || n == 0)
		{
			result = 1;
			return result;
		}
		else
		{
			result = fact(n - 1) * n;
			return result;
		}
	}
}