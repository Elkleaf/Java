//Programmer's name:  Prof. Holliday
//Email address:      activeprofessor@yahoo.com
//Course:             CPSC223j
//Assignment number:  Example for the second assignment
//Due date:           2012-Sep-14



//Project: A program that adds and subtracts integers.

//This module defines the properties of the user interface

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.Color;

public class userframe extends JFrame
{private JLabel number1label;
 private JTextField textfield1;
 private JLabel number2label;
 private JTextField textfield2;
 private JSpinner secondnumberspinner;
 private SpinnerNumberModel secondnumbermodel;
 private JSpinner.NumberEditor secondnumbereditor;
 private JLabel sumlabel;
 private JTextField sumfield;
 private JLabel differencelabel;
 private JTextField differencefield;
 private JButton addbutton;
 private JButton subtractbutton;
 private JButton exitbutton;
 private String numberstring1;
 private int number1;
 private String numberstring2;
 private int number2;
 private String sumstring;
 private int sum;
 private String differencestring;
 private int difference;
 private int leng=10;
 private mathoperations arithmeticmachine;
 public userframe() //This is the constructor
   {super("Spinner Interface");
    setLayout(new FlowLayout());
    number1label = new JLabel("Number 1");
    //The next statement is an example of changing the color of the characters of 
    //a string of output.  The way it works is that first the string is outputted
    //in the default color and then it is immediately changed to the new color.
    //The string of data is considered to be in the foreground and the text field 
    //holding the box is considered to be the background.  From here you can easily
    //guess how to set the color of the background area.
    number1label.setForeground(Color.BLUE);
    add(number1label);
    textfield1 = new JTextField(20);
    add(textfield1);
    //
    //The next statement is an example of embedded html.  It is here only to demonstrate
    //how to output a string in more than one color.  In this case the first character is
    //outputted in red and the trailing characters are outputted in green.
    number2label = new JLabel("<html><body><center><font color=#b40404>N</font><font color=#00ff00>umber 2</font>" + 
                              "<xmp>                                          </xmp></center></body></html>");
    //Note to CPSC223J students: In the html above there are many blanks bounded by <xmp> on the left and </xmp> on the right.
    //The only purpose for those blanks is formatting.  Those blanks are a gimmick to format the second line of the user interface.
    //In the future you'll probably use a grid layout or a border layout to format the UI (user interface), and you will not need
    //this gimmick of inserting white space.
    add(number2label);
    //
    //Begin statements to create spinner.
    secondnumbermodel = new SpinnerNumberModel(0,-10,+20,2); //-10=minimum,+20=maximum,2=increment
    secondnumberspinner = new JSpinner(secondnumbermodel);
    add(secondnumberspinner);
    //
    //The next two statements set the format of the number to be displayed in the spinner's field.  You could probably omit the 
    //next two statements and simply use the default format for integers, and you'll still have nicely formatted integers.
    secondnumbereditor = new JSpinner.NumberEditor(secondnumberspinner,"######");
    secondnumberspinner.setEditor(secondnumbereditor);
    //
    sumlabel = new JLabel("Sum        ");
    add(sumlabel);
    sumfield = new JTextField(20);
    add(sumfield);
    differencelabel = new JLabel("Difference");
    add(differencelabel);
    differencefield = new JTextField(20);
    add(differencefield);
    addbutton = new JButton("Add");
    add(addbutton);
    subtractbutton = new JButton("Subtract");
    add(subtractbutton);
    exitbutton = new JButton("Exit");
    add(exitbutton);
    buttonhandler myhandler = new buttonhandler();
    addbutton.addActionListener(myhandler);
    subtractbutton.addActionListener(myhandler);
    exitbutton.addActionListener(myhandler);
    arithmeticmachine = new mathoperations();
   }//End of constructor method
 private class buttonhandler implements ActionListener
   {public void actionPerformed(ActionEvent event)
       {if(event.getSource() == addbutton)
           {numberstring1 = textfield1.getText();
            leng = numberstring1.length();
            //System.out.println("leng = "+leng);    //Debug statement
            if(leng == 0)
                 number1 = 0; //if no input found assume user wanted zero
            else
                 number1 = Integer.parseInt(numberstring1);
            //numberstring2 = textfield2.getText();  //Old stuff
            //leng = numberstring2.length();         //Old
            //System.out.println("leng = "+leng);    //Debug statement
            number2 = (int)(secondnumberspinner.getValue());  //The casting operator is really needed.
            //if(leng == 0)
            //     number2 = 0; //if no input found assume user wanted zero
            //else
            //     number2 = Integer.parseInt(numberstring2);
            sum = mathoperations.add(number1,number2);
            sumstring = String.format("%5d",sum);
            sumfield.setText(sumstring);
           }
        else if(event.getSource() == subtractbutton)
           {numberstring1 = textfield1.getText();
            if(leng == 0)
                 number1 = 0; //if no input found assume user wanted zero
            else
                 number1 = Integer.parseInt(numberstring1);
            number2 = (int)(secondnumberspinner.getValue());  //The casting operator is really needed.
            //numberstring2 = textfield2.getText();  //Old
            //if(leng == 0)
            //     number2 = 0; //if no input found assume user wanted zero
            //else
            //     number2 = Integer.parseInt(numberstring2);
            
            difference = mathoperations.subtract(number1,number2);
            differencestring = String.format("%-5d",difference);
            differencefield.setText(differencestring);
            differencefield.setForeground(Color.RED);   //See footnote about color output.
           }
//      else if(event.getSource() == clearbutton)
//         {//To be done later
//         }
        else if(event.getSource() == exitbutton)
           {System.exit(0);
           }
        else
           System.out.println("Unknown error");
      }//End of actionPerformed
    }//End of buttonhandler class
}//End of userframe class
//
//Statement of the problem: How can you output a string into a textfield using multiple colors?
//The solution is found in the source code above.  If you want to change the color of the entire 
//string of output then Java can do this directly.  However, if you want to change the color of
//parts of the string then the only solution is to use embedded html, and there is an example of
//embedded html in the source code above.

