import java.util.Scanner;

public class Employee
{
	private String firstName;
	private String lastName;
	private double monthlySalary;
	private double bonusAmount;
	private int years;
	
	Scanner keyboard = new Scanner(System.in);
	
	//CONSTRUCTORS
	public Employee()
	{
		this.firstName = "Default";
		this.lastName = "User";
		this.monthlySalary = 1;
		this.bonusAmount = 0;
		this.years = 0;
	}
	//SETTERS
	public void setAll() //This is the only public setter, it does all the work!
	{
		setFirstName();
		setLastName();
		setMonthlySalary();
		setBonusAmount();
		setYears();
	}
	private void setFirstName()
	{
		System.out.print("\nWhat is the new employees first name?: ");
		this.firstName = keyboard.nextLine();
	}
	private void setLastName()
	{
		System.out.print("\nWhat is " + this.getFirstName() + "'s last name?: ");
		this.lastName = keyboard.nextLine();
	}
	private void setMonthlySalary()
	{
		System.out.print("\nWhat is " + this.getFirstName() + "'s starting salary?: ");
		this.monthlySalary = keyboard.nextDouble();
		keyboard.nextLine();
	}
	private void setBonusAmount()
	{
		System.out.print("\nWhat is " + this.getFirstName() + "'s bonus amount?: ");
		this.bonusAmount = keyboard.nextDouble();
		keyboard.nextLine();
	}
	private void setYears()
	{
		System.out.print("\nHow many years has " + this.getFirstName() + " been working here?: ");
		this.years = keyboard.nextInt();
		keyboard.nextLine();
	}
	//GETTERS (all public)
	public String getFirstName()
	{
		return this.firstName;
	}
	public String getLastName()
	{
		return this.lastName;
	}
	public double getMonthlySalary()
	{
		return this.monthlySalary;
	}
	public double getBonusAmount()
	{
		return this.bonusAmount;
	}
	public int getYears()
	{
		return this.years;
	}
	//OTHER
	public boolean equals(Employee other)
	{
		if(this.getFirstName().equalsIgnoreCase(other.getFirstName())
			&& this.getLastName().equalsIgnoreCase(other.getLastName())
			&& this.getMonthlySalary() == other.getMonthlySalary()
			&& this.getBonusAmount() == other.getBonusAmount()
			&& this.getYears() == other.getYears())
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
		return "First Name: " + this.getFirstName() + "\nLast Name: " + this.getLastName() + "\nMonthly Salary: $" + this.getMonthlySalary() + "\nBonus Amount: $" + this.getBonusAmount() + "\nYears of Service: " + this.getYears();
	}
	public void printNode() //this is just a start, we can make it look good with printf later.
	{
		System.out.println(" =========================== ");
		System.out.println("|First Name: " + this.getFirstName() + "|");
		System.out.println("|Last Name: " + this.getLastName() + "|");
		System.out.println("|Monthly Salary: $" + this.getMonthlySalary() + "|");
		System.out.println("|Bonus Amount: $" + this.getBonusAmount() + "|");
		System.out.println("|Years of Service: " + this.getYears() + "|");
		System.out.println(" =========================== ");
	}
}