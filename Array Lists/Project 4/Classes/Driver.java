/*****************************
 *CHAPTER NUMBER: 14 ArrayLists and Generics
 *FILE NAME: Book Project 4
 *PROGRAMMER: Jack Rollinson
 *DATE LAST MODIFIED: 11/15/2016
 *
 *====PROBLEM======
 *Write a generic class, MyMathClass with type parameter T where T is a numeric
 *object of the java.lang.Number. Add a method named standardDeviation() that takes
 *an ArrayList. Using the doubleValue() method in the Number class compute the
 *standard deviation of the ArrayList.
 *
 *====ALGORITHM====
 *Create and array list of type Double or type Integer
 *Fill the array list
 *Use a for-each loop to display contents of the array list
 *Calculate the standard deviation using the method in MyMathClass
 *
 *****************************/
 //IMPORTS:
import java.util.*;

public class Driver
{
	public static void main(String[] args)
	{
		ArrayList<Double> list = new ArrayList<Double>();
		
		//Book only asked for a basic test of the standardDeviation() method
		//But these numbers could have been aquired from the user with Scanner.
		
		list.add(300.2); 
		list.add(40.4);
		list.add(500.5);
		list.add(6000.7);
		
		MyMathClass calling = new MyMathClass(list);
		
		System.out.println("The numbers in the list are: ");
		for(Double object : list)
			System.out.println(object);
			
		System.out.println("The standard deviation of the numbers = " + calling.standardDeviation(list));
	}
}