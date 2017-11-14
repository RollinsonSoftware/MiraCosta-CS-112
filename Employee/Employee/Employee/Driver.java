/****************************************************************************
 *==========ALGORITHM============
 *- LOOP to ask the user if they want to add a new employee to the array.
 *- IF the user answers yes, use the Scanner to record the employee information.
 *- The class Employee holds name, salary, social security number (SSN) and an 
 *	annotation on there salary.
 *- Create a new object of the class employee for each loop iteration.
 *- Record the name of the employee first.
 *- Record the social secuirty number second.
 *- Error check to make sure the social security number is exactly 9 digits
 *	and contains ONLY digits.
 *- If an error is thrown, tell the user what they did wrong and have them try again.
 *- Record the employees salary, and then have the boolean average claculated.
 *- Loop through the array of employees and print all the employee information.
 *- Check for null in the array and exclude it.
 ****************************************************************************/
import java.util.Scanner;
public class Driver
{
	public static final int MAX = 100;
	
	public static void main(String[] args)
	{
		String answer, ssn;
		int counter = 0;
		
		Scanner keyboard = new Scanner(System.in);
		Employee[] staff = new Employee [MAX];
		
		System.out.println("Welcome to the company database!");
		
		do
		{
			System.out.print("Would you like to add a new employee? (y/n): ");
			answer = keyboard.nextLine();
			System.out.println("");
			
			if(answer.equalsIgnoreCase("yes") || 
				answer.equalsIgnoreCase("y"))
			{	
				staff[counter] = new Employee();
				
				System.out.print("Please enter the name of the new employee: ");
				staff[counter].setName(keyboard.nextLine());
				System.out.println("");
					
				System.out.print("Please enter the new employee's SSN (no dashes or spaces): ");
				ssn = keyboard.nextLine();
				System.out.println("");
				try
				{
					if(ssn.matches("[0-9]+") && ssn.length() == 9)
					{
						staff[counter].setSSN(ssn);
					}
					else if(ssn.matches(".*[a-zA-Z]+.*"))
					{
						throw new SSNCharacterException();
					}
					else if(ssn.length() != 9)
					{
						throw new SSNLengthException();
					}
				}
				catch(SSNCharacterException e)
				{
					System.out.println(e.getMessage());
					System.out.println("You entered: " + ssn + "\n");
					
					System.out.print("Please enter a valid social security number: ");
					ssn = keyboard.nextLine();
					System.out.println("");
					
					if(ssn.matches("[0-9]+") && ssn.length() == 9)
					{
						staff[counter].setSSN(ssn);
					}
					else
					{
						System.out.println("To many wrong entries, exiting program.");
						System.exit(0);
					}
				}
				catch(SSNLengthException e)
				{
					System.out.println(e.getMessage());
					System.out.println("You entered: " + ssn + "\n");
					
					System.out.print("Please enter a valid social security number: ");
					ssn = keyboard.nextLine();
					System.out.println("");
					
					if(ssn.matches("[0-9]+") && ssn.length() == 9)
					{
						staff[counter].setSSN(ssn);
					}
					else
					{
						System.out.println("To many wrong entries, exiting program.");
						System.exit(0);
					}
				}
				
				System.out.print("Please enter the new employee's starting pay: ");
				staff[counter].setSalary(keyboard.nextDouble());
				keyboard.nextLine(); //clearing the buffer
				System.out.println("");
				
				staff[counter].setAverage();
				
				counter++;
			}	
		}while(answer.equalsIgnoreCase("yes") || 
				answer.equalsIgnoreCase("y"));
		
		keyboard.close();
		
		for(int i = 0; i < staff.length; i++)
		{
			if(staff[i] == null)
			{
				continue;
			}
			else
			{
				System.out.println(staff[i] + "\n");
			}
		}
		
		System.out.println("Thank you for using the company database!");
	}
}