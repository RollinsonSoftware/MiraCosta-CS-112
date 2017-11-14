/*****************************
 *CHAPTER NUMBER: 17 GUIs
 *FILE NAME: Driver.java
 *PROGRAMMER: Jack Rollinson
 *DATE LAST MODIFIED: 12/5/2016
 *
 *=====PROBLEM=====
 *Design and code a Swing GUI to translate text that is input in English
 *into Pig Latin. You can assume that the sentence contains no punctuation.
 *
 *====ALGORITHM====
 *Set GUI visible in the main method
 *Create basic gui window in the constructor
 *Create one panel for the english word, and one for the translated
 *Create a text field for each panel and add them to the panels they corrispond to.
 *Make a Button panel and add two buttons
 *the Clear button should erase the text from ALL text fields
 *the Translate button should handel ALL translations
 *Use substring to manipulate the strings and translate them.
 *When translating check for vowels first and then if the first letter isnt one
 *then translate accordingly for the rest of the alphabet.
 *****************************/

//IMPORTS
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Driver extends JFrame implements ActionListener
{
	//CONSTANTS
	public static final int WIDTH = 400;
	public static final int HEIGHT = 200;
	public static final int NUMBER_OF_CHARS = 12;
	
	//INSTANCE VARIABLES
	private JTextField word;
	private JTextField translated;
	
	//MAIN
	public static void main(String[] args)
	{
		Driver gui = new Driver();
		
		System.out.println("Preparing window...");
		gui.pack();
		gui.setVisible(true);
	}
	//CONSTRUCTORS
	public Driver()
	{
		super("Translator");
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(3,1));
		
		JPanel wordPanel = new JPanel();
		wordPanel.setLayout(new BorderLayout());
		wordPanel.setBackground(Color.WHITE);
		
		word = new JTextField(NUMBER_OF_CHARS);
		wordPanel.add(word, BorderLayout.SOUTH);
		JLabel wordLabel = new JLabel("Enter a word to translate:");
		wordPanel.add(wordLabel, BorderLayout.CENTER); 
		
		add(wordPanel);
		
		JPanel translatedPanel = new JPanel();
		translatedPanel.setLayout(new BorderLayout());
		translatedPanel.setBackground(Color.WHITE);
		
		translated = new JTextField(NUMBER_OF_CHARS);
		translatedPanel.add(translated, BorderLayout.SOUTH);
		JLabel translatedLabel = new JLabel("The Pig Latin translation is:");
		translatedPanel.add(translatedLabel, BorderLayout.CENTER);
		
		add(translatedPanel);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.setBackground(Color.WHITE);
		
		JButton actionButton = new JButton("Translate");
		actionButton.addActionListener(this);
		buttonPanel.add(actionButton);
		
		JButton clearButton = new JButton("Clear");
		clearButton.addActionListener(this);
		buttonPanel.add(clearButton);
		
		add(buttonPanel);
	}
	//METHODS
	public void actionPerformed(ActionEvent e)
	{
		String actionCommand = e.getActionCommand();
		
		if(actionCommand.equals("Translate"))
		{
			String input = word.getText();
			
			if(input.charAt(0) == 'a' ||
			   input.charAt(0) == 'e' ||
			   input.charAt(0) == 'i' ||
			   input.charAt(0) == 'o' ||
			   input.charAt(0) == 'u')
			{
				input += "way";
			}
			else
			{
				char first = input.charAt(0);
				input = input.substring(1) + first + "ay";
			}
			
			translated.setText(input);
		}
		else if(actionCommand.equals("Clear"))
		{
			word.setText("");
			translated.setText("");
		}
		else
		{
			word.setText("Unexpected error...");
			translated.setText("Unexpected error...");
		}
	}
}