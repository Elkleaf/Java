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
     final int ballradius = 8;
	 final int paddleheight = 100;
	 final int paddlewidth = 8;
     double ballxcoordinate;
     double ballycoordinate;//will start the ball in the middle of the screen on the left side
	 double xcord;
	 double ycord;
	 int leftpaddleycord;
	 int rightpaddleycor;
	 boolean gamestart;
	 boolean resetgame;
	 boolean point;//boolean for GetPoint() function to help decide which player gets a point
	 double deltaX;
	 double deltaY;//determines whether ball is moving up or down
	 private Random rand = new Random();//random number generator to help with changing colors at random
	 private Color randomColor = Color.WHITE;//the Color varibale. initially set to white when the game starts
	 
	 
	 public Graphicalpanel(boolean initial)
	 {
		gamestart = initial;
	 }

     public void paintComponent(Graphics graphicarea)
     {super.paintComponent(graphicarea);
      this.setBackground(Color.red);
      widthofgraphicalarea = getWidth();
      heightofgraphicalarea = getHeight();
	  if(gamestart)
	  {
		ballxcoordinate = widthofgraphicalarea/2- 2*ballradius;
		ballycoordinate = heightofgraphicalarea/2 - (2*ballradius);
		leftpaddleycord = heightofgraphicalarea/2 -(paddleheight/2);
		rightpaddleycor = heightofgraphicalarea/2 -(paddleheight/2);
		gamestart = false;
	  }
	    
  
      //Give the ball a white color
      graphicarea.setColor(randomColor);
	  //this if statement checks to see if the ball has hit a horizontal side. when it does, it changes color
	  if(ballycoordinate-deltaY <0||ballycoordinate+(2*ballradius)-deltaY > heightofgraphicalarea)
				{
					float r = rand.nextFloat();
					float g = rand.nextFloat();
					float b = rand.nextFloat();
					randomColor = new Color(r, g, b);
					graphicarea.setColor(randomColor);
					deltaY*= -1;
				}
      //The 3rd and 4th parameters below represent the diameter of the ball.
      graphicarea.fillOval((int)ballxcoordinate,(int)ballycoordinate,2*ballradius,2*ballradius);
	  graphicarea.fillRect(0, leftpaddleycord, paddlewidth, paddleheight);
	  graphicarea.fillRect(widthofgraphicalarea-paddlewidth, rightpaddleycor, paddlewidth, paddleheight);
	  
     }//End of method paintComponent

     //The next method will change the balls direction based on the inputed angle
     public boolean moveball()
     {    boolean successfulmove = false; //Assume no move unless proven otherwise.
	      
		  double y = (double)ballycoordinate;
		  if(ballycoordinate-deltaY <0||ballycoordinate+(2*ballradius)-deltaY > heightofgraphicalarea)
				{
					deltaY*= -1;//if the ball has hit a horizontal side, then deltaY changes so it will bounce that ball
				}
		 
          if(ballxcoordinate+2*ballradius < widthofgraphicalarea-deltaX || ballxcoordinate+2*ballradius > 0)
               {
				
				ballycoordinate-= deltaY;
				ballxcoordinate += deltaX;
                successfulmove = true;
				
               }
			   //checks to see if ball boucnes off right paddle
		  if(ballxcoordinate+2*ballradius > widthofgraphicalarea-paddlewidth && rightpaddleycor<ballycoordinate+(2*ballradius)-deltaY && ballycoordinate+2*ballradius-deltaY<rightpaddleycor+paddleheight)
			{
				
				deltaX *=-1;
				
			}
		  //checks to see if ball bounces off left paddle
		  if(ballxcoordinate < 0+paddlewidth && leftpaddleycord < ballycoordinate+(2*ballradius)-deltaY && ballycoordinate+(2*ballradius)- deltaY <leftpaddleycord+paddleheight)
			{
				
				deltaX *=-1;
			}
			//checks to see if ball has hit a side
		 if(ballxcoordinate+2*ballradius > widthofgraphicalarea || ballxcoordinate+2*ballradius<0)
			{
				
				successfulmove = false;
			}
		  
          return successfulmove;
     }
	 
	 public void rightPaddleUp()
	 {
		if(rightpaddleycor > 0)
			rightpaddleycor -= 30;
	 }
	 
	 public void leftPaddleUp()
	 {
		if(leftpaddleycord/2 > 0)
			leftpaddleycord -= 30;
	 }
	 public void rightPaddleDown()
	 {
		if(rightpaddleycor < heightofgraphicalarea-paddleheight)
			rightpaddleycor += 30;
		
	 }
	 public void leftPaddleDown()
	 {
		if (leftpaddleycord < heightofgraphicalarea-paddleheight)
			leftpaddleycord += 30;
	 }
	 
	 public void ComputeDelta()
	 {
		int theta;
		int side = (int)(Math.random()*2);//chooses left or right
		if(side == 1)
		{
			theta = 90 + (int)(Math.random()*181);
		}
		else
		{
			theta = -90 + (int)(Math.random()*181);
		}
		double angle = (double)theta;		
		deltaY = (double)(10 * Math.sin(Math.toRadians(angle)));
		deltaX = (double)(10 * Math.cos(Math.toRadians(angle)));
		
	 }
	 
	 	 
	 public void clear()
	 {
		ballycoordinate = heightofgraphicalarea/2 -2*ballradius;
		ballxcoordinate = widthofgraphicalarea/2 - 2*ballradius;
		leftpaddleycord = heightofgraphicalarea/2 -(paddleheight/2);
		rightpaddleycor = heightofgraphicalarea/2 -(paddleheight/2);
		randomColor = Color.WHITE;
		repaint();
	 }
	 
	 public boolean getPoint()
	 {
		
		if(ballxcoordinate+2*ballradius > widthofgraphicalarea)
			{
				point = true;
				
			}
		if(ballxcoordinate<0)
			{
				point = false;
				
			}
		clear();
		return point;
	 }
	
}//End of Graphicalpanel

