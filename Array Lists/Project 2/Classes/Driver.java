/*****************************
 *CHAPTER NUMBER: 14 ArrayLists and Generics
 *FILE NAME: Book Project 2
 *PROGRAMMER: Jack Rollinson
 *DATE LAST MODIFIED: 11/10/2016
 *
 *====PROBLEM======
 *Write a program that uses an array list to store objects of the class contact.
 *The driver should present a menu, and ask the user if they want to add, view all
 *search a specific contact or delete a contact. When search, the program 
 *should ask for one search term that will be compared to all the instance variables.
 *
 *====ALGORITHM====
 *While loop that always runs
 *display command menu before asking for a command (everytime)
 *If command = add
 *	make a new contact object, and call the setAll() method
 *	add the new contact to the array list.
 *Else If command = view
 *	use a 'for-each' loop to print out the contents of the entire array list
 *Else If command = search
 *	ask user for search term in the form of a string
 *	compare the string to all instance variables of all objects in the array list
 *	print the contact if a match is found
 *		else
 *			no contact was found, so tell the user!
 *Else If command = delete
 *	ask the for search term in the form of a string
 *	compare the string to all instance variables of all objects in the array list
 *	delete all contacts that contain the search term.
 *Else If command = exit
 *	closes keyboard stream
 *	ends the program
 *Else
 *	Tell user to enter a valid command.
 *****************************/
import java.util.*;

public class Driver
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		ArrayList<Contact> list = new ArrayList<>(20);
		String command;
		
		while(true)
		{
			Contact.menu();
			System.out.print("\nPlease enter a command: ");
			command = keyboard.nextLine();
			
			if(command.equalsIgnoreCase("add"))
			{
				Contact temp = new Contact();
				temp.setAll();
				list.add(temp);
			}
			else if(command.equalsIgnoreCase("view"))
			{
				System.out.println();
				
				for(Contact index : list)
				{
					System.out.println(index + "\n");
				}
			}
			else if(command.equalsIgnoreCase("search"))
			{
				String search;
				
				System.out.print("\nPlease enter a search term: ");
				search = keyboard.nextLine();
				
				for(Contact index : list)
				{
					if(search.equalsIgnoreCase(index.getFirstName()) ||
						search.equalsIgnoreCase(index.getLastName()) ||
						search.equalsIgnoreCase(index.getPhone()) ||
						search.equalsIgnoreCase(index.getEmail()))
					{
						System.out.println("\n" + index);
						break;
					}
				}
				System.out.println("That contact does not exist!");
			}
			else if(command.equalsIgnoreCase("delete"))
			{
				String search;
				
				System.out.print("\nPlease enter a search term: ");
				search = keyboard.nextLine();
				
				for(Contact index : list)
				{
					if(search.equalsIgnoreCase(index.getFirstName()) ||
						search.equalsIgnoreCase(index.getLastName()) ||
						search.equalsIgnoreCase(index.getPhone()) ||
						search.equalsIgnoreCase(index.getEmail()))
					{
						list.remove(index);
						break;
					}
				}
				System.out.println("Contact removed...");
			}
			else if(command.equalsIgnoreCase("exit"))
			{
				keyboard.close();
				System.exit(0);
			}
			else
			{
				System.out.println("\nPlease enter a valid command, try again...\n");
			}
		}
	}
}