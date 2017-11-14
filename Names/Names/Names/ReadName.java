//-------------------------------------------------------------------------------------------------------------------
//  Course: CS 112           
//  Days & Time: Tues. & Thurs. 1:30 - 3:20                                                                                                                                                                          
//  Chapter Number: Chapter 10 
//  Project Number or GroupProject Name: Project #1 pg.643                                            
//  Programmer(s): Jack Rollinson                                                                                                         
//  Date Created or Last Modified: 10/4/2016                                                                                                                             
//-------------------------------------------------------------------------------------------------------------------

//-------------------------------------------------------------------------------------------------------------------
//  Program Title: Name Reader                                                                                                                                               
//  Program Description: Stores all the lines of two text files into arrays, allows the user to search the array for a
//							specific name in ethier of the text files.                                                        
//  The purpose of this program is to: Allow the user to search a name, and then output the name and some of its 
//										statistics, the user can search as many names as he/she wants.

//-------------------------------------------------------------------------------------------------------------------
/************ALGORTITHM************
 *Open 2 streams for two different text files
 *If you can't open the streams close the program.
 *Store each text file into an array.
 *Have the user give me a name in the form of a string
 *Search both arrays for a matching string.
 *if there is a match in both arrays, print stats for both
 *if there is only a match in the boys, print stats for boys
 *if there is only a match for girls, print stats for girls
 *if there is no space entered for a deliminator, then have the user try again
 *if the user enters "exit " for the name, then exit the program.
 *All the if statements are in a loop so that the user can search as many names
 *	as he or she wants.
 *********************************/
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileOutputStream;

public class ReadName
{
	public static final int MAX = 1000;
	
	public static void main(String[] args)
	{
		String name = "";
		Scanner inputStreamA = null;
		Scanner inputStreamB = null;
		Scanner keyboard = new Scanner(System.in);

		try
		{
			inputStreamA = new Scanner(new FileInputStream("boynames.txt"));
			inputStreamB = new Scanner(new FileInputStream("girlnames.txt"));
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Problem opening files! \nClosing Program...");
			System.exit(0);
		}
		
		String[] boy = new String[MAX];
		String[] girl = new String[MAX];
		
		for(int i = 0; i < MAX; i++)
		{
			boy[i] = inputStreamA.nextLine();
			girl[i] = inputStreamB.nextLine();
		}
		inputStreamA.close(); //clean up
		inputStreamB.close();
	
		System.out.println("Welcome to the NAME DATABASE!\nWhen finished typing the name, press SPACE, then ENTER.\n");
		
		do
		{
			System.out.print("Enter a name to search ('exit ' to quit): ");
			name = keyboard.nextLine(); //Im using " " as my deliminator, book uses a comma.
			
			for(int i = 0; i < MAX; i++)
			{
				int rank;
				String namings = "";
				
				rank = i + 1;
					
				if((boy[i].toLowerCase().contains(name.toLowerCase()) &&
					(boy[i].indexOf(" ") == name.indexOf(" "))) && 
					((girl[i].toLowerCase().contains(name.toLowerCase())) && 
					(girl[i].indexOf(" ") == name.indexOf(" "))))
				{	
					String namings1, namings2;
					namings1 = boy[i].replaceAll("[^0-9]+", "");
					namings2 = girl[i].replaceAll("[^0-9]+", "");
					
					System.out.println(name + " is ranked " + rank + " in popularity among boys with " + namings1 + " namings.");
					System.out.println(name + " is ranked " + rank + " in popularity among girls with " + namings2 + " namings.\n");
					break;
				}
				else if((girl[i].toLowerCase().contains(name.toLowerCase())) &&
							girl[i].indexOf(" ") == name.indexOf(" "))
				{
					namings = girl[i].replaceAll("[^0-9]+", "");
					
					System.out.println(name + " is not ranked among the top 1000 boy names.");
					System.out.println(name + " is ranked " + rank + " in popularity among girls with " + namings + " namings.\n");
					break;
				}
				else if((boy[i].toLowerCase().contains(name.toLowerCase())) &&
							(boy[i].indexOf(" ") == name.indexOf(" ")))
				{
					namings = boy[i].replaceAll("[^0-9]+", "");
					
					System.out.println(name + " is not ranked among the top 1000 girl names.");
					System.out.println(name + " is ranked " + rank + " in popularity among boys with " + namings + " namings.\n");
					break;
				}
				else if(name.indexOf(" ") == -1)
				{
					System.out.println("ERROR! Please enter a SPACE when you are done!\n\n");
					break;
				}
			}
		}while(name.equalsIgnoreCase("exit ") == false);
		keyboard.close();	
	}
}