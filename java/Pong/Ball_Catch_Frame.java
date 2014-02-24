//--------------------------------------------------------
//Name:Tyler Hartzheim
//E-mail: thartzheim@gmail.com
//ClassID: CPSC223J
//AssignmentNumber: Assignment 6
//Due Date: December 4, 2010
//--------------------------------------------------------
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Ball_Catch_Frame extends JFrame implements KeyListener
{
  //Game Area
    private PaddlePanel gamePanel;
    private PongControlPanel pongcontrol;
    private BorderLayout pongLayout;
    private final int ANIMATION_DELAY=10;
    private Timer animationTimer;
    public Ball_Catch_Frame()
    {
        super("Ball Catch!!!");
        animationTimer= new Timer( ANIMATION_DELAY, new TimerHandler());
      //Declare BorderLayout
        pongLayout= new BorderLayout();
        setLayout(pongLayout);
      //Declare Area for playing field
        gamePanel= new PaddlePanel();
        gamePanel.setBackground(Color.WHITE);
        gamePanel.setSize(700,600);
        add(gamePanel, BorderLayout.CENTER);
        gamePanel.addKeyListener(this);
        pongcontrol= new PongControlPanel(700,100);
        add(pongcontrol, BorderLayout.SOUTH);
        gamePanel.requestFocus();
    }
        public void keyPressed(KeyEvent event)
        {
            int keycode = event.getKeyCode();
            switch(keycode)
            {
                case KeyEvent.VK_LEFT:
                case KeyEvent.VK_KP_LEFT:
                case KeyEvent.VK_A:
                gamePanel.moveleft();
                animationTimer.start();
                break;
                case KeyEvent.VK_RIGHT:
                case KeyEvent.VK_KP_RIGHT:
                case KeyEvent.VK_D:
                gamePanel.moveright();
                animationTimer.start();
                break;
            }
            gamePanel.repaint();
        }
        public void keyReleased(KeyEvent event)
        {

        }
        public void keyTyped(KeyEvent event)
        {

        }
        public void requestFocusInPanel()
        {
            gamePanel.requestFocusInWindow();
        }
        public void makeFocusable()
        {
            gamePanel.setFocusable(true);
        }
        public void startClock()
        {
            animationTimer.start();
        }
        private class TimerHandler implements ActionListener
        {
            public void actionPerformed(ActionEvent actionEvent)
            {
                if(gamePanel.ballXCoord>=gamePanel.myPaddleXCoord-20 &&
                        gamePanel.ballXCoord<=gamePanel.myPaddleXCoord+60 &&
                        gamePanel.ballYCoord>=(gamePanel.heightOfGraphicalArea
                        -2*gamePanel.ballRadius))
                {
                    pongcontrol.AddPoint();
                }
                else if((gamePanel.ballXCoord<gamePanel.myPaddleXCoord-20 ||
                        gamePanel.ballXCoord>gamePanel.myPaddleXCoord+60) &&
                        gamePanel.ballYCoord>=(gamePanel.heightOfGraphicalArea
                        -2*gamePanel.ballRadius))
                {
                    pongcontrol.LosePoint();
                }
                gamePanel.lowerball(); 
            }
        }
}