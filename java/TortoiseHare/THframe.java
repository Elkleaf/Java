//Programmer's name:  Matthew Elko
//Email address:      elkleaf@csu.fullerton.edu
//Course:             CPSC223j
//Assignment number:  4th assignment
//Due date:           2012-Sep-14
//Project: A program that creates the Rabbit and tortoise race
import java.util.Random;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.*;

public class THframe extends JFrame
{
	private JButton [] racetrack;	// array of buttons used for racetrack
	private JButton newgame;		// button stops the race and resets the track
	private JButton go;				// button to start the race
	private JButton exit;			// button exits program
	private JButton pause;			// button used to pause the race
	private JPanel Racetrack;		// panel holding the racetrack
	private JPanel Buttons;			// panel holding the buttons, animal positions, and winner
	private JPanel Heading;			// panel containing tortoise and hare heading
	private BorderLayout window;	// borderlayout for the entire window
	private int interval =1000;		// interval used for race clock. set at 1000 initially
	private double getspeed;		// holds the speed the animals will move
	private int rabbit =0;			// holds the rabbit's position. initially at space 0
	private int turtle =0;			// holds the tortoise's position. initially at space 0
	private double ouchcounter;		// counter used to display ouch for 3 seconds
	private int rabbitcounter;		// counter used to move the rabbit the correct number of spaces for its random number
	private int turtlecounter;		// counter used to move the tortoise the correct number of spaces for its random number
	private JTextField blank;		// blank textfield used for positioning
	private JTextField speed;		// textfield used to display string "Speed"
	private JTextField Speedin;		// textfield used to take the user's desired speed for the race
	private JTextField rabbitlabel; //textfield used to display string "Rabbit" next to its position field
	private JTextField rabbitpos;	//textfield used to display rabbit's position
	private JTextField turtlelabel;  //textfield to display string "Tortoise" next to its position field
	private JTextField turtlepos;   //textfield used to display tortoise's position
	private JTextField winner;		//textfield used to display string "Winner" next to winner field
	private JTextField showWinner;	//textfield used to display the winner
	private JTextField raceheading;	// heading above the racetrack
	private String display;
	private String speedvalue;
	Timer myclock;					//timer used to run the race when clock has been started
    ClockHandler actionlistenerobject; //action handler for the program
	private operations logic;		// declaring the operations file which contains the business logic
	
	public THframe()
	{
	 super("The Tortoise and Hare race");
	 window = new BorderLayout();
	 setLayout(window);
	 rabbitcounter =0;
	 turtlecounter=0;
		
	 actionlistenerobject = new ClockHandler();  //initializing the actionlistener
		
	 Heading = new JPanel();
	 Heading.setLayout(new FlowLayout());
	 Racetrack = new JPanel();
	 Racetrack.setLayout(new GridLayout(22, 30, 1,1));
	 Buttons = new JPanel();
	 Buttons.setLayout(new FlowLayout());
				
	 rabbitlabel = new JTextField("Rabbit's position");
     rabbitlabel.setEditable(false);
 	 rabbitpos = new JTextField("",3);
   	 rabbitpos.setEditable(false);
	 turtlelabel = new JTextField("Tortoise's position");
	 turtlelabel.setEditable(false);
	 turtlepos = new JTextField("",3);
	 turtlepos.setEditable(false);
	 raceheading= new JTextField("The Tortoise and the Rabbit Race");
	 Speedin = new JTextField(" ",3);
	 Speedin.setEditable(false);
	 speed = new JTextField("Speed (moves/sec)");
	 winner = new JTextField("Winner");
	 winner.setEditable(false);
	 showWinner = new JTextField("",15);
     showWinner.setEditable(false);
	 
	 myclock = new Timer(interval, actionlistenerobject);
	 
	 racetrack = new JButton[660];
	 pause = new JButton();
	 go = new JButton();
	 newgame = new JButton();
	 exit = new JButton();
	 
	 Heading.add(raceheading);
	 raceheading.setEditable(false);
	 add(Heading, BorderLayout.NORTH);
	 
	 Buttons.add(newgame);
     newgame.setText("New Game");
     newgame.addActionListener(actionlistenerobject);
     Buttons.add(go);
     go.setText("GO!");
     go.addActionListener(actionlistenerobject);
     Buttons.add(pause);
     pause.setText("Pause");
	 pause.addActionListener(actionlistenerobject);
     Buttons.add(exit);
     exit.setText("Quit");
     exit.addActionListener(actionlistenerobject);
     Buttons.add(speed);
     speed.setEditable(false);
     Buttons.add(Speedin);
     Buttons.add(rabbitlabel);
     Buttons.add(rabbitpos);
     Buttons.add(turtlelabel);
     Buttons.add(turtlepos);
     Buttons.add(winner);
     Buttons.add(showWinner);

     add(Buttons,BorderLayout.SOUTH);
	 
	 for(int i = 0; i<660; i++)
	 {
		racetrack[i]= new JButton();
		Racetrack.add(racetrack[i]);
		racetrack[i].setVisible(false);
		racetrack[i].setEnabled(true);
		
		if(i>=0&&i<30)
		{
		 racetrack[i].setVisible(true);
		}
		if(i>=630&&i<660)
		{
		 racetrack[i].setVisible(true);
		}
		if(i%30==0)
		{racetrack[i].setVisible(true);}
		if(i%30==29)
		{racetrack[i].setVisible(true);}
	 }
	 
	 add(Racetrack,BorderLayout.CENTER);
	 racetrack[0].setText("B");
	 racetrack[30].setText("E");
	 logic = new operations();
	 }
	 
	 public void ClearButtonText()   //clears the racetrack
   {
        for(int i=0; i<660; i++)
		{
		racetrack[i].setText("");  //sets text in each button to an empty string
        }
   }
	 
	 private class ClockHandler implements ActionListener
	 {
		int temp =0;
		public void actionPerformed(ActionEvent event)
		{
			if(event.getSource() == newgame)
			{
			 rabbit=0;                       //resets all positions and counters to 0
             turtle=0;
             rabbitcounter=0;
             turtlecounter=0;
             Speedin.setEditable(true);      //enables the user to edit race speed
             myclock.stop();                 //stop the clock from running
             ClearButtonText();              //clears all buttons of images or text
             rabbitpos.setText("0");    //resets animal positions
             turtlepos.setText("0");  //"                      "
             ouchcounter=0;                  //sets ouch timer to 0
             showWinner.setText("");         //resets the winnerfield to empty string
			}
			
			if(event.getSource() == go)
			{
				speedvalue = Speedin.getText().trim();
				getspeed = Double.parseDouble(speedvalue);;
				interval = (int)(1000/getspeed);
				myclock = new Timer(interval, actionlistenerobject);
				Speedin.setEditable(false);
				if(rabbit<100&&turtle<100)
				{myclock.start();}
				else{JOptionPane.showMessageDialog(null, "Select New Game");}
			}
			if(event.getSource()== pause)
			{myclock.stop();}
			
			if(event.getSource()==myclock)
			{
				if(rabbit<100&&turtle<100)
				{
				 if(rabbitcounter==0&&turtlecounter==0)
                 { 
					rabbitcounter = operations.getrabbitmoves();
					turtlecounter = operations.getturtlemoves();
                 }
				
				  /*
                  * The following lines are conditional statements used to
                  * determine which animal is moving. Each clock tick, only one
                  * animal moves one space at a time.
                  */
                 else
                 {  ClearButtonText();
                     if(rabbitcounter!=0)
                     {   if(rabbitcounter<0)
                         { rabbit-=1;
                           rabbitcounter++;
                           if(rabbit<0)
                           {rabbit=0;
                            rabbitcounter=0;}

                         }
                         if(rabbitcounter>0)
                         { rabbit+=1;
                           rabbitcounter--;
                         }
                     }
                     if(rabbitcounter==0&&turtlecounter!=0)
                     {    if(turtlecounter<0)
                          { turtle-=1;
                            turtlecounter++;
                            if(turtle<0)
                            {turtle=0;
                             turtlecounter=0;}
                          }
                          if(turtlecounter>0)
                          {turtle+=1;
                           turtlecounter--;
                          }
                     }
                     // The following lines set the rabbit icon or text to the appropriate spot on the track
                          if(rabbit<30)
						  {
							racetrack[rabbit].setText("R");
                          }
                          if(rabbit>=30&&rabbit<50)
						  {
							racetrack [((rabbit-28)*30)-1].setText("R");
                          }
                          if(rabbit>=50&&rabbit<80)
						  {
							racetrack[660-(rabbit-49)].setText("R");
                          }
                          if(rabbit>=80&&rabbit<100)
						  {
							racetrack[(((100-rabbit)+1)*30)].setText("R");
                          }
                  // the following lines set the tortoise icon or text to the appropriate spot on the track
                          if(turtle<30)
						  {
							racetrack[turtle].setText("T");
                          }
                          if(turtle>=30&&turtle<50)
						  {
							racetrack [((turtle-28)*30)-1].setText("T");
                          }
                          if(turtle>=50&&turtle<80)
						  {
							racetrack[660-(turtle-49)].setText("T");
                          }
                          if(turtle>=80&&turtle<100)
						  {
							racetrack[(((100-turtle)+1)*30)].setText("T");
                          }
                    /*The following lines of code check if each animal has completed its movement
                     *for the turn, and checks if the animals are on the same spot on the track.
                     *If the two animals are on the same spot of track, then the rabbit's position
                     * is decremented by 3 and the word ouch is set to be displayed within the
                     * track for 3 seconds.
                     */
                if(turtlecounter==0&&rabbitcounter==0)
                 {
                  if((turtle==rabbit)&&(turtle<100))
                  {     if(turtle<30)
						{
							racetrack[turtle].setText("O");
                        }
						if(turtle>=30&&turtle<50)
						{
							racetrack[((turtle-28)*30)-1].setText("O");
						}
						if(turtle>=50&&turtle<80)
						{
							racetrack[660-(turtle-49)].setText("O");
						}
						if(turtle>=80&&turtle<100)
						{
							racetrack[(((100-turtle)+1)*30)].setText("O");
						}
                    rabbitcounter-=3;
                    if(rabbit==0)
                    {rabbitcounter=0;}
                    ouchcounter=3000/interval; //sets the word ouch to be displayed for 3 seconds.
              }
              }
              }
              }
              //after each clock tick the animal's position is displayed as text
              //in the appropriate textfield
               display = Integer.toString((rabbit));
               rabbitpos.setText(display);
               display = Integer.toString((turtle));
               turtlepos.setText(display);

               //displays 0 if turtle is at position 0
               if(turtle==0)
               {turtlepos.setText("0");}
               //displays 0 if rabbit is at position 0
               if(rabbit==0)
               {rabbitpos.setText("0");}

              if(turtle>=100||rabbit>=100)
              {
               if(turtle>=100){ //displays 100 if tortoise has completed the track
                   turtlepos.setText("100");
               }
               if(rabbit>=100){ //displays 100 if rabbit has completed the track
                   rabbitpos.setText("100");
               }
                ouchcounter=0; // sets ouch counter to 0 if there is a winner
                //makes the buttons displaying ouch invisible
                racetrack[133].setVisible(false);
                racetrack[134].setVisible(false);
                racetrack[135].setVisible(false);
                racetrack[136].setVisible(false);
                racetrack[137].setVisible(false);

                
                //displays Rabbit Wins! if the rabbit completes the track first
                if(rabbit>=100){
                showWinner.setText("Rabbit Wins!");
                }
                //displays Tortoise Wins! if the tortoise completes the track first
                if(turtle>=100){
                showWinner.setText("Tortoise Wins!");
                }
                //displays It's a tie! if the two animals complete the race on the same turn
                if(turtle>=100&&rabbit>=100){
                showWinner.setText("It's a tie!") ;
                }
                myclock.stop(); //stops the game clock in the event of a win

                
               }
               //the following lines make the word OUCH! invisible when the ouchcounter hits 0
               if(ouchcounter==0)
               {racetrack[133].setVisible(false);
                racetrack[134].setVisible(false);
                racetrack[135].setVisible(false);
                racetrack[136].setVisible(false);
                racetrack[137].setVisible(false);
               }
               //the following lines make the word OUCH! visible when ouchcounter !=0
               if(ouchcounter>0)
               {racetrack[133].setVisible(true);
                racetrack[134].setVisible(true);
                racetrack[135].setVisible(true);
                racetrack[136].setVisible(true);
                racetrack[137].setVisible(true);
                racetrack[133].setText("O");
                racetrack[134].setText("U");
                racetrack[135].setText("C");
                racetrack[136].setText("H");
                racetrack[137].setText("!");
                ouchcounter--;}//decrements the ouchcounter after every tick
           }
		   
		   if(event.getSource()==exit)
		   {System.exit(1);} //exits the program when Quit is clicked
		   
		   
		racetrack[0].setText("B"); //displays B at the beginning

		racetrack[30].setText("E");//displays E at the end of the track 				
		}
				
			
	}

	 
	 
	 
		
		
		
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		