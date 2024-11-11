// This program computes the product of two whole numbers

// Compile with OpenJDK or Oracle JDK: javac Multiplication3.java
// Add Java class file to HTML document: <applet code = "Multiplication3.class" width = 400 height = 40></applet>
// View HTML document in web browser

import javax.swing.*;  //necessary to use JOptionPane
import java.awt.*;
import java.awt.event.*;

public class Multiplication3 extends JApplet implements ActionListener
{
	JLabel option = new JLabel("Would you like to practice multiplying whole numbers?");
	JButton yes = new JButton("Yes");

	public void init()
	{
		setLayout(new FlowLayout());
		add(option);
		add(yes);
		yes.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e)
	{

		String input; //enables user to be able provide input, through JOptionPane
		int x, y, z; //user is allowed to initiate values for these

		//request user input to initialize x, y and z
		input = JOptionPane.showInputDialog(null, "Please input one whole number: ");
		x = Integer.parseInt(input);

		input = JOptionPane.showInputDialog(null, "Please input another whole number: ");
		y = Integer.parseInt(input);

		input = JOptionPane.showInputDialog(null, x + "x" + y + "\nPlease guess the product of " + x + " and " + y + ": ");
		z = Integer.parseInt(input);

		int product = x*y; //calculate true product

		//output a response to the user's guess of the equivalent fraction
			//if the user guesses incorrectly, ask the user to guess again
			//if the user then guesses correctly (or guesses correctly the third time), output confirmation
			//otherwise, output the correct answer
			for(int i=0; i<2; i++)
			{
				if(z != product)
				{
					if(i == 0)
					{
						input = JOptionPane.showInputDialog(null, "Incorrect! " + x + "x" + y + " does not equal " + z + ".\nTry again.\n\nHint: add " + x + " " + y + "s together.\n\n" + x + "x" + y + "= ");
						z = Integer.parseInt(input);
					}
					else
					{
						input = JOptionPane.showInputDialog(null, "Incorrect! " + x + "x" + y + " does not equal " + z + ".\nTry again.\n\nHint: alternatively, add " + y + " " + x + "s together.\n\n" + x + "x" + y + "= ");
						z = Integer.parseInt(input);
					}
				}
			}
	
			if(z != product)
				JOptionPane.showMessageDialog(null, "Sorry, but " + x + "x" + y + "=" + product + ".");
			else
				JOptionPane.showMessageDialog(null, "Correct! " + x + "x" + y + "=" + product + ".");

	} //end of actionPerformed
} //end of class Multiplication3