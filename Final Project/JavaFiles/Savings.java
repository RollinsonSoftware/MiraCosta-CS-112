public class Savings extends Account
{
	private double interest;
	
	//CONSTRUCTOR
	public Savings()
	{
		super();
		setInterest(0.2);
	}
	//SETTERS
	public void setInterest(double interestRate)
	{
		this.interest = interestRate;
	}
	//GETTERS
	public double getInterest()
	{
		return this.interest;
	}
	//OTHER
	public boolean equals(Savings other)
	{
		if(this.getInterest() == other.getInterest() && super.equals(other))
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
		return "\nSavings Account:\n" + super.toString() + "\nInterest Rate: " + getInterest();
	}
	public static double calculateInterest(Savings account)
	{
		return account.getBalance() * (1 + account.getInterest() * 12);
	}
}