/*****************************
 *CHAPTER NUMBER: 11 Recursion
 *FILE NAME: Project #2 Handout #3
 *PROGRAMMER: Jack Rollinson
 *DATE LAST MODIFIED: 10/18/2016
 *
 *====PROBLEM======
 *Write a static recursive method definition for a method that takes one
 *parameter of type String and returns a boolean value.
 *The method should return true if the String is a palindrome, and
 *false otherwise.
 *Disregard spaces, puncuation, and case sensitivity.
 *
 *====ALGORITHM====
 *	LOOP to ask the user for a String.
 *	IF the user enters 'done' then stop the program.
 *	Flip the string using recursion
 *	Ignoring case, if the strings are equal return true
 *	If the strings are not equal then return false
 *	Depending on what is returned, output the word,
 *		and wether or not it is a palindrome.
 *****************************/

//imports
import java.util.Scanner;

public class Driver
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		String word;
		
		do
		{
			System.out.print("\nPlease enter a String ('done' to stop): ");
			word = keyboard.nextLine();
			
			if(word.equalsIgnoreCase("done"))
			{
				System.out.println("\nClosing program...");
				break;
			}
			if(check(word))
			{
				System.out.println(word + " IS a palindrome!");
				continue;
			}
			else
			{
				System.out.println(word + " is NOT a palindrome!");
				continue;
			}
		}while(word.equalsIgnoreCase("done") != true);
		keyboard.close();
	}
	public static boolean check(String word)
	{
		String backward = reverseString(word);
		
		if(backward.equalsIgnoreCase(word))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public static String reverseString(String word)
	{
		//flipping the string
    	if(word.length() == 0)
    	{
    		return word;
    	} 
    	return reverseString(word.substring(1)) + word.charAt(0);
	}
}