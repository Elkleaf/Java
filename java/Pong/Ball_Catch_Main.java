//--------------------------------------------------------
//Name:Tyler Hartzheim
//E-mail: thartzheim@gmail.com
//ClassID: CPSC223J
//AssignmentNumber: Assignment 6
//Due Date: December 4, 2010
//--------------------------------------------------------
import java.awt.Color;
import javax.swing.JFrame;
public class Ball_Catch_Main
{
    public static void main(String[] args)
    {
        Ball_Catch_Frame gridLayoutFrame = new Ball_Catch_Frame();
        gridLayoutFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
        gridLayoutFrame.pack();
        gridLayoutFrame.makeFocusable();
        gridLayoutFrame.requestFocusInPanel();
        gridLayoutFrame.setSize(800, 700);
        gridLayoutFrame.setVisible(true);
        gridLayoutFrame.setResizable(false);
    }

}