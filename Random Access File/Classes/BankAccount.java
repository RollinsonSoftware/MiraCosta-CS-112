public class BankAccount
{
	private int accountNum;
	private double balance;
	private String firstName, lastName;
	
	//CONSTRUCTORS
	public BankAccount()
	{
		setAll(0, 0, "Leroy", "Jenkins");
	}
	public BankAccount(int accountNum, double balance, String firstName, String lastName)
	{
		setAll(accountNum, balance, firstName, lastName);
	}
	public BankAccount(BankAccount other)
	{
		setAll(other.accountNum, other.balance, other.firstName, other.lastName);
	}
	//SETTERS
	public void setAll(int accountNum, double balance, String firstName, String lastName)
	{
		setAccountNum(accountNum);
		setBalance(balance);
		setFirstName(firstName);
		setLastName(lastName);
	}
	public void setAccountNum(int accountNum)
	{
		this.accountNum = accountNum;
	}
	public void setBalance(double balance)
	{
		this.balance = balance;
	}
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	//GETTERS
	public int getAccountNum()
	{
		return this.accountNum;
	}
	public double getBalance()
	{
		return this.balance;
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
	public String toString()
	{
		return "\n" + getFirstName() + " " + getLastName() + "'s account information:\n" +
				"Account #: " + getAccountNum() + "\n" +
				"Account Balance: " + getBalance() + "\n";
	}
	public boolean equals(BankAccount other)
	{
		if(this.accountNum == other.accountNum &&
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