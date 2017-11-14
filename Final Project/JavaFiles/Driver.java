/*****************************
 *CHAPTER NUMBER: CS112 Final Project
 *FILE NAME: Banking Application
 *PROGRAMMER: Jack Rollinson
 *DATE LAST MODIFIED: 12/12/2016
 *
 *====PROBLEM======
 *Create a bank account program that features commands for the user to:
 *create an account
 *delete an account
 *check the balance of an account
 *deposit money in to an account
 *withdraw money from an account
 *transfer money between two accounts using their account numbers
 *collect annual fees from all the accounts
 *issue interest payments to all the accounts
 *when the program exits save all account information to a text file
 *
 *====ALGORITHM====
 *display the command menu so the user knows how to navigate the program
 *loop to ask the user for commands until they enter the 'exit' command
 *the exit command should not only end the program, but also save all 
 *	account information to a text file.
 *
 *IF (user enters create)
 *	ask user which type of account
 *	ask user for nessisary information
 *	create a new account and add it to the ArrayList
 *
 *ELSE IF (user enters 'delete')
 *	ask the user for their account information
 *	search the ArrayList for said account
 *	remove the account from the ArrayList
 *
 *ELSE IF (user enters 'balance')
 *	ask the user for their pin number
 *	loop through the accounts 
 *	output all the accounts linked to that pin number
 *
 *ELSE IF (user enters 'deposit')
 *	ask the user for their account number
 *	ask the the user for their pin to verify
 *	ask the user to enter an amount
 *	deposit said amount to the users account
 *
 *ELSE IF (user enters 'withdraw')
 *	ask the user for their account number
 *	ask the the user for their pin to verify
 *	ask the user to enter an amount
 *	withdraw said amount from the users account
 *
 *ELSE IF (user enters 'transfer')
 *	ask the user for their account number
 *	ask the the user for their pin to verify
 *	ask the user to enter an amount
 *	ask the user for the account number of the account they would like to
 *		transfer the money to.
 *	withdraw the money from the first account
 *	deposit the money into the second account
 *
 *ELSE IF (user enters 'collect')
 *	loop through the list of accounts
 *	for every checking account subtract the annual fee for that account
 *
 *ELSE IF (user enters 'pay')
 *	loop through the list of accounts
 *	for every savings account calculate the interest and deposit it to the
 *		account
 *
 *ELSE IF (user enters 'exit')
 *	open new output stream
 *	loop throught list of accounts
 *	write each account to the accounts text file
 *	end program after closing streams
 *****************************/

//IMPORTS
import java.util.*;
import javax.swing.*; //does joptionpane count as gui's?
						//if not I used 4 other items on the list.
import java.io.*;

public class Driver
{
	public static void main(String[] args)
	{
		//Variables:
		String command = "";
		
		//Objects:
		ArrayList<Account> records = new ArrayList<>(5);
		Scanner keyboard = new Scanner(System.in);
		Scanner inputStream = null;
		PrintWriter outputStream = null;
		
		menu();
		while(true)
		{
			try
			{
				System.out.print("\nPlease enter a command: ");
				command = keyboard.nextLine();
				
				//create an account
				if(command.equalsIgnoreCase("create"))
				{
					String accountType = "";
					
					System.out.print("\nWhat type of account would you like to open? (Savings/Checking): ");
					accountType = keyboard.nextLine();
					
					try
					{
						if(accountType.equalsIgnoreCase("savings"))
						{
							Savings account = new Savings();
							account.setAll();
							records.add(account);
						}
						else if(accountType.equalsIgnoreCase("checking"))
						{
							Checking account = new Checking();
							account.setAll();
							records.add(account);
						}
						else
						{
							throw new UnknownCommandException("Error, unknown account type..."); 
						}
					}
					catch(UnknownCommandException e)
					{
						System.out.println(e.getMessage());
					}
				}
				//delete an account
				else if(command.equalsIgnoreCase("delete"))
				{
					int pin = 0;
					
					pin = Integer.parseInt((String)JOptionPane.showInputDialog("Please enter your pin # for the accounts you would like to close:"));
					
					for(Account index : records)
					{
						if(index.getPin() == pin)
						{
							records.remove(index);
						}
					}
					
					System.out.println("\nYour account has been closed...");
				}
				//check balance of accounts
				else if(command.equalsIgnoreCase("balance"))
				{
					int pin = 0;
					
					pin = Integer.parseInt((String)JOptionPane.showInputDialog("Please enter your pin # to check the balance of all your accounts:"));
					
					for(Account index : records)
					{
						if(index.getPin() == pin)
						{
							System.out.println(index);
						}
					}
				}
				//deposit money to an account
				else if(command.equalsIgnoreCase("deposit"))
				{
					int pin = 0;
					int accountNum = 0;
					double amount = 0;
					
					accountNum = Integer.parseInt((String)JOptionPane.showInputDialog("Please enter your account number:"));
					
					pin = Integer.parseInt((String)JOptionPane.showInputDialog("Please verify your 4 digit pin number:"));
					
					amount = Double.parseDouble((String)JOptionPane.showInputDialog("How much would you like to deposit:"));
					
					for(Account index : records)
					{
						if(index.getAccountNum() == accountNum && index.getPin() == pin)
						{
							index.deposit(amount);
							break;
						}
					}
					
					System.out.println("The funds have been added to your account...");
				}
				//withdraw money from an account
				else if(command.equalsIgnoreCase("withdraw"))
				{
					int pin = 0;
					int accountNum = 0;
					double amount = 0;
					
					accountNum = Integer.parseInt((String)JOptionPane.showInputDialog("Please enter your account number:"));
					
					pin = Integer.parseInt((String)JOptionPane.showInputDialog("Please verify your 4 digit pin number:"));
					
					amount = Double.parseDouble((String)JOptionPane.showInputDialog("How much would you like to withdraw:"));
					
					for(Account index : records)
					{
						if(index.getAccountNum() == accountNum && index.getPin() == pin)
						{
							index.withdraw(amount);
							break;
						}
					}
					
					System.out.println("The funds have been withdrawn from your account...");
				}
				//transfer money between accounts
				else if(command.equalsIgnoreCase("transfer"))
				{
					int pin;
					int accountNum, accountNum2;
					double amount;
					
					accountNum = Integer.parseInt((String)JOptionPane.showInputDialog("Please enter your account number:"));
					
					pin = Integer.parseInt((String)JOptionPane.showInputDialog("Please verify your 4 digit pin number:"));
					
					amount = Double.parseDouble((String)JOptionPane.showInputDialog("How much would you like to transfer:"));
					
					accountNum2 = Integer.parseInt((String)JOptionPane.showInputDialog("Please enter the account number you would like to transfer to:"));
					
					for(Account index : records)
					{
						if(accountNum == index.getAccountNum() && pin == index.getPin())
						{
							index.withdraw(amount);
						}
						else if(accountNum2 == index.getAccountNum())
						{
							index.deposit(amount);
						}
					}
					
					System.out.println("The funds have been transfered...");
				}
				//issue intrest for savings accounts
				else if(command.equalsIgnoreCase("collect"))
				{
					double fee = 0;
					Checking current = null;
					
					System.out.println("\nCollecting annual fees for all checking accounts...\n");
					
					for(Account index : records)
					{
						if(index.getClass().equals("Checking"))
						{
							current = (Checking)index;
							fee = current.getAnnualFee();
							
							index.withdraw(fee);
						}
					}
				}
				//collect annual fee's from checking accounts
				else if(command.equalsIgnoreCase("Pay"))
				{
					Savings current = null;
					
					System.out.println("\nDestributing interest earnings to all savings accounts...\n");
					
					for(Account index : records)
					{
						if(index.getClass().equals("Savings"))
						{
							current = (Savings)index;
							
							index.deposit(Savings.calculateInterest(current));
						}
					}
				}
				//exit program and write to file
				else if(command.equalsIgnoreCase("exit"))
				{
					System.out.println("Saving all account information...");
					
					try
					{
						outputStream = new PrintWriter(new FileOutputStream("acccounts"));
					}
					catch(FileNotFoundException e)
					{
						System.out.println(e.getMessage());
					}
					catch(Exception e)
					{
						System.out.println(e.getMessage());
					}
					for(Account index : records)
					{
						outputStream.println(index + "\n");
					}
					break;
				}
				//invalid command
				else
				{
					throw new UnknownCommandException();
				}
			}
			catch(UnknownCommandException e)
			{
				System.out.println("Error! You entered: " + command);
				System.out.println(e.getMessage());
			}
		}
		//clean up.
		outputStream.close();
		keyboard.close();
	}
	public static void menu()
	{
		System.out.println("====Commands====");
		System.out.println("- Create");
		System.out.println("- Delete");
		System.out.println("- Balance");
		System.out.println("- Deposit");
		System.out.println("- Withdraw");
		System.out.println("- Transfer");
		System.out.println("- Collect");
		System.out.println("- Pay");
		System.out.println("- Exit");
		System.out.println("================\n");
	}
}