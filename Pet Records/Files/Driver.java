/*****************************
 *CHAPTER NUMBER: 10
 *FILE NAME: Driver.java
 *PROGRAMMER: Jack Rollinson
 *DATE LAST MODIFIED: 10/11/2016
 *
 *====PROBLEM====
 *Write a program that allows you to write and read records
 *of type pet record. The program asks the user to choose between
 *reading and writing to a dile. In ethier case, the program will
 *ask for a file name to preform the action on.
 *
 *====ALGORITHM====
 *Ask the user for a command (read/write)
 *Ask the user which file they would like to read/write
 *
 *depending on the command open an inputStream/outputStream
 *using the ObjectInputStream/ObjectOutputStream
 *
 *if (user enters write)
 *	loop (ask user for name, age and weight)
 *		create a new object with info above for each loop iteration
 *		add all objects to an array of type PetRecord
 *		if the user says they are done exit the loop
 *	write all object to the file given and close the stream.
 *
 *if (user enters read)
 *	loop to print all objects contained in the file name given.
 *	add all objects to the array again.
 *
 *loop through the array of pets from the binary file
 *	find the largest pet
 *	find the smallest pet
 *	find the oldest pet
 *	find the youngest pet
 *	output these everything after the file has read all the objects.
 *****************************/
 
//imports
import java.util.Scanner;
import java.io.*;

public class Driver
{
	public static void main(String[] args) throws IOException, ClassNotFoundException
	{
		boolean isValid;
		String command, fileName;
		
		PetRecord[] pets = new PetRecord[1000];
		Scanner keyboard = new Scanner(System.in);
		
		ObjectInputStream inputStream = null;
		ObjectOutputStream outputStream = null;
		
		System.out.println("Welcome to the pet database!\n");
		isValid = true;
		do
		{
			System.out.print("What action would you like to preform? (write/read): ");
			command = keyboard.nextLine();
			
			if(command.equalsIgnoreCase("write") || command.equalsIgnoreCase("read"))
			{
				isValid = false;
				break;
			}
			else
			{
				System.out.println("\nERROR! Please enter a valid command...\n");
				continue;
			}
			
		}while(isValid);
		
		System.out.println("\nWhat is the name of the file you would like me to " + command + "?\n");
		System.out.print("Enter file name: ");
		fileName = keyboard.nextLine();
		
		if(command.equalsIgnoreCase("write"))
		{
			PetRecord currentPet = null;
			String name, temp;
			int age;
			double weight;
			
			try
			{
				outputStream =  new ObjectOutputStream(new FileOutputStream(fileName, true));
			}
			catch(FileNotFoundException e)
			{
				System.out.println("ERROR! Could not find file to write to...");
				System.exit(0);
			}
			
			System.out.println("\nEnter as many pets as you'd like!\n");
			
			do
			{
				System.out.println("\n============\n");
				System.out.print("\nWhat is the name of the new pet? ('done' to stop): ");
				name = keyboard.nextLine();
				
				if(name.equalsIgnoreCase("done"))
				{
					break;
				}
				
				System.out.print("\nWhat is " + name + "'s age? (enter an int): ");
				temp = keyboard.nextLine();
				age = Integer.parseInt(temp);
				
				System.out.print("\nHow much does " + name + " wiegh? (enter a double): ");
				temp = keyboard.nextLine();
				weight = Double.parseDouble(temp);
				
				currentPet = new PetRecord(name, age, weight);
				
				for(int i = 0; i < pets.length; i++)
				{
					if(pets[i] == null)
					{
						pets[i] = currentPet;
						break;
					}
					else if(pets[i] != null)
					{
						continue;
					}
				}
				
			}while(name.equalsIgnoreCase("done") == false);
			
			for(int i = 0; i < pets.length; i++)
			{
				if(pets[i] == null)
				{
					continue;
				}
				else if(pets[i] != null)
				{
					outputStream.writeObject(pets[i]);
				}
			}
			
			outputStream.close();
			System.out.println("\nAll pets have been added to the file!");
		}
		else if(command.equalsIgnoreCase("read"))
		{
			int counter = 0;
			
			try
			{
				inputStream = new ObjectInputStream(new FileInputStream(fileName));
				PetRecord currentPet = null;
				try
				{
					
					
					while(true)
					{
						currentPet = (PetRecord)inputStream.readObject();
						pets[counter] = currentPet;
						
						System.out.println("\n" + currentPet + "\n");
						counter++;
					}
				}
				catch(EOFException e)
				{
					System.out.println("\nNo more pets on record...\n");
					inputStream.close();
				}
				catch(Exception e)
				{
					System.out.println("ERROR! Could not read all the data from the file...");
					System.out.println(e.getMessage());
				}
			}
			catch(FileNotFoundException e)
			{
				System.out.println("ERROR! Could not find file to read from...");
				System.exit(0);
			}
			
			PetRecord[] onlyPets = new PetRecord[counter];
			
			for(int i = 0; i < onlyPets.length; i++)
			{
				if(pets[i] != null)
				{
					onlyPets[i] = pets[i];		
				}
			}
			
			PetRecord oldest = null;
			PetRecord youngest = null;
			PetRecord largest = null;
			PetRecord smallest = null;
			
			for(int i = 0; i < onlyPets.length; i++)
			{
				for(int j = i + 1; j < onlyPets.length; j++)
				{
						if(onlyPets[i].getAge() < onlyPets[j].getAge())
						{
							oldest = onlyPets[j];
						}
						if(onlyPets[i].getAge() > onlyPets[j].getAge())
						{
							youngest = onlyPets[j];
						}
						if(onlyPets[i].getWeight() < onlyPets[j].getWeight())
						{
							largest = onlyPets[j];
						}
						if(onlyPets[i].getWeight() > onlyPets[j].getWeight())
						{
							smallest = onlyPets[j];
						}
				}
			}
			//special cases:
			if(onlyPets[0].getWeight() < smallest.getWeight())
			{
				smallest = onlyPets[0];
			}
			if(onlyPets[0].getAge() < youngest.getAge())
			{
				youngest = onlyPets[0];
			}
			
			System.out.println("\nOldest Pet:\n" + oldest);
			System.out.println("\nYoungest Pet:\n" + youngest);
			System.out.println("\nLargest Pet:\n" + largest);
			System.out.println("\nSmallest Pet:\n" + smallest);
		}
	}
}