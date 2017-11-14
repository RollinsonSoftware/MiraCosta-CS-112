/*****************************
 *CHAPTER NUMBER: Chapter 18
 *FILE NAME: Swing II Final Homework
 *PROGRAMMER: Jack Rollinson
 *DATE LAST MODIFIED: 12/12/2016
 *
 *====PROBLEM======
 *Write a gui program that ses the methods in the graphics class to draw a smiley
 *face when the window is activated, and a frowny face when the window is deactivated
 *This will require use of the WindowListener to detect the aactivation or deactivation
 *of the window.
 *
 *====ALGORITHM====
 *import all gui packages.
 *create constants for the width and height of the gui
 *create constants for the the dimentions of the face and its features.
 *create a boolean instance varibale that changes if the window is activated or
 *	deactivated.
 *create a new gui object in the main method and set the window visible.
 *create a driver constructor that has a window listener and the boolean should 
 *	defualt to false.
 *Make a paint method that does all the actual drawing of the face
 *create a windowlistener in an inner class that:
 *	IF window is activated
 *		draw a smiley face
 *	ELSE IF window is deactivated
 *		redraw mouth upside down.
 *	ELSE IF any other window listener action
 *		do nothing
 *****************************/
 
 //IMPORTS
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Driver extends JFrame 
{
	//CONSTANTS:
	
	//GUI WINDOW
	public static final int HEIGHT = 400;
    public static final int WIDTH = 400;
    
    //FACE
    public static final int FACE_X_CORDINATE = 100;
    public static final int FACE_Y_CORDINATE = 100;
    public static final int FACE_DIAMETER = 200;
    
    //MOUTH
    public static final int MOUTH_X_CORDINATE = FACE_X_CORDINATE + 50;
    public static final int MOUTH_Y_CORDINATE = FACE_Y_CORDINATE + 100;
    public static final int MOUTH_WIDTH = 100;
    public static final int MOUTH_HEIGHT = 50;
    public static final int MOUTH_SMILE_START_ANGLE = 180;
    public static final int MOUTH_FROWN_START_ANGLE = 0;
    public static final int MOUTH_ARC = 180;
    
    //EYES
    public static final int RIGHT_EYE_X_CORDINATE = FACE_X_CORDINATE + 55;
    public static final int RIGHT_EYE_Y_CORDINATE = FACE_Y_CORDINATE + 60;
    public static final int LEFT_EYE_X_CORDINATE = FACE_X_CORDINATE + 130;
    public static final int LEFT_EYE_Y_CORDINATE = FACE_Y_CORDINATE + 60;
    public static final int EYE_WIDTH = 30;
    public static final int EYE_HEIGHT = 20;
  	
  	//INSTANCE VARIABLES
    public boolean isSmile;
    
    //MAIN
	public static void main(String[] args)
	{
		Driver gui = new Driver();
		gui.setVisible(true);
	}
	
	//CONSTRUCTOR 
	public Driver()
	{
		setSize(WIDTH, HEIGHT);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Smile GUI");
		setLayout(new BorderLayout());
		getContentPane().setBackground(Color.WHITE);
		addWindowListener(new MouthAction());
		
		isSmile = false;
	}
	
	//METHODS
	public void paint(Graphics e)
	{
		super.paint(e);
		e.setColor(Color.YELLOW);
		e.fillOval(FACE_X_CORDINATE, FACE_Y_CORDINATE, FACE_DIAMETER, FACE_DIAMETER);
		e.setColor(Color.BLACK);
		e.fillOval(RIGHT_EYE_X_CORDINATE, RIGHT_EYE_Y_CORDINATE, EYE_WIDTH, EYE_HEIGHT);
		e.fillOval(LEFT_EYE_X_CORDINATE, LEFT_EYE_Y_CORDINATE, EYE_WIDTH, EYE_HEIGHT);
		
		if(isSmile)
			e.drawArc(MOUTH_X_CORDINATE, MOUTH_Y_CORDINATE, MOUTH_WIDTH, MOUTH_HEIGHT, MOUTH_SMILE_START_ANGLE, MOUTH_ARC);
		else
			e.drawArc(MOUTH_X_CORDINATE, MOUTH_Y_CORDINATE, MOUTH_WIDTH, MOUTH_HEIGHT, MOUTH_FROWN_START_ANGLE, MOUTH_ARC);
	}
	
	public class MouthAction implements WindowListener 
	{
		public void windowActivated(WindowEvent e) 
		{
			isSmile = true;
			repaint();
		}
		public void windowDeactivated(WindowEvent e)
		{
			isSmile = false;
			repaint();
		}
		
		//only preforms actions if the window is active/deactive
		public void windowClosed(WindowEvent e) 
		{
		}
		public void windowClosing(WindowEvent e)
		{
		}
		public void windowDeiconified(WindowEvent e)
		{
		}
		public void windowIconified(WindowEvent e)
		{
		}
		public void windowOpened(WindowEvent e)
		{
		}
	}
}