//Programmer's name:  Matthew Elko
//Email address:      elkleaf@csu.fullerton.edu
//Course:             CPSC223j
//Assignment number:  2nd assignment
//Due date:           2012-Oct-15



//Project: This project makes a tic tac toe game.


import java.awt.GridLayout;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;


public class tictactoeframe extends JFrame 
{private JButton [] buttons;
 private JButton NewGame;
 private JButton exit;
 private JTextField winner;
 private JTextField blank;
 private JTextField blank2;
 private JTextField ShowWinner;
 private Container container;
 private GridLayout gridlayout1;
 private JRadioButton xbutton;
 private JRadioButton obutton;
 private ButtonGroup turnorder;
 
 private static final int xnum = 1;
 private static final int onum = 0;
 private String letter ="";
 private int count = 0;
 private int counter=0;  //counter used to determine if it is O or X's turn
 private int startcounter=0;//counter used to help disable the buttons
 private int movecounter=0;//counter used to help determine a draw
 private int winnercount=0;//counter used to override TestDraw if a win is acheived on the 9th move.
 public int gamearray[]=new int[9];//keeps track of which buttons hold X or O






//frame construction
public tictactoeframe()
	{super ("tic tac toe game");
	gridlayout1 = new GridLayout(6, 3, 5, 5);
	container = getContentPane();
	 setLayout (gridlayout1);
	 buttons = new JButton[9];
	 
	 buttonhandler myhandler = new buttonhandler();
	 
	 for (int i = 0; i <=8; i++){        //loop for making buttons and adding action listeners
		buttons[i]= new JButton();
		buttons[i].addActionListener( myhandler );
		add(buttons[i]);
	 }
	 
	 
	 
	 xbutton = new JRadioButton ("X", false); //radio buttons being added to frame
	 add(xbutton);
	 xbutton.setEnabled(false);
	 obutton = new JRadioButton ("O", false);
	 add(obutton);
	 obutton.setEnabled(false);
	 
	 turnorder = new ButtonGroup();
	 turnorder.add(xbutton);
	 turnorder.add(obutton);
	 xbutton.addItemListener(new RadioButtonHandler(xnum));
	 obutton.addItemListener(new RadioButtonHandler(onum));
	 
	 blank = new JTextField (); //adding blank space to frame
	 blank.setVisible(false);
	 add(blank);
	 
	 
	 ShowWinner = new JTextField();
	 ShowWinner.setEditable(false);
	 add(ShowWinner);
	 blank2= new JTextField();
	 blank2.setVisible(false);
	 add(blank2);
	 
	 NewGame = new JButton ("New Game");
	 NewGame.addActionListener( myhandler );
	 add(NewGame);
	 
	 exit = new JButton ("Exit");
	 exit.addActionListener( myhandler);
	 add(exit);
	 
		
	}
	
	
private class RadioButtonHandler implements ItemListener{  //button handling for the radio buttons
    private int buttonorder;
    
    public RadioButtonHandler(int B){
    buttonorder=B;
    }

    public void itemStateChanged(ItemEvent event){
       if(startcounter==0){
        if(buttonorder==1)
        {counter++;
         startcounter++;
         obutton.setEnabled(false);//dissables O button
        }
        if(buttonorder==0)
        {startcounter++;
         xbutton.setEnabled(false);//dissables X button
        }
       }
    }
}

//Method that disables all of the buttons when called
    //This method disables buttons by setting their array values equal to 2
    //The buttons in the grid will only work if their values are 1 or 0
    private void buttondisable(){
    
	
	for(int i = 0; i <=8;i++)
	{
		if(gamearray[i]==2)
		{buttons[i].setText("-");}
	}
	
    }

    /*Method checks the game board for a winner when called
    Method also displays the winner if one is found
    Method checks all possible winning combinations for X and O
    If a winner is found the 3 spaces displaying the win will have their font
    size increased
     */

private void testwin(){
        if(gamearray[0]==1&&gamearray[1]==1&&gamearray[2]==1){
        buttondisable();
        
        ShowWinner.setText("X wins!");
        winnercount++;}
        else if(gamearray[0]==1&&gamearray[4]==1&&gamearray[8]==1){
        buttondisable();
        
        ShowWinner.setText("X wins!");
        winnercount++;}
        else if(gamearray[0]==1&&gamearray[3]==1&&gamearray[6]==1){
        buttondisable();
        
        ShowWinner.setText("X wins!");
        winnercount++;}
        else if(gamearray[6]==1&&gamearray[4]==1&&gamearray[2]==1){
        buttondisable();
        
        ShowWinner.setText("X wins!");
        winnercount++;}
        else if(gamearray[6]==1&&gamearray[7]==1&&gamearray[8]==1){
        buttondisable();
        
        ShowWinner.setText("X wins!");
        winnercount++;}
        else if(gamearray[2]==1&&gamearray[5]==1&&gamearray[8]==1){
        buttondisable();
        
        ShowWinner.setText("X wins!");
        winnercount++;}
        else if(gamearray[3]==1&&gamearray[4]==1&&gamearray[5]==1){
        buttondisable();
        
        ShowWinner.setText("X wins!");
        winnercount++;}
        else if(gamearray[1]==1&&gamearray[4]==1&&gamearray[7]==1){
        buttondisable();
        
        ShowWinner.setText("X wins!");
        winnercount++;}
        else if(gamearray[1]==0&&gamearray[4]==0&&gamearray[7]==0){
        buttondisable();
        
        ShowWinner.setText("O wins!");
        winnercount++;}
        else if(gamearray[0]==0&&gamearray[1]==0&&gamearray[2]==0){
        buttondisable();
        
        ShowWinner.setText("O wins!");
        winnercount++;}
        else if(gamearray[0]==0&&gamearray[4]==0&&gamearray[8]==0){
        buttondisable();
        
        ShowWinner.setText("O wins!");
        winnercount++;}
        else if(gamearray[0]==0&&gamearray[3]==0&&gamearray[6]==0){
        buttondisable();
        
        ShowWinner.setText("O wins!");
        winnercount++;}
        else if(gamearray[6]==0&&gamearray[4]==0&&gamearray[2]==0){
        buttondisable();
        
        ShowWinner.setText("O wins!");
        winnercount++;}
        else if(gamearray[6]==0&&gamearray[7]==0&&gamearray[8]==0){
        buttondisable();
        
        ShowWinner.setText("O wins!");
        winnercount++;}
        else if(gamearray[2]==0&&gamearray[5]==0&&gamearray[8]==0){
        buttondisable();
        
        ShowWinner.setText("O wins!");
        winnercount++;}
        else if(gamearray[3]==0&&gamearray[4]==0&&gamearray[5]==0){
        buttondisable();
        
        ShowWinner.setText("O wins!");
        winnercount++;}
    }

    //Method Tests the gameboard for a draw
    //If a draw is found then Draw will be displayed in the text field
    private void TestDraw(){
        if (movecounter==9&&winnercount==0){
        ShowWinner.setText("Draw!");}
    }

	
	
private class buttonhandler implements ActionListener //button handling for X and O squares and the new game button
	{public void actionPerformed(ActionEvent event)
	 {
	 if(event.getSource()==exit)
			{
				System.exit(0);
			}
	  String text;
	  if(counter%2==0)
	  {
		letter = "O";
	  }
	  else
	  {
		letter = "X";
	  }
	  JButton pressedButton = (JButton)event.getSource();
	  text = pressedButton.getText().trim();
	  if(startcounter==0)
		{JOptionPane.showMessageDialog(null, "Please Select which player goes first");}
	  
	  else
	  {
	  if(text.equals(""))
	  {
	  counter++;
	  movecounter++;
	  pressedButton.setText(letter);
	  for (int i =0; i<=8; i++)
	  {
		if(buttons[i].getText()=="X")
		{gamearray[i]=1;}
		else if(buttons[i].getText()=="O")
		{gamearray[i]=0;}
	  }
	  testwin();
	  TestDraw();
	  }
	  
	  }
	  
	  
	  
		
	
		if(event.getSource()== NewGame)
			{
				for(int i =0; i<=8; i++)
				{buttons[i].setText("");
				 gamearray[i]=2;
				}
				
				xbutton.setEnabled(true);
				obutton.setEnabled(true);
				turnorder.clearSelection();
				counter=0;
				startcounter=0;
				movecounter=0;
				winnercount=0;
				ShowWinner.setText("");
			}
			
			
		
			
	 }
	
	
	
	
	
	
	
	}
	
	
	

}