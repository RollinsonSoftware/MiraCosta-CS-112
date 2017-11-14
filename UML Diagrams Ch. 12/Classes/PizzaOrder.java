public class PizzaOrder
{
	public static final int SMALL = 8;
	public static final int MEDIUM = 10;
	public static final int LARGE = 12;
	
	private static Pizza[] orders = new Pizza[100];
	private static int numPizzas = 0;
	
	public static void addPizzaToOrder(boolean sausage, boolean pepperoni, boolean mushrooms, char size)
	{
		Pizza current = new Pizza(sausage, pepperoni, mushrooms, size);
		
		for(int i = 0; i < orders.length; i++)
		{
			if(orders[i] == null)
			{
				orders[i] = current;
				break;
			}
			else
			{
				continue;
			}
		}
		numPizzas++;
	}
	public static double calcCost()
	{
		double cost = 0;
		
		for(int i = 0; i < orders.length; i++)
		{
			if(orders[i] != null)
			{
				if(orders[i].getSize() == 's')
				{
					cost += SMALL + orders[i].getNumToppings();
					continue;
				}
				else if(orders[i].getSize() == 'm')
				{
					cost += MEDIUM + orders[i].getNumToppings();
					continue;
				}
				else if(orders[i].getSize() == 'l')
				{
					cost += LARGE + orders[i].getNumToppings();
					continue;
				}
			}
			else
			{
				continue;
			}
		}
		return cost;
	}
	public static void printOrder()
	{
		for(int i = 0; i < orders.length; i++)
		{
			if(orders[i] != null)
			{
				System.out.println(orders[i] + "\n");
			}
			else
			{
				continue;
			}
		}
	}
	public static void clearOrder()
	{
		for(int i = 0; i < orders.length; i++)
		{
			orders[i] = null;
		}
	}
}