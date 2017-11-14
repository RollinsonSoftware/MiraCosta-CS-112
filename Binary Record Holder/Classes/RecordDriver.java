/*****************************
 *CHAPTER NUMBER: 10
 *FILE NAME: RecordDriver.java
 *PROGRAMMER: Jack Rollinson
 *DATE LAST MODIFIED: 10/11/2016
 *
 *====PROBLEM====
 *Write a program to maintain a binary file of records of people,
 *(records of type person). Allow commands to delete a record, add
 *a record, retrieve a record and print it to the screen, and a range
 *command to retrieve a group of people in a certain age range.
 *
 *====ALGORITHM====
 *Ask the user for the current date
 *After getting the day, month and year, from the keyboard create a new
 *date object
 *open the output stream to the file "records.dat"
 *loop to ask for a command
 *	if (the user enters add)
 *	record the new persons information and create a new object and add it 
 *	to the array
 *	loop this to add as many people as the user wants.
 *
 *	else if (the user enters delete)
 *	ask for a name and search the array to find the object with the same name
 *	set that array index = null;
 *
 *	else if (the user enters retrieve)
 *	ask for a name and search the array to find the object witht the same name
 *	print the object to the screen
 *	loop this process to see if the user would like to enter another name.
 *
 *	else if (the user enters range)
 *	ask for the age range (upper and lower values)
 *	loop through the array and compare the age of each object
 *	if it is within the range, print the object
 *	else if, continue;
 *
 *	else if (the user enters exit)
 *	close all streams and exit the command loop
 *	end of program. 
 *****************************/
 
 //imports:
import java.util.Scanner;
import java.io.*;

public class RecordDriver
{
	public static void main(String[] args) throws IOException
	{
		Scanner keyboard = new Scanner(System.in);
		ObjectOutputStream outputStream = null;
		
		Date current = null;
		Date birthday = null;
		Person add = null;
		
		Person[] records = new Person[100];
		
		String command, month, temp, name;
		int day, year;
		
		System.out.println("Welcome.\n\nBefore we continue I need to know the current date.\n");
		System.out.print("What is the current day? (enter an int): ");
		temp = keyboard.nextLine();
		day = Integer.parseInt(temp);
		
		System.out.print("\nWhat is the current month? (enter a String): ");
		month = keyboard.nextLine();
		
		System.out.print("\nWhat is the current year? (enter an int): ");
		temp = keyboard.nextLine();
		year = Integer.parseInt(temp);
		
		current = new Date(month, day, year);
		
		try
		{
			outputStream =  new ObjectOutputStream(new FileOutputStream("records.dat", true));	
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Could not find the files specified, closing program...");
			System.exit(0);
		}

		do
		{
			System.out.println("\n====Commands====\n\n'Add' to add a person.\n'Delete' to remove a person.");
			System.out.println("'Retrieve' to view one persons information.");
			System.out.println("'Range' to view all people with in a certain age range.");
			System.out.println("'Exit' to quit the program and save the binary file.\n\n=================");
			System.out.print("Please enter a valid command: ");
			command = keyboard.nextLine();
			
			if(command.equalsIgnoreCase("add"))
			{
				do
				{
					System.out.print("Enter name, ('done' to stop): ");
					name = keyboard.nextLine();
					
					if(name.equalsIgnoreCase("done") == false)
					{
						System.out.println("\nWhat is " + name + "'s birthday?");
						System.out.print("\nDay? (enter an int): ");
						temp = keyboard.nextLine();
						day = Integer.parseInt(temp);
						
						System.out.print("\nMonth? (enter a string): ");
						month = keyboard.nextLine();
						
						System.out.print("\nYear? (enter an int): ");
						temp = keyboard.nextLine();
						year = Integer.parseInt(temp);
						
						birthday = new Date(month, day, year);
						add = new Person(name, birthday, null);
						
						for(int i = 0; i < records.length; i++)
						{
							if(records[i] == null)
							{
								records[i] = add;
								break;
							}
							else if(records[i] != null)
							{
								continue;
							}
						}
						System.out.println("\nWould you like to add another?\n");
					}
					else if(name.equalsIgnoreCase("done") == true)
					{
						break;
					}
				}while(name.equalsIgnoreCase("done") == false);
			}
			else if(command.equalsIgnoreCase("delete"))
			{
				System.out.print("\nWho would you like to delete? (enter a name): ");
				name = keyboard.nextLine();
				
				for(int i = 0; i < records.length; i++)
				{
					if(records[i] != null)
					{
						if((records[i].getName().toLowerCase().equalsIgnoreCase(name.toLowerCase())) == true) //looking for match
						{
							System.out.println("\n" + name + " has been deleted from the records.");
							records[i] = null; //deleting 
							break;
						}
						else if((records[i].getName().equalsIgnoreCase(name)) == false) //incase a match isn't found
						{
							continue;
						}
					}
					else //if the array index is null, it will skip it.
					{
						continue;
					}
				}
			}
			else if(command.equalsIgnoreCase("retrieve"))
			{
				do
				{
					boolean found = false;
					
					System.out.print("\nWho would you like to look up? ('done' to stop): ");
					name = keyboard.nextLine();
					
					for(int i = 0; i < records.length; i++)
					{
						if(records[i] == null)
						{
							continue;
						}
						else if(((records[i].getName().toLowerCase().equalsIgnoreCase(name.toLowerCase())) == true) &&
								(records[i] != null))
						{
							System.out.println("\n" + name + "'s information:\n");
							System.out.println(records[i]);
							found = true;
							break;
						}
						else if(((records[i].getName().equalsIgnoreCase(name)) == false) &&
								(records[i] != null))
						{
							continue;
						}
						else if(name.equalsIgnoreCase("done") == true)
						{
							found = true;
							break;
						}
					}
					if(found == false && name.equalsIgnoreCase("done") ==  false)
					{
						System.out.println("\nSorry, " + name + " was not found in the records...");	
					}
				}while(name.equalsIgnoreCase("done") == false);
			}
			else if(command.equalsIgnoreCase("range"))
			{
				int age1, age2;
				
				System.out.println("From ___ age to ___ age would you like to view?");
				System.out.print("\nFirst age? (lower value): ");
				temp = keyboard.nextLine();
				age1 = Integer.parseInt(temp);
				
				System.out.print("\nSecond age? (higher value): ");
				temp = keyboard.nextLine();
				age2 = Integer.parseInt(temp);
				
				System.out.println("\nFinding all people between age's " + age1 + " and " + age2 + "...\n");
				
				for(int i = 0; i < records.length; i++)
				{
					if(records[i] == null)
					{
						continue;
					}
					else if(current.getYear() - records[i].getBirthYear() >= age1 &&
							current.getYear() - records[i].getBirthYear() <= age2)
					{
						System.out.println(records[i] + "\n");
						continue;
					}
				}
			}
			else if(command.equalsIgnoreCase("exit")) //exit's command loops and writes to binary file
			{
				for(int i = 0; i < records.length; i++)
				{
					if(records[i] != null) //checking for null before writing to binary file
					{
						outputStream.writeObject(records[i]);
					}
				}
				System.out.println("\nRecords have been written to the file: 'records.dat' ");
				break;
			}
			else
			{
				System.out.println("ERROR! Please enter a valid command!");
			}
		}while(command.equalsIgnoreCase("exit") == false);
		outputStream.close(); //clean up
		keyboard.close();
	}
}