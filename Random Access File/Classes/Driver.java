/*****************************
 *CHAPTER NUMBER: 10 File I/O
 *FILE NAME: Extra Credit
 *PROGRAMMER: Jack Rollinson
 *DATE LAST MODIFIED: 10/18/2016
 *
 *====PROBLEM======
 *Create a BankAccount class with all methods.
 *Design a tester program that uses a (RAF) to store
 *the current information for each Bank Account object.
 *The tester should ask the user to enter an account number and
 *an amount to deposit.
 *
 *====ALGORITHM====
 *	Ask user for Account Number and Deposit amount
 *	If the account number can not be found in the file
 *	then the program should generate a random account number
 *	for the user.
 *	...
 *****************************/

//imports
import java.util.*;
import java.io.*;

public class Driver
{
	public static void main(String[] args)
	{
		//OBJECTS:
		Scanner keyboard = new Scanner(System.in);
		BankAccount[] accounts = new BankAccount[1000];
		//VARIABLES:
		String temp;
		int accountNum;
		double accountBalance = 0;
		
		System.out.println("Hello, what is your account number?\n");
		System.out.print("Account #: ");
		temp = keyboard.nextLine();
		
		if(temp.matches("[0-9]+"))
		{
			accountNum = Integer.parseInt(temp);
		}
		else
		{
			System.out.println("Sorry, your account number can only contain numbers, stopping program...");
			System.exit(0);
		}
		
		System.out.println("\nHow much would you like to deposit?\n");
		System.out.print("Deposit ammount: ");
		try
		{
			accountBalance += keyboard.nextDouble();
			keyboard.nextLine();	
		}
		catch(InputMismatchException e)
		{
			System.out.println("Sorry, you did not enter a valid deposit ammount, stopping program...");
			System.out.println("Error message: " + e.getMessage());
			System.exit(0);
		}
	}
}