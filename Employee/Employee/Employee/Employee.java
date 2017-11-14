public class Employee extends Person
{
	private String ssn;
	private double salary;
	private boolean average; //salary above/below average
	
	public Employee()
	{
		super("John Rollinson", new Date(1, 1, 2016), null);
		setAll("123456789", 0.0);
	}
	public Employee(String name, int month, int day, int year, String ssn, double salary)
	{
		super(name, new Date(month, day, year), null);
		setAll(ssn, salary);
	}
	public String toString()
	{
		return "Employee Name: " + getName() +
				"\nEmployee SSN: " + getSSN() + 
				"\nEmployee Salary: $" + getSalary() +
				"\nPaid above average? " + getAverage(); 
	}
	public boolean equals(Employee other)
	{
		if(this.ssn.equals(other.ssn))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	//SETTERS
	public void setAll(String ssn, double salary)
	{
		setSSN(ssn);
		setSalary(salary);
	}
	public void setSSN(String ssn)
	{	
		this.ssn = ssn;
	}
	public void setSalary(double salary)
	{
		this.salary = salary;
	}
	public void setAverage()
	{
		if(this.salary >= 100000)
		{
			this.average = true;
		}
		else
		{
			this.average = false;
		}
	}
	//GETTERS
	public String getSSN()
	{
		return this.ssn;
	}
	public double getSalary()
	{
		return this.salary;
	}
	public boolean getAverage()
	{
		return this.average;
	}
}