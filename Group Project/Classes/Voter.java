import java.io.*;
import java.util.Scanner;

public class Voter implements Serializable
{
	private char vote1;
	private char vote2;
	private char vote3;
	private char vote4;
	private String name;
	private int idNum;
	
	
	/*****CONSTRUCTORS*****/
	public Voter(String name, int idNum, String votes)
	{
		this.name = name;
		this.idNum = idNum;
		votes = votes.toUpperCase();
		vote1 = votes.charAt(0);
		vote2 = votes.charAt(1);
		vote3 = votes.charAt(2);
		vote4 = votes.charAt(3);
	}
	
	public Voter()
	{
		this.name = "Donald Trump";
		this.idNum = 420;
		vote1 = 'X';
		vote2 = 'X';
		vote3 = 'X';
		vote4 = 'X';
	}
	
	/*****SETTERS*****/
	public void setName(String name)
	{
		name = this.name;
	}
	
	public void setIdNum(int idNum)
	{
		this.idNum = idNum;
	}
	
	public void SetVote1(char vote)
	{
		vote1 = vote;
	}
	
	public void SetVote2(char vote)
	{
		vote2 = vote;
	}
	
	public void SetVote3(char vote)
	{
		vote3 = vote;
	}
	
	public void SetVote4(char vote)
	{
		vote4 = vote;
	}
	
	/*****GETTERS*****/
	public String getName()
	{
		return name;
	}
	
	public int getIdNum()
	{
		return idNum;
	}
	
	public char getVote1()
	{
		return vote1;
	}
	
	public char getVote2()
	{
		return vote2;
	}
	
	public char getVote3()
	{
		return vote3;
	}
	
	public char getVote4()
	{
		return vote4;
	}
	
	//UTILITY
	public String toString()
	{
		return "ID "+idNum+" "+name+" : "
		+Character.toString(vote1)
		+Character.toString(vote2)
		+Character.toString(vote3)
		+Character.toString(vote4);
	}
	
	public boolean equals(Voter x)
	{
		return (x.getName().equals(name) 
		&& x.getIdNum() == idNum 
		&& x.getVote1() == vote1 
		&& x.getVote2() == vote2 
		&& x.getVote3() == vote3 
		&& x.getVote4() == vote4);
	}
	
	//OTHER
	public static String readBallotAnswers()
	{
		String answer, input;
		Scanner keyboard = new Scanner(System.in);
		boolean valid = false;
		answer = "";
		
		System.out.println("CITY OF OCEANSIDE BALLOT - 2016");
		System.out.println("1.   Vote For Mayor");
		System.out.println("	A)   BREWSTER, RED");
		System.out.println("	B)   DOVER, SKIP");
		System.out.println("	C)   PINCHER, PENNY");
		System.out.println("");
		System.out.println("2.   Proposition 22");
		System.out.println("	D)   YES");
		System.out.println("	E)   NO");
		System.out.println("");
		System.out.println("3.   Proposition 24");
		System.out.println("	F)   YES");
		System.out.println("	G)   NO");
		System.out.println("");
		System.out.println("4.   Measure 2");
		System.out.println("	H)   YES");
		System.out.println("	I)   NO");
		
		
		do
		{
			System.out.println(
				"Enter your vote for Mayor('A', 'B', or 'C'): ");
			input = keyboard.nextLine();
			input = input.toUpperCase();
			
			if (input.charAt(0) >= 65 && input.charAt(0) <= 67 && 
			input.length() == 1)
			{
				if(input.charAt(0) == 65)
				{
					System.out.println("Your vote was for RED BREWSTER\n\n");
					answer = answer + input;
				}
				else if(input.charAt(0) == 66)
				{
					System.out.println("Your vote was for SKIP DOVER\n\n");
					answer = answer + input;
				}
				else if(input.charAt(0) == 67)
				{
					System.out.println("Your vote was for PENNY PINCHER\n\n");
					answer = answer + input;
				}
				else
				{
					System.out.println("UNKOWN ERROR");
					System.exit(0);
				}
				valid = true;
			}
			else
			{
				System.out.println("Your answer must be 'A', 'B', or 'C'");
			}
		}while(valid == false);
		
		do
		{
			valid = false;
			System.out.println(
				"Enter your vote for Proposition 22('D' or 'E'): ");
			input = keyboard.nextLine();
			input = input.toUpperCase();
			
			if (input.charAt(0) >= 68 && input.charAt(0) <= 69 &&
			 input.length() == 1)
			{
				if(input.charAt(0) == 68)
				{
					System.out.println("Your vote was for Proposition 22\n\n");
					answer = answer + input;
				}
				else if(input.charAt(0) == 69)
				{
					System.out.println(
						"Your vote was against Proposition 22\n\n");
					answer = answer + input;
				}
				else
				{
					System.out.println("UNKOWN ERROR");
					System.exit(0);
				}
				valid = true;
			}
			else
			{
				System.out.println("Your answer must be 'D' or 'E'");
			}
		}while(valid == false);
		
		do
		{
			valid = false;
			System.out.println(
				"Enter your vote for Proposition 24('F' or 'G'): ");
			input = keyboard.nextLine();
			input = input.toUpperCase();
			
			if (input.charAt(0) >= 70 && input.charAt(0) <= 71 &&
			 input.length() == 1)
			{
				if(input.charAt(0) == 70)
				{
					System.out.println("Your vote was for Proposition 24\n\n");
					answer = answer + input;
				}
				else if(input.charAt(0) == 71)
				{
					System.out.println(
						"Your vote was against Proposition 24\n\n");
					answer = answer + input;
				}
				else
				{
					System.out.println("UNKOWN ERROR");
					System.exit(0);
				}
				valid = true;
			}
			else
			{
				System.out.println("Your answer must be 'F' or 'G'");
			}
		}while(valid == false);
		
		do
		{
			valid = false;
			System.out.println("Enter your vote for Measure 2('H' or 'I'): ");
			input = keyboard.nextLine();
			input = input.toUpperCase();
			
			if (input.charAt(0) >= 72 && input.charAt(0) <= 73 &&
			 input.length() == 1)
			{
				if(input.charAt(0) == 72)
				{
					System.out.println("Your vote was for Measure 2\n\n");
					answer = answer + input;
				}
				else if(input.charAt(0) == 73)
				{
					System.out.println("Your vote was against Measure 2\n\n");
					answer = answer + input;
				}
				else
				{
					System.out.println("UNKOWN ERROR");
					System.exit(0);
				}
				valid = true;
			}
			else
			{
				System.out.println("Your answer must be 'H' or 'I'");
			}
		}while(valid == false);
		return answer;
	}
}