/*****************************
 *CHAPTER NUMBER: 11 Recursion
 *FILE NAME: Book Project 4
 *PROGRAMMER: Jack Rollinson
 *DATE LAST MODIFIED: 10/18/2016
 *
 *====PROBLEM======
 *The game "jump it" consists of a board with n positive
 *integers in a row except for the first column, which always
 *contains 0. These numbers represent the cost to enter each column.
 *The object of the game is to move from the first column to the last
 *column in the lowest total cost. The number in each column represents
 *the cost to enter that column. Always start the game in the first column.
 *There are two types of moves, you can ethier move to the adjacent column
 *or jump over the adjacent column, the cost is the sum of all columns
 *visited. Make a program that finds the best way to move through the board.
 *
 *====ALGORITHM====
 *	No user input needed, just manipulate the array size of the board.
 *	FOR loop to show the board to the user.
 *	The recursive method compares the index next to it, and the index after that
 *	which ever one is cheapest is the one that the pointer moves to.
 *	when the pointer enters a new index, it adds that value to the total score.
 *	once the pointer reaches the end of the board it sums the cheapest amount of
 *		moves.
 *	output the cheapest amount of moves to the user.
 *****************************/
 
public class Driver
{
	public static final int START = 0;
	public static int cheapest = 0;
	
	public static void main(String[] args)
	{
		int[] board = {0, 3, 80, 6, 59, 10};
		int last =  board.length;
		
		System.out.println("Board:");
		for(int i = 0; i < board.length; i++)
		{
			System.out.print(board[i] + " ");
		}
		System.out.println("\n");
		
		System.out.println("The 'cheapest' cost is: " + jump(board, START, last));
	}
	public static int jump(int[] board, int first, int last)
	{
		try
		{
			if(first > last)
			{
				System.out.println("End of board reached...");
			}
			else if(board[first + 1] > board[first + 2])
			{
				System.out.println("Jumped");
				jump(board, first + 2, last - 2);
				cheapest += board[first + 2];
				System.out.println("Cheapest current value: " + cheapest + " After Jump");
			}
			else if(board[first + 1] < board[first + 2])
			{
				System.out.println("Moved");
				jump(board, first + 1, last - 1);
				cheapest += board[first + 1];	
				System.out.println("Cheapest current value: " + cheapest + " After Move");
			}
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Array index is out of bounds!");
			System.out.println(e.getMessage());
		}
		return cheapest;
	}
}