// This program computes the least common denominator between two fractions

// Compile with OpenJDK or Oracle JDK: javac LeastCommonDenominator4.java
// Add Java class file to HTML document: <applet code = "LeastCommonDenominator4.class" width = 450 height = 40></applet>
// View HTML document in web browser

import javax.swing.*;  //necessary to use JOptionPane
import java.awt.*;
import java.awt.event.*;

public class LeastCommonDenominator4 extends JApplet implements ActionListener
{
	JLabel option = new JLabel("Would you like to practice finding a least common denominator?");
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
		int i = 1, j = 1; //indexes i and j, for computing multiples

		//request user input to initialize x, y and z
		input = JOptionPane.showInputDialog(null, "Please enter a denominator: ");
		x = Integer.parseInt(input);

		input = JOptionPane.showInputDialog(null, "Please enter another denominator: ");
		y = Integer.parseInt(input);

		input = JOptionPane.showInputDialog(null, "Please guess what the least common denominator is: ");
		z = Integer.parseInt(input);

		//if x = y, the least common denominator is x (arbitrarily, since both are equal)
		//if x != y, compute multiples of x and y until multiples are equal
			//more specifically, if one multiple is smaller than another,
			//then a greater multiple of that (smaller one) is computed
			//this process is repeated until x*i = y*j
			while ((x*i) != (y*j))
			{
				if ((x*i) < (y*j))
					i++;
				else if ((x*i) > (y*j))
					j++;
			}

		//output a response to the user's guess of the least common denominator
			//if the user guesses incorrectly, ask the user to guess again
			//if the user then guesses correctly (or guesses correctly the third time), output confirmation
			//otherwise, output the correct answer
			for(int k=0; k<2; k++)
			{
				if(z != (x*i))
				{
					input = JOptionPane.showInputDialog(null, "Incorrect! Please guess again.\n\nWhat the least common denominator, given denominators " + x + " and " + y + "? ");
					z = Integer.parseInt(input);
				}
			}
	
			if(z != (x*i))
				JOptionPane.showMessageDialog(null, "Sorry, but the least common denominator is " + (x*i) + ".");
			else
				JOptionPane.showMessageDialog(null, "Correct! The least common denominator is " + (x*i) + ".");

	} //end of actionPerformed
} //end of class LeastCommonDenominator4