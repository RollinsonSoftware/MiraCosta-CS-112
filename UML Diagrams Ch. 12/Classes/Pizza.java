public class Pizza
{
	private boolean sausage;
	private boolean pepperoni;
	private boolean mushrooms;
	private char size;
	
	//CONSTUCTORS
	public Pizza()
	{
		setAll(false, false, false, 's');
	}
	public Pizza(boolean sausage, boolean pepperoni, boolean mushrooms, char size)
	{
		setAll(sausage, pepperoni, mushrooms, size);
	}
	//OTHERS
	public String toString()
	{
		String temp = "";
		
		if(this.size == 's')
		{
			temp = "Small";
		}
		else if(this.size == 'm')
		{
			temp = "Medium";
		}
		else if(this.size == 'l')
		{
			temp = "Large";
		}
		
		return temp + " pizza w/ Sausage: " + getSausage() + ", Pepperoni: " + getPepperoni() + ", Mushrooms: " + getMushrooms();
	}
	public boolean equals(Pizza other)
	{
		if(this.getSize() == other.getSize())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	//SETTERS
	public void setAll(boolean sausage, boolean pepperoni, boolean mushrooms, char size)
	{
		setSausage(sausage);
		setPepperoni(pepperoni);
		setMushrooms(mushrooms);
		setSize(size);
	}
	public void setSausage(boolean b)
	{
		this.sausage = b;
	}
	public void setPepperoni(boolean b)
	{
		this.pepperoni = b;
	}
	public void setMushrooms(boolean b)
	{
		this.mushrooms = b;
	}
	public void setSize(char size)
	{	
		if(size == 's')
		{
			this.size = size;
		}
		else if(size == 'm')
		{
			this.size = size;
		}
		else if(size == 'l')
		{
			this.size = size;
		}
		else
		{
			System.out.println("\nError, invalid size...\n");
			System.exit(0);
		}
	}
	//GETTERS
	public boolean getSausage()
	{
		return this.sausage;
	}
	public boolean getPepperoni()
	{
		return this.pepperoni;
	}
	public boolean getMushrooms()
	{
		return this.mushrooms;
	}
	public char getSize()
	{
		return this.size;
	}
	public int getNumToppings()
	{
		int toppings = 0;
		
		if(getSausage())
		{
			toppings++;
		}
		if(getPepperoni())
		{
			toppings++;
		}
		if(getMushrooms())
		{
			toppings++;
		}
		return toppings;
	}
}