import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.util.*;
import java.text.NumberFormat;
public class PongControlPanel extends JPanel
{
    //New Game and Exit Buttons
    JButton newGame;
    JButton exitGame;
  //Button Handler
    ballCatchButtonHandler actionlistenerobject;
  //Points and Percent label and textArea
    JLabel pointsLabel;
    JLabel percentLabel;
    JTextField pointsBox;
    JTextField percentBox;
    JPanel bottomPanel;
    GridLayout bottomPanelGrid;
    float points;
    float totalScore;
    float percent;
    String percentString;
    String pointsString;
    Locale locale= Locale.getDefault();
    NumberFormat percentFormatter=
                NumberFormat.getPercentInstance(locale);

    public PongControlPanel(int panelWidth, int panelHeight)
    {
        setLayout(new FlowLayout());
      //Set up button handler
        ballCatchButtonHandler handler = new ballCatchButtonHandler();
        actionlistenerobject = new ballCatchButtonHandler();
      //Declare buttons for New Game and Exit
        newGame= new JButton("New Game");
        newGame.addActionListener(handler);
        add(newGame);
        exitGame=new JButton("Exit");
        exitGame.addActionListener(handler);
        add(exitGame);
      //Declare Boxes at bottom of UI
        bottomPanel= new JPanel();
        bottomPanelGrid= new GridLayout(2,2);
        bottomPanel.setLayout(bottomPanelGrid);
        pointsLabel= new JLabel("Points");
        bottomPanel.add(pointsLabel);
        percentLabel= new JLabel("Percent");
        bottomPanel.add(percentLabel);
        pointsBox= new JTextField("");
        pointsBox.setEditable(false);
        pointsBox.setDisabledTextColor( Color.black);
        bottomPanel.add(pointsBox);
        percentBox= new JTextField("");
        percentBox.setEditable(false);
        percentBox.setDisabledTextColor( Color.black);
        bottomPanel.add(percentBox);
        add(bottomPanel);
        setPreferredSize(new Dimension(panelWidth,panelHeight));
        percentFormatter.setMinimumFractionDigits(2);

         
    }
    private class ballCatchButtonHandler implements ActionListener
        {
            public void actionPerformed( ActionEvent event)
            {
                if(event.getSource() == newGame)
                {
                    points=0;
                    pointsBox.setText("");
                    totalScore=0;
                    percent=0;
                    percentBox.setText("");

                }
                else if(event.getSource() == exitGame)
                {
                    System.exit(0);
                }
            }
        }
    public void AddPoint()
    {
        points=points+1;
        pointsString=Float.toString(points);
        pointsBox.setText(pointsString);
        totalScore=totalScore+1;
        percent=points/totalScore;
        percentBox.setText(percentFormatter.format(2));

    }
    public void LosePoint()
    {
        totalScore=totalScore+1;
        percent=points/totalScore;
        percentBox.setText(percentFormatter.format(percent));
    }
}