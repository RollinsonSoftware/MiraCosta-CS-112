import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Driver extends JFrame implements ActionListener
{
	public static final int WIDTH = 300;
	public static final int HEIGHT = 200;
	
	private JPanel beveledPanel;
	private JPanel etchedPanel;
	private JPanel linedPanel;
	
	private JTextField description;
	
	public static void main(String[] args)
	{
		Driver gui = new Driver();
		gui.setVisible(true);
	}
	public Driver()
	{
		super("Border Tester");
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(1,1));
		
		beveledPanel = new JPanel();
		beveledPanel.setBackground(Color.WHITE);
		add(beveledPanel);
		
		etchedPanel = new JPanel();
		etchedPanel.setBackground(Color.WHITE);
		add(etchedPanel);
		
		linedPanel = new JPanel();
		linedPanel.setBackground(Color.WHITE);
		add(linedPanel);
		
		description = new JTextField(20);
		beveledPanel.add(description, BorderLayout.SOUTH);
		JLabel descriptionLabel = new JLabel("Border:");
		descriptionLabel.createBevelBorder(1, Color.WHITE, Color.BLACK);
		beveledPanel.add(descriptionLabel, BorderLayout.CENTER);
		
		JMenu borderMenu = new JMenu("Choose Border");
		
		JMenuItem beveledChoice = new JMenuItem("Beveled");
		beveledChoice.addActionListener(this);
		borderMenu.add(beveledChoice);
		
		JMenuItem etchedChoice = new JMenuItem("Etched");
		etchedChoice.addActionListener(this);
		borderMenu.add(etchedChoice);
		
		JMenuItem linedChoice = new JMenuItem("Lined");
		linedChoice.addActionListener(this);
		borderMenu.add(linedChoice);
		
		JMenuBar bar = new JMenuBar();
		bar.add(borderMenu);
		setJMenuBar(bar);
	}
	public void actionPerformed(ActionEvent e)
	{
		String buttonString = e.getActionCommand();
		
		//if(buttonString.equals("Beveled"))
			
	}
}