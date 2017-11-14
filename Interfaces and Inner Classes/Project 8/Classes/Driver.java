/*****************************
 *CHAPTER NUMBER: 13 Interfaces and Inner Classes
 *FILE NAME: Book Project 8
 *PROGRAMMER: Jack Rollinson
 *DATE LAST MODIFIED: 11/10/2016
 *
 *====PROBLEM======
 *Redo the class person in display 5.19 so that the class date is a private
 *inner class of the class person, and so that the class person implements
 *the cloneable interface. Make a driver to test the new class.
 *
 *====ALGORITHM====
 *Create a new person object and clone it using the clone method
 *print the two objects
 *call the equals method to show that they are the same
 *change the clone instance variables
 *print the two objects again to show changes
 *call the equals method again to show that the clone object is a deep copy.
 *****************************/
public class Driver
{
	public static void main(String[] args)
	{
		Person original = new Person("Jack", 11, 3, 1996, null);
		Person clone = (Person)original.clone();
		
		System.out.println("Original: " + original);
		System.out.println("Copy: " + clone + "\n");
		
		System.out.println("This should be true: " + original.equals(clone));
		
		clone.setBirthYear(2000);
		clone.setName("Clone");
		
		System.out.println("\nOriginal: " + original);
		System.out.println("Copy: " + clone + "\n");
		
		original.setBirthYear(2005);
		
		System.out.println("Original: " + original);
		System.out.println("Copy: " + clone + "\n");
		
		System.out.println("This should be flase: " + original.equals(clone));
		
		System.out.println("\nThe clone object is a deep copy of the original object!");
	}
}