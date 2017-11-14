/*****************************
 *CHAPTER NUMBER: 13 Interfaces and Inner Classes
 *FILE NAME: Book Project 2
 *PROGRAMMER: Jack Rollinson
 *DATE LAST MODIFIED: 11/10/2016
 *
 *====PROBLEM======
 *After creating the inventory item class, create a driver class to test the
 *inventory item class. create an array of type InventoryItem and sort the objects
 *based on their ID numbers, create a method to sort the array that takes as
 *input an array of type comparable.
 *
 *====ALGORITHM====
 *Loop to fill the array full of object of type inventory item.
 *	if the user enters "done" then break the loop.
 *For Loop
 *	Display the contents of the entire array using the objects toString()
 *Loop to print the Id numbers before sorting.
 *Call the sort() method to sort the array.
 *Loop to print the Id numbers after sorting.
 *
 *NO ALGORITHM FOR THE STATIC SORTING METHODS BECAUSE THEY ARE FROM THE BOOK!
 *****************************/
import java.util.Scanner;

public class Driver
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		InventoryItem[] stack = new InventoryItem[1000];
		
		String name = "";
		int index = 0;
		
		while(true)
		{
			System.out.print("Enter item name: ");
			name = keyboard.nextLine();
			
			if(name.equalsIgnoreCase("done"))
			{
				break;
			}
			else
			{
				stack[index] = new InventoryItem(name);
			}
			index++;
		}
		
		System.out.println("\nAll items have been added to the array!");
		System.out.println("\nContents of array:");
		
		for(int i = 0; i < stack.length; i++)
		{
			if(stack[i] != null)
			{
				System.out.println(stack[i]);
			}
		}
		
		System.out.println("\nItem ID #'s before sorting:");
		printArray(stack);
		
		System.out.println("\nItem ID #'s after sorting:");
		sort(stack, stack.length);
		printArray(stack);
		System.out.println();
		
		keyboard.close();
	}
	public static void printArray(InventoryItem[] array)
	{
		for(int i = 0; i < array.length; i++)
		{
			if(array[i] != null)
			{
				System.out.print(array[i].getUniqueItemID() + ", ");
			}
		}
		System.out.println();
	}
	public static void sort(Comparable[] a, int numberUsed)
	{
		int index, indexOfNextSmallest;
		
		for(index = 0; index < numberUsed - 1; index++)
		{
			if(a[index] != null)
			{
				indexOfNextSmallest = indexOfSmallest(index, a, numberUsed);
				interchange(index, indexOfNextSmallest, a);
			}
		}
	}	
	private static int indexOfSmallest(int startIndex, Comparable[] a, int numberUsed)
	{
		Comparable min = a[startIndex];
		int indexOfMin = startIndex;
		int index;
		
		for(index = startIndex + 1; index < numberUsed; index++)
		{
			if(a[index] != null)
			{
				if(a[index].compareTo(min) < 0)
				{
					min = a[index];
					indexOfMin = index;
				}
			}
			else
			{
				continue;
			}
		}
		return indexOfMin;
	}
	private static void interchange(int i, int j, Comparable[] a)
	{
		Comparable temp;
		temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}