/*****************************
 *CHAPTER NUMBER: Chapter 18
 *FILE NAME: Swing II Final Homework
 *PROGRAMMER: Jack Rollinson
 *DATE LAST MODIFIED: 12/12/2016
 *
 *====PROBLEM======
 *Write a program to read in data from the humphrey-img.txt and display it
 *in a JFrame window. 
 *
 *====ALGORITHM====
 *import all packages needed for guis and file i/o
 *set constants for the width and height of the window
 *create a new driver object and make the gui visible in the main method
 *make a 2D array, in the constructor, read all the coridinates from the text
 *	file into the array
 *make a paint method to draw the pixels and a tone method to change the color shade
 *using nested for loops draw pixels at each x and y cordinates, and use the tone
 *	method to determine the color of each pixel.
 *****************************/

//IMPORTS
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;
import java.io.*;

public class Driver extends JFrame
{
	//CONSTANTS
	public static final int WIDTH = 500;
	public static final int HIEGHT = 500;
	
	//INSTANCE VARIABLES
	private int[][] cordinates;
	private int height;
	
	//MAIN
	public static void main(String[] args)
	{
		Driver humphrey = new Driver();
		humphrey.setVisible(true);
	}
	
	//CONSTRUCTOR
	public Driver()
	{
		super("Humphrey Image");
		setSize(WIDTH, HIEGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.WHITE);
		
		Scanner inputStream = null;
		
	      try
	      {
	          inputStream = new Scanner(new FileInputStream("humphrey-img.txt"));
	      }
	      catch(FileNotFoundException e)
	      {
	          System.out.println("File readFile.txt was not found");
	          System.out.println("or could not be opened");
	          System.exit(0);
	      }
	      catch(Exception e)
	      {
	      	System.out.println(e.getMessage());
	      }
	      
	      height = inputStream.nextInt();
	      cordinates = new int[height][height];
	      for(int i= 0 ; i < height ; i++)
	      {
	      	for(int x = 0; x < height ; x++)
	      	{
	      		cordinates[i][x] = inputStream.nextInt();
	      	}
	      }
	      inputStream.close();
	}
	
	//METHODS
	public void paint(Graphics g)
	{
		super.paint(g);
		newTone();
		for(int i= 0 ; i < height ; i++)
	    {
	    	for(int x = 0; x < height ; x++)
	      	{
	      		Color color = new Color(cordinates[i][x], cordinates[i][x], cordinates[i][x]);
	      		g.setColor(color);
	      		g.drawLine(100 + x, 100 + i, 100 + x, 100 + i);
	      	}
	    }
	}
	public void newTone()
	{
		int min;
		int max;
		
		min = 255;
		for(int i= 0 ; i < height ; i++)
	    {
	    	for(int x = 0; x < height ; x++)
	      	{
      			if(cordinates[i][x] < min)
      			{
      				min = cordinates[i][x];
      			}
	      	}
	    }
	    max = 0;
	    for(int i= 0 ; i < height ; i++)
	    {
	    	for(int x = 0; x < height ; x++)
	      	{
      			if(cordinates[i][x] > max)
      			{
      				max = cordinates[i][x];
      			}
	      	}
	    }
		for(int i= 0 ; i < height ; i++)
	    {
	    	for(int x = 0; x < height ; x++)
	      	{
	      			cordinates[i][x] = (255 * (cordinates[i][x] - min))/ (max - min);
	      	}
	    }
	}
}