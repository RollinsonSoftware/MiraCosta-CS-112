public class InventoryItem implements Comparable
{
	private String name;
	private int uniqueItemID;
	
	//CONSTRUCTORS
	public InventoryItem()
	{
		setAll("Defualt Item");
	}
	public InventoryItem(String name)
	{
		setAll(name);
	}
	//SETTERS
	public void setAll(String name)
	{
		setName(name);
		setUniqueItemID();
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public void setUniqueItemID()
	{
		this.uniqueItemID = (int)(Math.random() * 50 + 1);
	}
	public void setUniqueItemID(int ID)
	{
		this.uniqueItemID = ID;
	}
	//GETTERS
	public String getName()
	{
		return this.name;
	}
	public int getUniqueItemID()
	{
		return this.uniqueItemID;
	}
	//OTHER
	public String toString()
	{
		return "Item Name: " + getName() + ", Item ID# " + getUniqueItemID();
	}
	public boolean equals(InventoryItem other)
	{
		if(this.getName().equalsIgnoreCase(other.getName())
			&& this.getUniqueItemID() == other.getUniqueItemID())
		{
			return true;	
		}
		else
		{
			return false;
		}
	}
	public int compareTo(Object other)
	{
		int result = 0;
		InventoryItem temp = (InventoryItem)other;
		
		if(this.getUniqueItemID() < temp.getUniqueItemID())
		{
			result = -1;
		}
		else if(this.getUniqueItemID() == temp.getUniqueItemID())
		{
			result = 0;
		}
		else if(this.getUniqueItemID() > temp.getUniqueItemID())
		{
			result = 1;
		}
		return result;
	}
}