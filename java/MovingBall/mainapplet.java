//Programmer's name:  Matthew Elko
//Email address:      elkleaf@csu.fullerton.edu
//Course:             CPSC223j
//Assignment number:  5th assignment
//Due date:           2012-Dec-12
//Project: A program that creates a pong game
//website URL: www.ecs.fullerton.edu/~elkleaf
//Purpose for this file: The main driver for a Java applet.
import javax.swing.JFrame;
import javax.swing.JApplet;
import java.awt.Graphics;

public class mainapplet extends JApplet
{
	private JFrame appletframe;
	
	
	public void init()
		{
			appletframe = new Gameinterface(this);
			appletframe.setVisible(true);
			appletframe.setEnabled(true);
			
		}//end init()
		
		public void paint(Graphics graphicalareaoftheapplet)
			{
				super.paint(graphicalareaoftheapplet);
				graphicalareaoftheapplet.drawRect (15,10,270,20);
				
			}//end of paint
			
		public void close()
			{
				appletframe.dispose();
				appletframe = null;
			}
}//end of mainapplet