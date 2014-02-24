//Programmer's name:  Matthew Elko
//Email address:      elkleaf@csu.fullerton.edu
//Course:             CPSC223j
//Assignment number:  4th assignment
//Due date:           2012-Sep-14
//Project: A program that creates the Rabbit and tortoise race
import java.util.Random;
import javax.swing.*;

public class operations
{
	
	public static double GetSpeed( String speed)
	{
		double temp;
		
		temp = Double.parseDouble(speed);
		
		return temp;
	}
	
	public static int getrabbitmoves()
	{
		int counter = 0;
		Random random = new Random();
		int temp = random.nextInt(9);
		
         if(temp>=0&&temp<=1)
         {
           counter+=0;
         }
         if(temp>1&&temp<=3)
         { 
			counter+=9;
         }
         if(temp>3&&temp<=4)
         { 
			counter-=12;      
         }
         if(temp>4&&temp<=7)
         { 
			counter+=1;
         }
         if(temp>7&&temp<=9)
         { 
			counter-=2;
         }
		return counter;
	}
	
	public static int getturtlemoves()
	{
		int counter = 0;
		Random random = new Random();
		int temp = random.nextInt(9);
		if(temp>=0&&temp<=4)
        {
          counter+=3;
        }
        if(temp>4&&temp<=6)
         {
           counter-=2;
         }
         if(temp>6&&temp<=9)
         {
           counter+=1;
         }
	  return counter;
	}
}