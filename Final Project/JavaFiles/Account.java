//IMPORTS
import java.util.*;

public class Account
{
	Scanner keyboard = new Scanner(System.in);
	
	private int pin;
	private int accountNum;
	private double balance;
	private String firstName;
	private String lastName;

	
	//CONSTRUCTORS:
	public Account()
	{
		setBalance(0);
		this.pin = 1111;
		this.accountNum = 111111111;
		this.firstName = "Defualt";
		this.lastName = "Name";
	}
	//SETTERS:
	
	//use this method after using the default constructor
	public void setAll()
	{
		setName();
		setPin();
		setAccountNum();
		System.out.println("Your account has been set up!");
	}
	protected void setBalance(double num)
	{
		this.balance = num;
	}
	//Sets both the first and last name in one method
	private void setName()
	{
		System.out.print("\nPlease enter your first name: ");
		this.firstName = keyboard.nextLine();
		System.out.print("\nPlease enter your last name: ");
		this.lastName = keyboard.nextLine();
	}
	//lets the user select a pin, but makes sure its only 4 digits
	private void setPin() 
	{
		int temp = 0;
		
		do
		{	
			System.out.print("\nPlease enter a four digit pin number: ");
			temp = keyboard.nextInt();
			keyboard.nextLine();
			
			if(temp < 1000 || temp > 9999)
			{
				System.out.println("Your pin number can only be 4 digits long, try again!");
			}
			else
			{
				System.out.println("Your pin has been set.");
				this.pin = temp;
			}
		}while(temp < 1000 || temp > 9999);
	}
	//Randomly generates an account number for the user.
	private void setAccountNum()
	{
		Random num =  new Random();
		
		System.out.println("\nGenerating your account number...");
		this.accountNum = num.nextInt(9000000) + 1000000;
	}
	//GETTERS:
	public String getFirstName()
	{
		return this.firstName;
	}
	public String getLastName()
	{
		return this.lastName;
	}
	public int getAccountNum()
	{
		return this.accountNum;
	}
	public int getPin()
	{
		return this.pin;
	}
	public double getBalance()
	{
		return this.balance;
	}
	//OTHER METHODS:
	
	//subtracts the amount from one account and adds it to another.
	public void transfer(double amount, Account other) 
	{
		if(this.getBalance() <= amount)
		{
			this.withdraw(amount);
			other.deposit(amount);
			System.out.println("\nTransfer complete!");
		}
		else
		{
			System.out.println("Im sorry " + this.firstName + ", the amount you wish to transfer exceeds your account balance!");
		}
	}
	//withdraw & deposit methods
	public void deposit(double amount)
	{
		this.setBalance(this.getBalance() + amount);
	}
	public void withdraw(double amount)
	{
		this.setBalance(this.getBalance() - amount);
	}
	//outputs everything except for the pin number (that would be bad)
	public String toString()
	{
		return "Name: " + getFirstName() + " " + getLastName() + "\nAccount Number: " + getAccountNum() + "\nCurrent Balance: " + getBalance();
	}
	public boolean equals(Account other) //checks if two accounts are the same
	{
		if(this.pin == other.pin &&
		   this.accountNum == other.accountNum &&
		   this.balance == other.balance &&
		   this.firstName.equalsIgnoreCase(other.firstName) &&
		   this.lastName.equalsIgnoreCase(other.lastName))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}