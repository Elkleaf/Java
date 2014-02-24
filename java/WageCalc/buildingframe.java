//Programmer's name:  Matthew Elko
//Email address:      elkleaf@csu.fullerton.edu
//Course:             CPSC223j
//Assignment number:  2nd assignment
//Due date:           2012-Sep-14
//Project: A program that calculates the net pay for employees

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
import javax.swing.JComboBox;


public class buildingframe extends JFrame
{private JLabel namelabel;
 private JTextField nametext;
 private JLabel hourslabel;
 private JLabel payrateLabel;
 private JTextField payratetext;
 private JLabel dependantslabel;
 private JLabel GrosspayLabel;
 private JTextField Grosspaytext;
 private JLabel FedtaxLabel;
 private JTextField FedtaxText;
 private JLabel HealthLabel;
 private static final String[] Healthplan = { "Choose", "Yes", "No"};
 private JComboBox Healthplanbox;
 private JLabel FicaLabel;
 private JTextField FicaText;
 private JLabel NetPayLabel;
 private JTextField NetPayText;
 private JLabel HealthPremiumLabel;
 private JTextField HealthPremiumText;
 private JSpinner hourspinner;
 private SpinnerNumberModel hourmodel;
 private JSpinner.NumberEditor houreditor; 
 private JSpinner dependantspinner;
 private SpinnerNumberModel dependantmodel;
 private JSpinner.NumberEditor dependanteditor;
 private JButton computebutton;
 private JButton clearbutton;
 private JButton exitbutton;
 private double payrate;
 private double Grosspay;
 private double fedtax;
 private double fica;
 private double netpay;
 private double Healthprem;
 private int HealthSelect;
 private int dependants;
 private int hours;
 private String netpaystring;
 private String ficastring;
 private String Healthstring;
 private String fedtaxstring;
 private String Grosspaystring;
 private String hourstring;
 private String Dependantstring;
 private String payratestring;
 
 
 private int leng=10;
 private mathpower arithmeticmachine;
 public buildingframe() //This is the constructor
   {super("Payroll Program: ");
    setLayout(new FlowLayout());
    namelabel = new JLabel("Name: ");
    add(namelabel);
    nametext = new JTextField(20);
    add(nametext);
    
    hourslabel = new JLabel("Hours: ");
    add(hourslabel);
   
    hourmodel = new SpinnerNumberModel(0,0,+168,4); //initial, min,max,increment
    hourspinner = new JSpinner(hourmodel);
    add(hourspinner);
    //
    //The next two statements set the format of the number to be displayed in the spinner's field.  You could probably omit the 
    //next two statements and simply use the default format for integers, and you'll still have nicely formatted integers.
    houreditor = new JSpinner.NumberEditor(hourspinner,"######");
    hourspinner.setEditor(houreditor);
    
    payrateLabel = new JLabel("Payrate ");
    add(payrateLabel);
    payratetext = new JTextField(20);
    add(payratetext);
    dependantslabel = new JLabel("Dependants: ");
    add(dependantslabel);
    dependantmodel = new SpinnerNumberModel(0,0,+10,1);//initial, min, max, increment
	dependantspinner = new JSpinner(dependantmodel);
    add(dependantspinner);
	HealthLabel = new JLabel("Health plan:   ");
	add(HealthLabel);
	Healthplanbox = new JComboBox(Healthplan);
	add(Healthplanbox);
	Healthplanbox.setMaximumRowCount(3);
	
	GrosspayLabel = new JLabel ("Gross Pay" );
	add(GrosspayLabel);
	Grosspaytext = new JTextField (20);
	add(Grosspaytext);
	FedtaxLabel  = new JLabel ("FedTax: ");
	add(FedtaxLabel);
	FedtaxText = new JTextField(20);
	add(FedtaxText);
	HealthPremiumLabel = new JLabel ("Health Premium: ");
	add(HealthPremiumLabel);
	HealthPremiumText = new JTextField(20);
	add(HealthPremiumText);
	FicaLabel = new JLabel ("Fica: ");
	add(FicaLabel);
	FicaText = new JTextField(20);
	add(FicaText);
	NetPayLabel = new JLabel("Net Pay:" );
	add(NetPayLabel);
	NetPayText = new JTextField(20);
	add(NetPayText);
	
	
	
    computebutton = new JButton("compute");
    add(computebutton);
    clearbutton = new JButton("clear");
    add(clearbutton);
    exitbutton = new JButton("Exit");
    add(exitbutton);
    buttonhandler myhandler = new buttonhandler();
    computebutton.addActionListener(myhandler);
    clearbutton.addActionListener(myhandler);
    exitbutton.addActionListener(myhandler);
    arithmeticmachine = new mathpower();
   }//End of constructor method
 private class buttonhandler implements ActionListener
   {public void actionPerformed(ActionEvent event)
       {if(event.getSource() == computebutton)
           {payratestring = payratetext.getText();
            leng = payratestring.length();
            
            if(leng == 0)
                 payrate = 0; //if no input found assume user wanted zero
            else
                 payrate = Double.parseDouble(payratestring);
            
            hours = (int)(hourspinner.getValue());  //The casting operator is really needed.
			if(payrate<0.00) //checks to see if payrate is negative		
				payrate = 0.00;
            if(hours < 0)//checks to see if hours is negative
				hours = 0;
			if(hours>168)//checks to see if hours is over the limit
				hours =168;
			
			//finding the grosspay
            Grosspay = mathpower.Grosspay(hours,payrate);
            Grosspaystring = String.format("%1$, .2f",Grosspay);
            Grosspaytext.setText("$" + Grosspaystring);
			
			if(Grosspay > 300)//checks to see if federal tax is applied
			{
				fedtax = mathpower.FedTax(Grosspay);
				fedtaxstring = String.format("%1$, .2f", fedtax);
				FedtaxText.setText("$" + fedtaxstring);
							
           }
		   else
		   {
				fedtax = 0.00;
				fedtaxstring = String.format("%1$, .2f", fedtax);
				FedtaxText.setText("-$" + fedtaxstring);
		   }
		   
		   //finding the health plan taxes
		   dependants = (int)(dependantspinner.getValue());
		   if(dependants < 0)
				dependants = 0;
		   HealthSelect = Healthplanbox.getSelectedIndex();
		   if(HealthSelect ==1)
		   {
				Healthprem = mathpower.getHealthPrem(dependants);
				Healthstring = String.format("%1$, .2f", Healthprem);
				HealthPremiumText.setText("-$" + Healthstring);	   
		   
		   } 
		   else
		   {
				Healthprem = 0.00;
				Healthstring = String.format("%1$, .2f", Healthprem);
				HealthPremiumText.setText("-$" + Healthstring);
		   }
		   
		   
		   //finding the fica taxes
		   fica = mathpower.getfica(Grosspay);
		   ficastring = String.format("%1$, .2f", fica);
		   FicaText.setText("-$" + ficastring);
        
		   netpay = mathpower.netpay(Grosspay, fedtax, Healthprem, fica);
		   netpaystring = String.format("%1$, .2f", netpay);
		   NetPayText.setText("$" + netpaystring);
		   
		
		}        
      else if(event.getSource() == clearbutton)//clear button
         {
			nametext.setText("");
			payratetext.setText("");
			Grosspaytext.setText("");
			FedtaxText.setText("");
			HealthPremiumText.setText("");
			FicaText.setText("");
			NetPayText.setText("");
			hourspinner.setValue(0);
			dependantspinner.setValue(0);
			Healthplanbox.setSelectedIndex(0);
         }
        else if(event.getSource() == exitbutton)//exit button
           {System.exit(0);
           }
        else
           System.out.println("Unknown error");
      }//End of actionPerformed
    }//End of buttonhandler class

}//End of userframe class
