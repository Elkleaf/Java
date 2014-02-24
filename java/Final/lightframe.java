//Programmer's name:  Matthew Elko
//Email address:      elkleaf@csu.fullerton.edu
//Course:             CPSC223j
//Assignment number:  5th assignment
//Due date:           2012-Dec-12
//website URL: www.ecs.fullerton.edu/~elkleaf
//Project: A program that demontrates a moving ball across a pool table and bouncing off walls
//This file builds the frame and contains the action handlers and the clock that is used for the program
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.Timer;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JOptionPane;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;


public class lightframe extends JFrame 
{    
     private Timer systemclock;//the timer of the program
	 private int delayinterval; //the delayinterval used for the timer object
     actionHandler myhandler;//the actionhandler
	 private Graphicalpanel graphicalpanel;
	 
	 //private mainapplet myapplet;
	 

     public lightframe(/*mainapplet mainapp*/)
         {super("LED");
		  //myapplet = mainapp;
		  myhandler = new actionHandler(); //handler that handles the all the actions
		  
          //Make 3 panels and place them from top to bottom onto any object of type Gameinterface.
          //Make the 1st panel
          
          //Make the 2nd panel
          graphicalpanel = new Graphicalpanel(true);
		  add(graphicalpanel,BorderLayout.CENTER);
		  //Make the 3rd panel
		  delayinterval = (int)Math.floor(1000/400);
		  systemclock = new Timer(delayinterval, myhandler);
		  systemclock.start();
		  
		  
		  
		  
		  
		  
		  
		  //setSize(960,640);
		  //setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         }//End of Gameinterface constructor.
		 

     private class actionHandler implements ActionListener
     {    public void actionPerformed(ActionEvent event)
              {			
			   
				if(event.getSource()==systemclock)//what will happen every tick of the clock
					{
						
						graphicalpanel.changecolor();
						graphicalpanel.repaint();
						
						
						 
						 
                        
					}
					
				
				
				
               
              }
			  		
     }// end actionHandler
	 
	 

}//End of Gameinterface
              