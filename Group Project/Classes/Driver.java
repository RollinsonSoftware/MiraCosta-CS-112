/* Online Group Clown Fiesta
   File Name:          driver
   Programmer:         Jack, Yash
   Date Last Modified: October 20, 2016

   Problem Statement: Oceanside is holding a vote on mayor, prop 22, prop 24,
   measure 2, and we are assigned with the task to record the votes and to make
   sure there is not invalid or falsified data. The program will also give the 
   user access to some super fun statistics!!

/**PLAN
 *open the file and add a sstring "voter list"
 *close the file
 *the reason we do that is so we dont run into an error when appending
 *ask the user for their name
 *use a method to output the menu and validate the users answers
 *	use charAt to validate the asnwers in the method
 *use constructors to create objects
 *all of that goes into a do while, if the user enters  done, then continue the
 *code
 *
 *run a method to calculate the winners of each section by opening the file
 *and tally the votes for catagores via the get methods
 *	close the file at the end of the method and return
 *
 *run a method to output a reciept
 *	literally just use the toString method to get all that
 *
 *run a method to open a text file and output user id and votes
 *	this is for the user to see and make sure their votes were correct
 */
import java.util.Scanner;
import java.io.*;

public class Driver
{
	public static final String FILE = "votes";
	
	public static void main(String[] args) throws IOException, ClassNotFoundException
	{
		Scanner keyboard = new Scanner(System.in);
		ObjectInputStream inputStream = null;
		ObjectOutputStream outputStream = null;
		
		int idNum = 1000;
		String name = "";
		
		try
		{
			outputStream = new ObjectOutputStream(new FileOutputStream(FILE));
			
			outputStream.writeUTF("");
			
			outputStream.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("ERROR! Could not open streams...");
			System.exit(0);
		}
		do
		{
			Voter person = null;
			
			System.out.print("Before you can vote, I need your name ('done' to stop): ");
			name = keyboard.nextLine();
			
			if(name.equalsIgnoreCase("done"))
			{
				System.out.println("Closing program...");
			}
			else
			{
				try
				{
					outputStream = new ObjectOutputStream(new FileOutputStream(FILE, true));
					
					String votes = Voter.readBallotAnswers();
					person = new Voter(name, idNum, votes);
					
					outputStream.writeObject(person);
					
					outputStream.close();
				}
				catch(FileNotFoundException e)
				{
					System.out.println("ERROR! Could not open streams...");
					System.exit(0);
				}
				
				idNum++;
				System.out.println("\n" + person);
			}
		}while(name.equalsIgnoreCase("done") != true);
		
		try
		{
			inputStream = new ObjectInputStream(new FileInputStream(FILE));
			Voter person = null;
			try
			{
				while(true)
				{
					person = (Voter)inputStream.readObject();
					
					System.out.println(person);
				}
			}
			catch(EOFException e)
			{
				System.out.println("No more voters found on file...");
				inputStream.close();
			}
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Problem opening the file...");
			System.exit(0);
		}
		keyboard.close();
	}
}