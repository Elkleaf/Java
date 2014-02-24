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


public class Gameinterface extends JFrame 
{    private JPanel titlepanel;//the first panel that contains the title of the game
     private JLabel titlelabel;//the label that will be added to the title panel
	 private JButton newgame;//the newgame button
	 private JSlider slider;//the slider of the game
     private Graphicalpanel graphicalpanel;//the panel that will contain all the graphics
     private JPanel buttonpanel;//the panel that will have all of the buttons 
     private JButton gobutton;//the go button
	 private JButton exit;//the exit button
	 private JButton pause;
     private Timer systemclock;//the timer of the program
	 private Timer paddleclock;
	 private int delayinterval; //the delayinterval used for the timer object
     actionHandler myhandler;//the actionhandler
	 PaddleHandler paddlehandler;
	 private String angleString;//the string that will hold the inputed angle
	 private boolean startcheck;//a boolean that will check whether new game has been pressed or the go button
	 private boolean rightup;
	 private boolean leftup;
	 private boolean rightdown;
	 private boolean leftdown;
	 private boolean point;
	 private boolean ispaused = true;
	 private JLabel Rplayer;
	 private JTextField RightPlayerText;
	 private JLabel Lplayer;
	 private JTextField LeftPlayerText;
	 private int leftpoint = 0;
	 private int rightpoint =0;
	 private String Left;
	 private String Right;
	 //private mainapplet myapplet;
	 

     public Gameinterface(/*mainapplet mainapp*/)
         {super("Pong game");
		  //myapplet = mainapp;
		  myhandler = new actionHandler(); //handler that handles the all the actions
		  paddlehandler = new PaddleHandler();
		  paddleclock = new Timer(100, paddlehandler);
		  paddleclock.start();
          //Make 3 panels and place them from top to bottom onto any object of type Gameinterface.
          //Make the 1st panel
          titlelabel = new JLabel("Hippie Trippie Pong");
          titlepanel = new JPanel();
          titlepanel.add(titlelabel);
          add(titlepanel,BorderLayout.NORTH);
          //Make the 2nd panel
          graphicalpanel = new Graphicalpanel(true);
		  add(graphicalpanel,BorderLayout.CENTER);
		  //Make the 3rd panel
		  newgame= new JButton("New Game");
		  newgame.addActionListener(myhandler);
		  exit = new JButton("Exit");
		  exit.addActionListener(myhandler);
          gobutton = new JButton("Go");
          gobutton.addActionListener(myhandler);
		  pause = new JButton("Pause");
		  pause.addActionListener(myhandler);
		  slider = new JSlider(JSlider.HORIZONTAL,0,100,50);
		  slider.setMajorTickSpacing(25);
		  slider.setMinorTickSpacing(5);
		  slider.setPaintLabels(true);
		  slider.setPaintTicks(true);
		  slider.setPaintTrack(true);
		  slider.addChangeListener(myhandler);
		  Rplayer = new JLabel("Right Player");
		  RightPlayerText = new JTextField("",5);
		  RightPlayerText.setEditable(false);
		  Lplayer = new JLabel("Left Player");
		  LeftPlayerText = new JTextField("",5);
		  LeftPlayerText.setEditable(false);
		  buttonpanel = new JPanel();
		  buttonpanel.add(Lplayer);
		  buttonpanel.add(LeftPlayerText);
		  buttonpanel.add(newgame);
          buttonpanel.add(gobutton);
		  buttonpanel.add(pause);
		  buttonpanel.add(slider);
		  buttonpanel.add(Rplayer);
		  buttonpanel.add(RightPlayerText);
		  buttonpanel.add(exit);
          add(buttonpanel,BorderLayout.SOUTH);
		  this.setFocusable(true);
		  this.addKeyListener(paddlehandler);
		  gobutton.setFocusable(false);
		  newgame.setFocusable(false);
		  slider.setFocusable(false);
		  pause.setFocusable(false);
		  //setSize(960,640);
		  //setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         }//End of Gameinterface constructor.
		 

     private class actionHandler implements ActionListener, ChangeListener
     {    public void actionPerformed(ActionEvent event)
              {boolean result = false;				
			   if(event.getSource() == gobutton)//the event that the go button is pressed
				{	int fps = (int)slider.getValue();					
					graphicalpanel.ComputeDelta();					
					delayinterval = (int)Math.floor(1000/fps);
					systemclock = new Timer(delayinterval, myhandler);					
					systemclock.start();
					startcheck = true;
																		  
				}
				if(event.getSource()==systemclock)//what will happen every tick of the clock
					{
						
						result = graphicalpanel.moveball();
						if(result)
                        graphicalpanel.repaint();
						else
                        {systemclock.stop();
						 point = graphicalpanel.getPoint();
						 if(point)
						 {
							leftpoint++;
							Left = Integer.toString(leftpoint);
							LeftPlayerText.setText(Left);
						 }
						 else
						 {
							rightpoint++;
							Right = Integer.toString(rightpoint);
							RightPlayerText.setText(Right);
						 }
						 
						 if(leftpoint == 5 || rightpoint ==5)
						 {
							JOptionPane.showMessageDialog(null, "Game Over. Click new game!");
							systemclock.stop();
						 }
                         System.out.printf("%s\n","Ball has stopped!.");
                        }
					}
					
				if(event.getSource()== pause)
					{
						if(ispaused)
						{
							systemclock.stop();
							ispaused = false;
							pause.setText("Resume");
							startcheck = false;
						}
						else
						{
							systemclock.start();
							ispaused = true;
							pause.setText("Pause");
							startcheck = true;
						}
					}
				if(event.getSource()==newgame)//if the new game button is pressed
					{
						LeftPlayerText.setText("");
						RightPlayerText.setText("");
						leftpoint = 0;
						rightpoint = 0;
						slider.setValue(50);
						systemclock.stop();
						graphicalpanel.clear();
						startcheck = false;
						
					}
				if(event.getSource()==exit)//the exti button
				{
					//myapplet.close();
					
				}
               
              }
			  //the function that deals with the slider moving and changing the speed while the game is happening
			  public void stateChanged(ChangeEvent e)
			  {
				JSlider source = (JSlider)e.getSource();
				if (!source.getValueIsAdjusting())
				{
					int fps = (int)source.getValue();
					if (fps == 0) 
					{
						systemclock.stop();
						
					} 
					
					else 
					{
						delayinterval = 1000 / fps;
						systemclock = new Timer(delayinterval, myhandler);
						if(startcheck)
						{
						systemclock.start();
						}
					}
				}
			}		
     }// end actionHandler
	 
	 private class PaddleHandler implements KeyListener, ActionListener
	 {		
		
		public void keyPressed(KeyEvent event)
		{
			int keycode = event.getKeyCode();
			switch (keycode)
			{	case KeyEvent.VK_UP:
				case KeyEvent.VK_KP_UP:
					rightup = true;
				break;
				case KeyEvent.VK_Q:
					leftup=true;
				break;
				case KeyEvent.VK_DOWN:
				case KeyEvent.VK_KP_DOWN:
					rightdown = true;
				break;
				case KeyEvent.VK_Z:
					leftdown = true;
				break;
					
			}
			
		}
		public void keyReleased (KeyEvent event)
		{
			int keycode = event.getKeyCode();
			switch (keycode)
			{	case KeyEvent.VK_UP:
				case KeyEvent.VK_KP_UP:
					rightup = false;
				break;
				case KeyEvent.VK_Q:
					leftup=false;
				break;
				case KeyEvent.VK_DOWN:
				case KeyEvent.VK_KP_DOWN:
					rightdown = false;
				break;
				case KeyEvent.VK_Z:
					leftdown = false;
				break;
			}
		}
	
		public void keyTyped (KeyEvent event)
		{
		}
		public void actionPerformed(ActionEvent event)
		{
			if(event.getSource() == paddleclock)
			{
				if(rightup)
					graphicalpanel.rightPaddleUp();
				if(leftup)
					graphicalpanel.leftPaddleUp();
				if(rightdown)
					graphicalpanel.rightPaddleDown();
				if(leftdown)
					graphicalpanel.leftPaddleDown();
				graphicalpanel.repaint();
					
			}
		}
	 }//end paddlehandler

}//End of Gameinterface
              