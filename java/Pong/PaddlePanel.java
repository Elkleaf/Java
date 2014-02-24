import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;
public class PaddlePanel extends JPanel
{
    int widthOfGraphicalArea;
    int heightOfGraphicalArea;
    int myPaddleHeight=8;
    int myPaddleWidth;
    int myPaddleXCoord=340;
    int myPaddleYCoord;
    int ballRadius=10;
    int ballXCoord=370;
    int ballYCoord=0;
    int speedOfBall=1;
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        widthOfGraphicalArea = getWidth();
        heightOfGraphicalArea= getHeight();
        myPaddleWidth= widthOfGraphicalArea /10;
        myPaddleYCoord= heightOfGraphicalArea-myPaddleHeight;
        g.setColor(Color.BLACK);
        g.fill3DRect(myPaddleXCoord, myPaddleYCoord,myPaddleWidth,
                myPaddleHeight, false);
        g.setColor(Color.BLUE);
        g.fillOval(ballXCoord, ballYCoord, 2*ballRadius,2*ballRadius);
    }
    public void moveright()
    {
        if(myPaddleXCoord + myPaddleWidth < widthOfGraphicalArea)
        {
            myPaddleXCoord = myPaddleXCoord+10;
            //PongControlPanel.AddPoint();
        }
    }
    public void moveleft()
    {
        if(myPaddleXCoord > 0)
        {
            myPaddleXCoord = myPaddleXCoord -10;
        }
    }
    public void lowerball()
    {
        if(ballYCoord + 2*ballRadius < heightOfGraphicalArea)
        {
            ballYCoord = ballYCoord+speedOfBall;
        }
        else if(ballYCoord+ 2*ballRadius >= heightOfGraphicalArea)
        {
            ballYCoord= 0;
            
            int x = (int) (Math.random() *99);
            if(x>=0 && x<10)
            {
                ballXCoord = widthOfGraphicalArea/2-ballRadius - 350;
            }
            else if(x>=10 && x<20)
            {
                ballXCoord= widthOfGraphicalArea/2-ballRadius -300;
            }
            else if(x>=20 && x<=30)
            {
                ballXCoord = widthOfGraphicalArea/2-ballRadius -200;
            }
            else if(x>30 && x<=40)
            {
                ballXCoord = widthOfGraphicalArea/2-ballRadius - 100;
            }
            else if(x>40 && x<=50)
            {
                ballXCoord = widthOfGraphicalArea/2-ballRadius;
            }
            else if(x>50 && x<=60)
            {
               ballXCoord = widthOfGraphicalArea/2-ballRadius+100;
            }
            else if(x>60 && x<=70)
            {
                ballXCoord = widthOfGraphicalArea/2-ballRadius +200;
            }
            else if(x>70 && x<=80)
            {
                ballXCoord = widthOfGraphicalArea/2-ballRadius +300;
            }
            else if(x>80 && x<=90)
            {
                ballXCoord = widthOfGraphicalArea/2-ballRadius +325;
            }
            else if(x>90 && x<=99)
            {
                ballXCoord = widthOfGraphicalArea/2-ballRadius +350;
            }
        }
        repaint();
    }
}