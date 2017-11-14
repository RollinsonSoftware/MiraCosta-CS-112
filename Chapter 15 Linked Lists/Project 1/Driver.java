/**
 *Name: Jack Rollinson
 *Homework: Princess Suitor Selection Program
 *Date: 11/29/2016
 *Date of Last Worked On: 11/29/2016
 *************************************************
 *OBJECTIVE:
 *	This program tests the DoublyLinkedList class. This linked lists will calculate
 *what suitor is correct for our fair princess
 *************************************************
 *ALGORITHM:
 *Ask user for names of the suiters
 *inster the suiters into the list as they are given
 *when the user enters "done" stop asking for suiters
 *move through the list and remove every third item
 *when the end of the list is reached, move the iterator back to the begining
 *repeat this process until only one suiter is remaining in the list
 *output the chosen one to the user.
 *************************************************
 */
import java.util.Scanner;

public class Driver
{
	public static void main(String[] args)
	{
		DoublyLinkedList list = new DoublyLinkedList();
		DoublyLinkedList.DoublyLinkedIterator x = list.iterator();
		Scanner keyboard = new Scanner(System.in);
		
		String temp;
		int count = 0;
		
		System.out.println("Please add some suitors to the list, enter 'done' to stop.");
		
		while(true)
		{
			System.out.print("\nPlease enter the name of suitor #" + (count + 1) + ": ");
			temp = keyboard.nextLine();
			
			if(temp.equalsIgnoreCase("done"))
			{
				break;
			}
			
			list.addToStart(temp);
			count++;
		}
		printList(list, x);
		System.out.println("Now its time to find the lucky man!");
		
		System.out.println("\nAnd the last man standing is: ");	
		x.restart();
		System.out.println("Suitor #" + 1 + " " + x.next());
	
		

	}
	public static void printList(DoublyLinkedList list, DoublyLinkedList.DoublyLinkedIterator x)
	{
		System.out.println("\nThe list of suitors in order are:");
		x.restart();
		int counter = 0;
		
		while(x.hasNext())
		{
			System.out.println("Suitor #" + (counter + 1) + " " + x.next());
			counter++;
		}
		System.out.println();
	}
	public static void remove(DoublyLinkedList list, DoublyLinkedList.DoublyLinkedIterator x)
	{		
		for(int i = 0; i < 2; i++)
		{
			x.next();
		}
		x.delete();
	}
}