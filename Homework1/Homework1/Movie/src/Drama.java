/**
 *Course: CS112
 *Days/Time: Tues/Thursday 1:30
 *Project Number: Homework Question 2
 *Programmer: John Rollinson
 *Date Created/Last Modified: 9/8/2016
 *
 *Program Title: Drama Class
 *
 *Program Description: Class containing the movie title, ID Number, and the movie rating, customer ID
 *						and the type of movie changes how the late fees are calculated.
 *
 *--------ALGORITHM:--------
 *
 *
 *--------IMPORTED PACKAGES:--------
 *None.
 **/
public class Drama extends Rental
{
	public Drama()
	{
		super();
	}
	public Drama(int daysLate, int idNum, String rating, String title, boolean rented, int customerId)
	{
		super(daysLate, idNum, rating, title, rented, customerId);
	}
	public String toString()
    {
    	return "Movie ID: " + getIdNum() + "\nMovie Genre: Drama" + "\nMovie Title: " + getTitle() + "\nMovie Rating: "
    		+ getRating() + "\nCurrent rental status: " + getRented() + "\nNumber of days late: " + getDaysLate() 
    		+ "\nCustomer ID: " + getCustomerId() + "\n=================\n" + "Total late fee: " + this.calcLateFees() + "\n";
   	}
   	public double calcLateFees()
	{
		return (getDaysLate() * 2);
	}
}