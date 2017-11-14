public class Checking extends Account
{
	private double annualFee;
	
	//CONSTRUCTORS
	public Checking()
	{
		super();
		setAnnualFee(25.00);
	}
	//SETTERS
	public void setAnnualFee(double newAnnualFee)
	{
		this.annualFee = newAnnualFee;
	}
	//GETTERS
	public double getAnnualFee()
	{
		return this.annualFee;
	}
	//OTHER
	public boolean equals(Checking other)
	{
		if(super.equals(other) && this.getAnnualFee() == other.getAnnualFee())
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
		return "\nChecking Account:\n" + super.toString() + "\nAnnual Fee Rate: " + this.getAnnualFee();
	}
	//collects the annualFee
	public void deductAnnualFee()
	{
		System.out.println("Your current Annual Fee Rate is: " + getAnnualFee());
		
		this.setBalance(this.getBalance() - this.getAnnualFee());
		
		System.out.println("Your new Account Balance is: " + this.getBalance());
	}
}	