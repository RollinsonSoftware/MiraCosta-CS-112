/*****************************
 *CHAPTER NUMBER: 11 Recursion
 *FILE NAME: Book Project 2
 *PROGRAMMER: Jack Rollinson
 *DATE LAST MODIFIED: 10/18/2016
 *
 *====PROBLEM======
 *There are n people in a room, where n is an integer greater than or equal
 *to 1. Each person shakes hands once with every other person. What is the 
 *total number, h(n), of handshakes? Write a recursive function to solve this
 *problem.
 *
 *====ALGORITHM====
 *	Loop to ask the user for the number of people in the room.
 *	If the user enters a negative number the loop stops.
 *	The recursive method calculates the number of handshakes
 *		If the number entered by the user is valid.
 *	In order to calculate the number of handshakes, the lowest
 *		valid input for number of people is 2.
 *	If the user enters 0 or 1 the program throws an error, beacuse
 *		you need to have at least 2 people to shake hands.
 *	end of program. 
 *****************************/
 
 //imports
import java.util.Scanner;

public class Driver
{
	public static void main(String[] args)
	{
		int people, handshakes;
		
		Scanner keyboard = new Scanner(System.in);
		
		do
		{
			System.out.println("\n=========");
			System.out.println("To exit the loop, enter a NEGATIVE number.");
			System.out.println("How many people are currently in the room?");
			System.out.println("=========\n");
			System.out.print("Number of people: ");
			people = keyboard.nextInt();
			
			if(people > 0)
			{
				handshakes = numHandshakes(people - 1);			
				System.out.println("With " + people + " people in the room, there will be " + handshakes + " handshake(s) exchanged.");
				continue;
			}
			else
			{
				System.out.println("Closing program...");
				break;
			}
		}while(people > 0);
		keyboard.close(); //clean up.
	}
	public static int numHandshakes(int people)
	{
		if(people <= 0)
		{
			System.out.println("Error! Someone needs to be in the room in order to shake hands!");
			System.out.println("Closing program...");
			System.exit(0);
		}
		if(people == 1)
		{
			return 1;
		}
		else
		{
			return (people + numHandshakes(people - 1));
		}
	}
}