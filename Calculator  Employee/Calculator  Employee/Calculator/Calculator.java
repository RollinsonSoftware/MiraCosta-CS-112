public class Calculator
{
	private double result;
	
	public Calculator()
	{
		this.result = 0;
	}
	public String toString()
	{
		return "The current result is: " + this.result;
	}
	public double clear()
	{
		return this.result = 0;
	}
	public double add(double number)
	{
		return this.result += number;
	}
	public double subtract(double number)
	{
		return this.result -= number;
	}
	public double multiply(double number)
	{
		return this.result *= number;
	}
	public double divide(double number)
	{
		return this.result /= number;
	}
	public double getResult()
	{
		return this.result;
	}
}