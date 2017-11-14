/*****************************
 *CHAPTER NUMBER: 12 UML EXTRA CREDIT
 *FILE NAME: Book Project 8
 *PROGRAMMER: Jack Rollinson
 *DATE LAST MODIFIED: 10/27/2016
 *
 *====PROBLEM======
 *Driver to test the modifications given for programming projects 12.6 and 12.7
 *Eliminate the calls to join() because it does nothing.
 *Added code for a special case if the array has a length of 2 and if the array
 *	has a length of 1.
 *Made the base case if the array has a length of 3 or more.
 *Corrected how the class chooses a splitting point to better avoid uneven
 *	splitting of the array.
 *
 *====ALGORITHM====
 *This tester was from the book, but I added a few modifications.
 *	Added a second array to test the special case with an array length of 2.
 *	Added error catching for array indexs out of bounds.
 *	Added a static method to print the arrays cleanly.	
 *	
 *****************************/
public class Driver
{
	public static void main(String[] args)
	{
		double[] a = {5, 4};
		double[] b = {7.7, 5.5, 11, 3, 16, 4.4, 20, 14, 13, 42};
		
		System.out.println("Array A contents before sorting:\n");
		print(a);
		System.out.println("\nArray B contents before sorting:\n");
		print(b);
		
		try
		{
			QuickSort.sort(a, 0, a.length);
			QuickSort.sort(b, 0, b.length - 1);
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Error, index out of bounds, stopping program...");
			System.exit(0);
		}
		
		System.out.println("\nSorted A array values:\n");
		print(a);
		System.out.println("\nSorted B array values:\n");
		print(b);
	}
	public static void print(double[] array)
	{
		for(int i = 0; i < array.length; i++)
		{
			System.out.print(array[i] + ", ");
		}
		System.out.println();
	}
}