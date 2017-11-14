/*****************************
 *CHAPTER NUMBER: Chapter 17/18 continued 
 *FILE NAME: Driver (EXTRA CREDIT)
 *PROGRAMMER: Jack Rollinson
 *DATE LAST MODIFIED: 12/12/2016
 *
 *====PROBLEM======
 *extra credit number 6
 *
 *write a gui program to sample different fonts. the user enteres a linge
 *of text in a text field. the user then selects a font from the a font menu.
 *Offer the three guaranteed fonts and at least two other fonts. the user can
 *also select any style modifiers (bold / italic) from a style menu. Also allow
 *the user to select the size of the font.
 *
 *====ALGORITHM====
 *import all packages needed for gui's
 *create instance variables for the style (bold / italic)
 *create instance variables for the current font and size
 *create main menu with gui object and set window visable
 *create a class constructor
 *	constructor needs three different menus:
 *		size > should hold all font sizes
 *		font > should hold 5 different fonts
 *		style > gives user option between bold or italics
 *	add a text field and a "display button" to the constructor
 *Have the user type in the text field
 *After selecting the font, size, and style
 *click on the display button
 *change the text in the text box to the specified font, size and style
 *****************************/
 
//IMPORTS
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Driver extends JFrame implements ActionListener 
{   
	//CONSTANTS
	public static final int WIDTH = 500;
	public static final int HIEGHT = 500;
	
	//INSTANCE VARIABLES
    private boolean Italic;
    private boolean Bold;
    private JTextField IO;

    private int currentSize = 12;
    private String currentName = "Times New Roman";
	
	//MAIN
	public static void main(String args[]) 
    {
        Driver gui = new Driver();
        //gui.pack();
        gui.setVisible(true);
    }
    
    //CONSTRUCTOR
    public Driver() 
    {
        super("Pick a Font");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
		
		//MENU
        JMenuBar bar = new JMenuBar();
        JMenu fontMenu, sizeMenu, styleMenu;
        fontMenu = new JMenu("Font");
        sizeMenu = new JMenu("Size");
        styleMenu = new JMenu("Style");
		
		//FONT SIZES
        JMenuItem fontSize_9 = new JMenuItem("9");
        fontSize_9.addActionListener(this);
        sizeMenu.add(fontSize_9);

        JMenuItem fontSize_10 = new JMenuItem("10");
        fontSize_10.addActionListener(this);
        sizeMenu.add(fontSize_10);

        JMenuItem fontSize_12 = new JMenuItem("12");
        fontSize_12.addActionListener(this);
        sizeMenu.add(fontSize_12);

        JMenuItem fontSize_14 = new JMenuItem("14");
        fontSize_14.addActionListener(this);
        sizeMenu.add(fontSize_14);

        JMenuItem fontSize_16 = new JMenuItem("16");
        fontSize_16.addActionListener(this);
        sizeMenu.add(fontSize_16);

        JMenuItem fontSize_24 = new JMenuItem("24");
        fontSize_24.addActionListener(this);
        sizeMenu.add(fontSize_24);

        JMenuItem fontSize_32 = new JMenuItem("32");
        fontSize_32.addActionListener(this);
        sizeMenu.add(fontSize_32);
        
        //FONTS
        JMenuItem font_monospaced = new JMenuItem("SansSerif");
        font_monospaced.addActionListener(this);
        fontMenu.add(font_monospaced);

        JMenuItem font_sansSerif = new JMenuItem("Verdana");
        font_sansSerif.addActionListener(this);
        fontMenu.add(font_sansSerif);

        JMenuItem font_serif = new JMenuItem("Arial");
        font_serif.addActionListener(this);
        fontMenu.add(font_serif);

        JMenuItem font_times = new JMenuItem("FreeMano");
        font_times.addActionListener(this);
        fontMenu.add(font_times);

        JMenuItem font_courier = new JMenuItem("Courier New");
        font_courier.addActionListener(this);
        fontMenu.add(font_courier);
		
		//STYLE
        JMenuItem boldMenu = new JMenuItem("Bold");
        boldMenu.addActionListener(this);
        styleMenu.add(boldMenu);

        JMenuItem italicMenu = new JMenuItem("Italic");
        italicMenu.addActionListener(this);
        styleMenu.add(italicMenu);

        bar.add(fontMenu);
        bar.add(sizeMenu);
        bar.add(styleMenu);

        IO = new JTextField(30);
        JPanel top;
        top = new JPanel();
        top.add(bar);
        top.add(IO);

        JButton displayButton = new JButton("Display");
        displayButton.addActionListener(this);
        displayButton.setActionCommand("Display");

        add(top, BorderLayout.NORTH);
        add(displayButton, BorderLayout.SOUTH);

        currentName = "Times New Roman";
        currentSize = 12;
        Italic = false;
        Bold = false;
    }
	
	//METHODS
    public void paint(Graphics g) 
    {
        super.paint(g);
        Font currentFont = null;
        if (!Bold && !Italic)
         currentFont = new Font(currentName, Font.PLAIN, currentSize);
        else if (Bold && !Italic)
         currentFont = new Font(currentName, Font.BOLD, currentSize);
        else if (!Bold && Italic)
         currentFont = new Font(currentName, Font.ITALIC, currentSize);
        else
         currentFont = new Font(currentName, Font.BOLD | Font.ITALIC, currentSize);

        g.setFont(currentFont);
        g.drawString(IO.getText(), 50, 100);
    }
	
	//ACTION LISTENERS
    public void actionPerformed(ActionEvent e) 
    {
        String c = e.getActionCommand();

        if (c.equals("9") || c.equals("10") || c.equals("12") || c.equals("14") || c.equals("16") || c.equals("24") || c.equals("32")) 
        {
           currentSize = Integer.parseInt(c);
        }

        if (c.equals("SansSerif") || c.equals("Verdana") || c.equals("Arial") || c.equals("FreeMano") || c.equals("Courier New")) 
        {
           currentName = c;
        }

        if (c.equals("Bold")) 
        {
           Bold = !Bold;
        }

        if (c.equals("Italic")) 
        {
           Italic = !Italic;
        }

        if (c.equals("Display")) 
        {
           repaint();
        }
    }
}