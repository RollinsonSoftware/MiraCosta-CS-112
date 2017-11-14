/**
 *Course: CS112
 *Days/Time: Tues/Thursday 1:30
 *Project Number: Homework Question 2
 *Programmer: John Rollinson
 *Date Created/Last Modified: 9/8/2016
 *
 *Program Title: Rental Class
 *
 *Program Description: Class containing the movie title, ID Number, and the movie rating
 *						and customer ID.
 *
 *--------ALGORITHM:--------
 *
 *
 *--------IMPORTED PACKAGES:--------
 *None.
 **/
public class Rental extends Movie
{

	//INSTANCE VARIABLES
	private int customerId;
	
	//CONSTRUCTORS
	public Rental()
	{
		super();
		setRented(true);
		setCustomerId(0);
	}
	public Rental(int daysLate, int idNum, String rating, String title, boolean rented, int customerID)
	{
		super(daysLate, idNum, rating, title, rented);
		setRented(true);
		setCustomerId(customerID);
	}
	//SETTERS
	public void setCustomerId(int customerID)
	{
		this.customerId = customerID; 
	}
	//GETTERS
	public int getCustomerId()
	{
		return this.customerId;
	}
	//OTHER
	public String toString()
    {
    	return "Movie ID: " + getIdNum() + ", Customer ID: " + getCustomerId() + ", Movie Title: " + getTitle() + ", Movie Rating: "
    		+ getRating() + ", Current rental status: " + getRented() + ", Number of days late: " + getDaysLate() + "\n=================\n";
   	}

}