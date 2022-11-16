import java.awt.*;
import javax.swing.*;

public class ClockPanel extends JPanel
{
   private Color background;
   private Color clockColor;
   private Clock clock;

   public ClockPanel(Color background, Color clockColor)
   {
      this.background = background;
      this.clockColor = clockColor;
      clock = new Clock(this);
      
      clock.start();
   }

   @Override
   public void paintComponent(Graphics g)
   {
      // TODO: draw the background - set the color and use fillRect
	   background = Color.lightGray;
	   g.setColor(background);
	   g.fillRect(0,0,getWidth(),getHeight());
	   
	   

      // TODO: finish drawing the clock - set the color and use drawString
      g.setFont(new Font("Ink Free", Font.BOLD, 20));  // change the font to one that exists on your computer if needed!
      clock.updateClockSize(g);
	  g.setColor(Color.green);
	  g.drawString(clock.getTime(), clock.getX(), clock.getY());
      
      
      

   }
   
   public static void main(String[] args)
   {
      JFrame clockFrame = new JFrame("Time");
      clockFrame.setSize(500, 500);
      ClockPanel clockPanel = new ClockPanel(Color.BLACK, Color.GREEN);
      clockFrame.add(clockPanel);
      clockFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      clockFrame.setVisible(true);
      
      Clock clock = new Clock(clockPanel);
      clock.start();
   }

}
