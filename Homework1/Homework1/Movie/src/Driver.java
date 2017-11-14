/**
 *Course: CS112
 *Days/Time: Tues/Thursday 1:30
 *Project Number: Homework Question 2
 *Programmer: John Rollinson
 *Date Created/Last Modified: 9/8/2016
 *
 *Program Title: Driver
 *
 *Program Description: Driver for the movies classes.
 *
 *--------ALGORITHM:--------
 *Create 9 different movies(3 of each type) that have there rented status initialized to false
 *When the movies are taken into the rental aray, there rental status is turned to true.
 *Create an array of type Rental with 9 slots
 *Store 3 movies of each different types in the array
 *Loop through the array of movies
 *Depending on the movie, calculate the late fees for each loop iteration.
 *Store total in a variable.
 *Run loop that will display the statics for each movie in the aray.
 *Finally display the total amount of late fees outstanding.
 *
 *--------IMPORTED PACKAGES:--------
 *None.
 **/
public class Driver
{
	public static final int MAX = 9;
	
	public static void main(String[] args)
	{
		double lateFeesOwed = 0;
		
		Action movie1 = new Action(2, 1, "PG-13", "Intersteller", false, 155);
		Action movie2 = new Action(2, 1, "R", "Deadpool", false, 155);
		Action movie3 = new Action(2, 3, "PG", "Spiderman", false, 234);
		Comedy movie4 = new Comedy(1, 4, "PG", "Daddys Home", false, 234);
		Comedy movie5 = new Comedy(1, 5, "R", "This is the End", false, 234);
		Comedy movie6 = new Comedy(1, 6, "PG-13", "Hot Fuzz", false, 321);
		Drama  movie7 = new Drama(3, 7, "R", "12 Angry Men", false, 321);
		Drama  movie8 = new Drama(0, 8, "R", "Saving Private Ryan", false, 444);
		Drama  movie9 = new Drama(0, 9, "PG-13", "Me Before You", false, 444); 
	
		Rental movies [] = new Rental[MAX];
		movies[0] = movie1;
		movies[1] = movie2;
		movies[2] = movie3;
		movies[3] = movie4;
		movies[4] = movie5;
		movies[5] = movie6;
		movies[6] = movie7;
		movies[7] = movie8;
		movies[8] = movie9;
	
		//Calculate total late fees:	
   		for(int count = 0; count < movies.length; count++)		
		{
			if((movies[count].getClass()) == Action.class)
			{
				lateFeesOwed = lateFeesOwed + (movies[count].getDaysLate() * 3);
			}
			else if((movies[count].getClass()) == Comedy.class)
			{
				lateFeesOwed = lateFeesOwed + (movies[count].getDaysLate() * 2.5);
			}
			else if((movies[count].getClass()) == Drama.class)
			{
				lateFeesOwed = lateFeesOwed + (movies[count].getDaysLate() * 2);
			}
		}
		
   		//Testing equals method:
   		System.out.println("Equals method testing: \n");
   		System.out.println("This should be true: " + movie1.equals(movie2) + "\n");
   		System.out.println("This should be false: " + movie3.equals(movie4) + "\n");
   		System.out.println("This should be false: " + movie4.equals(movie5) + "\n");
   		
   		
   		//Print movie statistics:	
   		for(int count = 0; count < movies.length; count++)
   		{
   			System.out.println(movies[count]);
   		}
   		//Total late fees:
   		System.out.println("\n\n=================\n\n");
   		System.out.printf("Total late fees outstanding: " + "$%5.2f %n", lateFeesOwed);	
   		
	}
	
}