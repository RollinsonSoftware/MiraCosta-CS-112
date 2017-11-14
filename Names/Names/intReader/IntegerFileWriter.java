//-------------------------------------------------------------------------------------------------------------------
//  Course: CS 112           
//  Days & Time: Tues. & Thurs. 1:30 - 3:20                                                                                                                                                                          
//  Chapter Number: Chapter 10 
//  Project Number or GroupProject Name: Projects Handout #2 - Project 1                                            
//  Programmer(s): Jack Rollinson                                                                                                         
//  Date Created or Last Modified: 10/4/2016                                                                                                                             
//-------------------------------------------------------------------------------------------------------------------

//-------------------------------------------------------------------------------------------------------------------
//  Program Title: Integer Reader                                                                                                                                               
//  Program Description: A program that reads a file of numbers of type int and outputs all the numbers to another file
//						but with out any duplicate numbers/ lines.                                           
//  The purpose of this program is to: Copy all the lines of the first txt file, and then write them to another text file
//										but with out duplicating any lines.

//-------------------------------------------------------------------------------------------------------------------
/************ALGORTITHM************
 *Ask the user for the input file name and store it as a string
 *Ask the user for the output file name and store it as a string
 *Open 2 streams with the above strings as the file names
 *If the input file can not be found, then the program exits
 *Creat a dummy array that will have 1 million slots for the intial copying.
 *Loop to find how many lines there are in the textfile.
 *Write each line of the text file to an array index while counting the lines.
 *Check for null and copy each line to a new array that is the right size.
 *Next sort this new array and check for duplicates and remove them.
 *Print the finshed results to the screen, and the new text file so the user
 *can see what was written.
 *********************************/
import java.util.Scanner;
import java.io.*;

public class IntegerFileWriter
{
	public static void main(String[] args)
	{
		String inputFileName, outputFileName;
		int counter = 0;
		
		Scanner keyboard = new Scanner(System.in);
		Scanner inputStream = null;
		PrintWriter outputStream = null;
		String[] numbers;
		String[] temp = new String[1000000]; //works with text files up to 1,000,000 lines of text
		
		System.out.println("Hello, what file would you like me to read?\n");
		System.out.print("FILE NAME: ");
		inputFileName = keyboard.nextLine();
		
		System.out.println("\nWhat do you want the new file to be?\n");
		System.out.print("FILE NAME: ");
		outputFileName = keyboard.nextLine();
		
		try
		{
			inputStream = new Scanner(new FileInputStream(inputFileName));
			outputStream = new PrintWriter(new FileOutputStream(outputFileName));
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Could not find 1 or more files, please restart.");
			System.exit(0);
		}
		while(inputStream.hasNextLine()) //finding how many lines there are in the text file
		{	
			temp[counter] = inputStream.nextLine();
			counter++;
		}
		
		numbers = new String[counter]; //array of each line from the text file
		
		for(int i = 0; i < numbers.length; i++) //filling the array
		{
			if(temp[i] != null) //checking for null before copying
			{
				numbers[i] = temp[i];
			}
		}
		for(int i = 0; i < numbers.length; i++) //checking for dupelicates and removing
		{
			for(int j = i + 1; j < numbers.length; j++)
			{
				if(numbers[i].equals(numbers[j]))
				{
					numbers[i] = "";
				}
			}
		}
		for(int i = 0; i < numbers.length; i++) //printing the sorted array to the screen and the file!
		{
			if(numbers[i] != "")
			{
				System.out.println(numbers[i]);
				outputStream.println(numbers[i]);
			}
		}
		inputStream.close(); //clean up
		outputStream.close();
		
		System.out.println("========");
		System.out.println("\nThe numbers above have been written to the file you chose!");
	}
}	