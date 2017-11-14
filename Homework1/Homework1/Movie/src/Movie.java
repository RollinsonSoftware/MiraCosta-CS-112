/**
 *Course: CS112
 *Days/Time: Tues/Thursday 1:30
 *Project Number: Homework Question 2
 *Programmer: John Rollinson
 *Date Created/Last Modified: 9/8/2016
 *
 *Program Title: Movie Class
 *
 *Program Description: Class containing the movie title, ID Number, and the movie rating.
 *
 *--------ALGORITHM:--------
 *
 *
 *--------IMPORTED PACKAGES:--------
 *None.
 **/
public class Movie 
{
    	//INSTANCE VARIABLES:
    	private int daysLate;
    	private int idNum;
    	private String rating;
    	private String title;
    	private boolean rented;
    	
    	//CONSTRUCTORS:
    	public Movie()
    	{
    		setAll(0, 0, "G", "Defualt Title", false);
    	}
    	public Movie(int daysLate, int idNum, String rating, String title, boolean rented)
    	{
    		setAll(daysLate, idNum, rating, title, rented);
    	}
    	public Movie(Movie original)
    	{
    		this.daysLate = original.daysLate;
    		this.idNum = original.idNum;
    		this.rating = original.rating;
    		this.title = original.title;
    		this.rented = original.rented;
    	}
    	//OTHER METHODS:
    	public String toString()
    	{
    		return "Movie ID: " + this.idNum + ", Movie Title: " + this.title + ", Movie Rating: "
    			+ this.rating + ", Current rental status: " + this.rented;
    	}
    	public boolean equals(Movie other)
    	{
    		if (this.idNum == other.idNum)
    		{
    			return true;
    		}
    		else
    		{
    			return false;
    		}
    	}
    	public double calcLateFees()
    	{ 
    		return getDaysLate() * 2;
    	}
    	public int addLateFee(int numDays)
    	{
    		this.daysLate += numDays;
    		return this.daysLate; 
    	}
    	public int removeLateFee()
    	{
    		if(this.rented != false)
    		{
    			this.daysLate = 0;
    		}
    		return this.daysLate;
    	}
    	//SETTERS:
    	public void setAll(int daysLate, int idNum, String rating, String title, boolean rented)
    	{
    		setDaysLate(daysLate);
    		setIdNum(idNum);
    		setRating(rating);
    		setTitle(title);
    		setRented(rented);
    	}
    	public void setDaysLate(int daysLate)
    	{
    		this.daysLate = daysLate;
    	}
    	public void setIdNum(int idNum)
    	{
    		this.idNum = idNum;
    	}
    	public void setRating(String rating)
    	{	
    		this.rating = rating;
    	}
    	public void setTitle(String title)
    	{
    		this.title = title;
    	}
    	public void setRented(boolean rented)
    	{
    		this.rented = rented;
    	}
   
    	//GETTERS:
    	public int getDaysLate()
    	{
    		return this.daysLate;
    	}
    	public int getIdNum()
    	{
    		return this.idNum;
    	}
    	public String getRating()
    	{
    		return this.rating;
    	}
    	public String getTitle()
    	{
    		return this.title;
    	}
    	public boolean getRented()
    	{
    		return this.rented;
    	}
    			
}
