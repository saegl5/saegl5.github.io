// This program creates an equivalent fraction, using the least common denominator

// Compile with OpenJDK or Oracle JDK: javac EqualFractionsRev5.java
// Add Java class file to HTML document: <applet code = "EqualFractionsRev5.class" width = 400 height = 40></applet>
// View HTML document in web browser

import javax.swing.*;  //necessary to use JOptionPane
import java.awt.*;
import java.awt.event.*;

public class EqualFractionsRev5 extends JApplet implements ActionListener
{
	JLabel option = new JLabel("Would you like to practice creating equivalent fractions?");
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
		int x, y1, y2, z1, z2; //user is allowed to initiate values for these

		//request user input to initialize x, y and z
		input = JOptionPane.showInputDialog(null, "Please input the least common denominator: ");
		x = Integer.parseInt(input);

		input = JOptionPane.showInputDialog(null, "Please input the numerator of one fraction: ");
		y1 = Integer.parseInt(input);

		input = JOptionPane.showInputDialog(null, y1 + "/\nPlease input the denominator of that fraction (the original denominator, not the one you plan to change it do): ");
		y2 = Integer.parseInt(input);

		//check if least common denominator is divisible by denominator
			//if not divisible, then output warning that program will not work properly
			if(x%y2 == 0)
				; //do nothing
			else
				JOptionPane.showMessageDialog(null, "Warning! Either the least common denominator or the original denominator is incorrect. This program will not work properly, unless you exit and revise your input.");

		input = JOptionPane.showInputDialog(null, y1 + "/" + y2 + "=\nNow, create a fraction that is equivalent to " + y1 + "/" + y2 + ", using the least common denominator of " + x + ".\nNumerator: ");
		z1 = Integer.parseInt(input);

		input = JOptionPane.showInputDialog(null, y1 + "/" + y2 + "=" + z1 + "/\nDenominator: ");
		z2 = Integer.parseInt(input);

		int quotient = x/y2; //divide least common denominator by denominator
		int z1eq = y1*quotient; //multiply the numerator and denominator by the quotient
		int z2eq = y2*quotient;

		//output a response to the user's guess of the equivalent fraction
			//if the user guesses incorrectly, ask the user to guess again
			//if the user then guesses correctly (or guesses correctly the third time), output confirmation
			//otherwise, output the correct answer
			for(int i=0; i<2; i++)
			{
				if((z1 != z1eq) || (z2 != z2eq))
				{
					if(i == 0)
					{
						if(z1/y1 == z2/y2)
						{
							input = JOptionPane.showInputDialog(null, "Well, yes, " + y1 + "/" + y2 + " is equivalent to " + z1 + "/" + z2 + ", but you need to use the least common denominator.\nTry again.\n\nHint: the denominator must be " + y2 + "*" + quotient + ", where " + y2 + " is the denominator of the original fraction.\n\nNumerator of equivalent fraction: ");
							z1 = Integer.parseInt(input);

							input = JOptionPane.showInputDialog(null, y1 + "/" + y2 + "=" + z1 + "/\nDenominator: ");
							z2 = Integer.parseInt(input);
						}
						else
						{
							input = JOptionPane.showInputDialog(null, "Incorrect! " + y1 + "/" + y2 + " is not equivalent to " + z1 + "/" + z2 + ".\nTry again.\n\nHint: the denominator must be " + y2 + "*" + quotient + ", where " + y2 + " is the denominator of the original fraction.\n\nNumerator of equivalent fraction: ");
							z1 = Integer.parseInt(input);

							input = JOptionPane.showInputDialog(null, y1 + "/" + y2 + "=" + z1 + "/\nDenominator: ");
							z2 = Integer.parseInt(input);
						}
					}
					else
					{
						if(z1/y1 == z2/y2)
						{
							input = JOptionPane.showInputDialog(null, "Well, yes, " + y1 + "/" + y2 + " is equivalent to " + z1 + "/" + z2 + ", but you need to use the least common denominator.\nTry again.\n\nAnother hint: the numerator must be " + y1 + "*" + quotient + ", where " + y1 + " is the numerator of the original fraction.\n\nNumerator of equivalent fraction: ");
							z1 = Integer.parseInt(input);

							input = JOptionPane.showInputDialog(null, y1 + "/" + y2 + "=" + z1 + "/\nDenominator: ");
							z2 = Integer.parseInt(input);
						}
						else
						{
							input = JOptionPane.showInputDialog(null, "Incorrect! " + y1 + "/" + y2 + " is not equivalent to " + z1 + "/" + z2 + ".\nTry again.\n\nAnother hint: the numerator must be " + y1 + "*" + quotient + ", where " + y1 + " is the numerator of the original fraction.\n\nNumerator of equivalent fraction: ");
							z1 = Integer.parseInt(input);

							input = JOptionPane.showInputDialog(null, y1 + "/" + y2 + "=" + z1 + "/\nDenominator: ");
							z2 = Integer.parseInt(input);
						}
					}
				}
			}
	
			if((z1 != z1eq) || (z2 != z2eq))
				JOptionPane.showMessageDialog(null, "Sorry, but " + y1 + "/" + y2 + "=" + z1eq + "/" + z2eq + ".");
			else
				JOptionPane.showMessageDialog(null, "Correct! " + y1 + "/" + y2 + "=" + z1eq + "/" + z2eq + ".");

	} //end of actionPerformed
} //end of class EqualFractionsRev5