//Programmer's name:  Matthew Elko
//Email address:      elkleaf@csu.fullerton.edu
//Course:             CPSC223j
//Assignment number:  2nd assignment
//Due date:           2012-Sep-14



//Project: A program that adds and subtracts integers.

//This module contains the algorithms used by this project.

public class mathpower
{//There are no private internal variables
 public static double Grosspay(int hours, double payrate)
 {double sum;
  int overtime;
  double overtimepay;
  
  if(hours > 40){
    overtime = hours - 40;
	overtimepay = payrate + (payrate/2.0);
	sum = (payrate * 40.0) + (overtime * overtimepay);
    }
  else{
	sum = hours * payrate;
   }
  
  return sum;
 }
 public static double FedTax(double grosspay)
 {
	double fedtax;
	grosspay -=300;
	fedtax = grosspay*.22;
	
	return fedtax;
		
 }
 
 public static double getHealthPrem(int dependants)
 {
	double healthprem = 28.75+(dependants*17.35);
	return healthprem;
 }
 
 public static double getfica(double grosspay)
 {
	double fica = grosspay*.085;
	if(fica > 45)
		fica =45;
	
	return fica;
 }
 
 public static double netpay(double grosspay, double fedtax, double premium, double fica)
 {
	double netpay = grosspay - fedtax - premium - fica;
	return netpay;
 }
}//End arithmeticoperations class
