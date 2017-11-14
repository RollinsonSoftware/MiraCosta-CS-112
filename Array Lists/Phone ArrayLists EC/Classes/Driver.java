/*****************************
 *CHAPTER NUMBER: ArrayLists Extra Credit
 *FILE NAME: Extra Credit
 *PROGRAMMER: Jack Rollinson
 *DATE LAST MODIFIED: 11/21/2016
 *
 *====PROBLEM======
 *Write a class named PhoneBookEntry that has fields for a student’s name, 
 *phone number and major at MiraCosta. The class should have a constructor 
 *and appropriate accessor and mutator methods, and Equals() method and a 
 *toString() method. 
 *Create a program that creates at least five PhoneBookEntry objects and stores
 *them in an ArrayList. Use the ArrayList class Iterator to find one of the 
 *students in the list and displays their data. Use the ArrayList 
 *classListIterator to search the students in the list for a computer science 
 *major. Display the CS majors.
 *
 *====ALGORITHM====
 *Output list of commands to the user.
 *While(true)
 *	Take in commmand from user.
 *	If(command = add)
 *	create a new object and add it to the array list
 *	get information for instance variables from the user.
 *	If(command = search student)
 *	take in search term from user.
 *	While(iterator.hasNext())
 *		if(iterator.next().getName() = search term)
 *			output iterator.next()
 *	If(command = search major)
 *	take in search term from user.
 *	While(iterator.hasNext())
 *		if(iterator.next().getMajor() = search term)
 *			output iterator.next()
 *	If(command = exit)
 *		System.exit(0)
 *	Else
 *		output Error! Enter a valid command!
 *****************************/
import java.util.*;

public class Driver
{
	public static void main(String[] args)
	{
		ArrayList<PhoneBookEntry> phoneBook = new ArrayList<>(5);
		Iterator<PhoneBookEntry> it = phoneBook.iterator();
		ListIterator<PhoneBookEntry> listIt = phoneBook.listIterator();
		Scanner keyboard = new Scanner(System.in);
		
		PhoneBookEntry temp = null;
		String command, search = "";
		
		System.out.println("====Commands====");
		System.out.println("- Add");
		System.out.println("- Search Student");
		System.out.println("- Search Major");
		System.out.println("- Exit");
		System.out.println("================");
		
		while(true)
		{
			System.out.print("\nPlease enter a command: ");
			command = keyboard.nextLine();
			
			if(command.equalsIgnoreCase("add"))
			{
				temp = new PhoneBookEntry();
				temp.setAll();
				phoneBook.add(temp);
			}
			else if(command.equalsIgnoreCase("search student"))
			{
				System.out.print("\nWho would you like to search for? : ");
				search = keyboard.nextLine();
			
				for(PhoneBookEntry i : phoneBook)
				{
					if(i.getName().equalsIgnoreCase(search))
					{
						System.out.println(i + "\n");
					}
				}
			}
			else if(command.equalsIgnoreCase("search major"))
			{
				System.out.print("\nWhat major would you like to search for? : ");
				search = keyboard.nextLine();
				
				for(PhoneBookEntry i : phoneBook)
				{
					if(i.getMajor().equalsIgnoreCase(search))
					{
						System.out.println(i + "\n");
					}
				}
			}
			else if(command.equalsIgnoreCase("exit"))
			{
				System.out.println("Closing program...");
				System.exit(0);
			}
			else
			{
				System.out.println("Please enter a valid command!");
			}
		}
	}
}