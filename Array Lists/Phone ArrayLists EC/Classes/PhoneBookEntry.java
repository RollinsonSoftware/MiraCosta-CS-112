import java.util.Scanner;

public class PhoneBookEntry
{
	private String name;
	private String phone;
	private String major;
	
	Scanner keyboard = new Scanner(System.in);
	
	//CONSTRUCTORS
	public PhoneBookEntry()
	{
		this.name = "Default";
		this.phone = "(760)-402-9528";
		this.major = "Computer Science";
	}
	//SETTERS
	public void setAll()
	{
		setName();
		setPhone();
		setMajor();
	}
	private void setName()
	{
		System.out.print("\nEnter your name: ");
		this.name = keyboard.nextLine();
	}
	private void setPhone()
	{
		System.out.print("\nEnter your phone number: ");
		this.phone = keyboard.nextLine();
	}
	private void setMajor()
	{
		System.out.print("\nEnter your major: ");
		this.major = keyboard.nextLine();
	}
	//GETTERS
	public String getName()
	{
		return this.name;
	}
	public String getPhone()
	{
		return this.phone;
	}
	public String getMajor()
	{
		return this.major;
	}
	//OTHER
	public boolean equals(PhoneBookEntry other)
	{
		if(this.getName().equalsIgnoreCase(other.getName())
			&& this.getPhone().equalsIgnoreCase(other.getPhone())
			&& this.getMajor().equalsIgnoreCase(other.getMajor()))
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
		return "Name: " + this.getName() + "\nPhone #: " + this.getPhone() + "\nMajor: " + this.getMajor();
	}
}