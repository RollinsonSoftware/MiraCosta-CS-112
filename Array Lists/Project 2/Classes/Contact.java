import java.util.Scanner;

public class Contact
{
	private String email, phone, firstName, lastName;
	
	Scanner keyboard = new Scanner(System.in);
	
	//CONSTRUCTORS
	public Contact()
	{
		this.email = "defualt@gmail.com";
		this.firstName = "Hugh";
		this.lastName = "Munguss";
		this.phone = "(760)-123-4567";
	}
	//SETTERS
	public void setAll()
	{
		System.out.println("What is your email address?");
		setEmail();
		System.out.println("What is your phone number?");
		setPhone();
		System.out.println("What is your first name?");
		setFirstName();
		System.out.println("What is your last name?");
		setLastName();
	}
	public void setEmail()
	{
		System.out.print("\nEnter your email: ");
		this.email = keyboard.nextLine();
		System.out.println();
	}
	public void setPhone()
	{
		System.out.print("\nEnter your phone #: ");
		this.phone = keyboard.nextLine();
		System.out.println();
	}
	public void setFirstName()
	{
		System.out.print("\nEnter your first name: ");
		this.firstName = keyboard.nextLine();
		System.out.println();
	}
	public void setLastName()
	{
		System.out.print("\nEnter your last name: ");
		this.lastName = keyboard.nextLine();
		System.out.println();
	}
	//GETTERS
	public String getEmail()
	{
		return this.email;
	}
	public String getPhone()
	{
		return this.phone;
	}
	public String getFirstName()
	{
		return this.firstName;
	}
	public String getLastName()
	{
		return this.lastName;
	}
	//OTHER
	public boolean equals(Contact other)
	{
		if(this.email.equalsIgnoreCase(other.email) &&
			this.phone.equalsIgnoreCase(other.phone) &&
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
	public String toString()
	{
		return "Contact Info:\nFirst Name: " + getFirstName() + "\nLast Name: " + getLastName() + "\nPhone Number: " + getPhone() + "\nEmail Address: " + getEmail();
	}
	public static void menu()
	{
		System.out.println("\nCommands:");
		System.out.println("'add' Adds a contact to the list.");
		System.out.println("'view' Displays all contacts in the list.");
		System.out.println("'search' Search for a single contact.");
		System.out.println("'delete' Search for a contact and delete it.");
		System.out.println("'exit' Closes the program.\n");
	}
}