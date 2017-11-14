//IMPORTS:
import java.util.*;

public class MyMathClass<T extends Number>
{	
	private ArrayList<T> list;
	
	public MyMathClass(ArrayList<T> list)
	{
	}
	
	//The book provided an algorithm on how to compute the standard deviation
	
	public double standardDeviation(ArrayList<T> array)
	{
		double a = 0;
		double result = 0;
		
		for(T object : array) //totaling all values in ArrayList
		{
			a += object.doubleValue();
		}
		
		a = (a / array.size()); //finding the average of the ArrayList
		
		for(T object : array)
		{
			result += Math.pow((object.doubleValue() - a), 2); //finding deviation average
		}
		
		result = (result / array.size());
		result = Math.sqrt(result); //finding standard deviation
		
		return result;
	}
}