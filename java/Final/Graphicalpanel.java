//Programmer's name:  Matthew Elko
//Email address:      elkleaf@csu.fullerton.edu
//Course:             CPSC223j
//Assignment number:  5th assignment
//Due date:           2012-Dec-12
//Project: A program that creates a working pong game
//website URL: www.ecs.fullerton.edu/~elkleaf
//File name: Graphicalpanel.java
//Description: This is one module in the program.  This module
//defines the central panel of the user interface.  This central panel contains 
//the Graphic area.

import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Color;
import java.util.Random;


public class Graphicalpanel extends JPanel
{    int widthofgraphicalarea;
     int heightofgraphicalarea;
	 int ballradius = 20;
     double ballxcoordinate;
     double ballycoordinate;//will start the ball in the middle of the screen on the left side
	 boolean gamestart;
	 boolean resetgame;
	 private Random rand = new Random();//random number generator to help with changing colors at random
	 private Color randomColor = Color.WHITE;//the Color varibale. initially set to white when the game starts
	 private Color LED = Color.WHITE;
	 
	 
	 public Graphicalpanel(boolean initial)
	 {
		gamestart = initial;
	 }

     public void paintComponent(Graphics graphicarea)
     {super.paintComponent(graphicarea);
      this.setBackground(Color.black);
      widthofgraphicalarea = getWidth();
      heightofgraphicalarea = getHeight();
	  if(gamestart)
	  {
		ballxcoordinate = widthofgraphicalarea/2- 2*ballradius;
		ballycoordinate = heightofgraphicalarea/2 - (2*ballradius);
		gamestart = false;
	  }
	    
  
      //Give the ball a white color
      graphicarea.setColor(LED);
	  //this if statement checks to see if the ball has hit a horizontal side. when it does, it changes color
	  
      //The 3rd and 4th parameters below represent the diameter of the ball.
      graphicarea.fillOval((int)ballxcoordinate,(int)ballycoordinate,2*ballradius,2*ballradius);
	  
	  
     }//End of method paintComponent

     //The next method will change the balls direction based on the inputed angle
     public void REd()
     {    
		LED = Color.RED;
	  
		
		repaint();
		LED = Color.GREEN;
		
		repaint();
		LED = Color.BLUE;
		
		repaint();
		LED = Color.MAGENTA;
		
		repaint();
		LED = Color.CYAN;
		
		repaint();
		LED = Color.YELLOW;
		
		repaint();
		LED = Color.ORANGE;
		
		repaint();
		
     }
	 
	 
	
}//End of Graphicalpanel

