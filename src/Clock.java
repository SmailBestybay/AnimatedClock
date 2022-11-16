import java.awt.Graphics;
import java.time.ZonedDateTime;

public class Clock extends Thread
{
   private ClockPanel clockPanel;
   private int locationX = 100, locationY = 100;
   private int directionX = 10, directionY = 10;
   private int clockHeight;
   private int clockWidth;

   public Clock(ClockPanel clockPanel)
   {
      this.clockPanel = clockPanel;
   }
   
   private void setClockHeight(int height)
   {
      clockHeight = height;
   }
   
   private void setClockWidth(int width)
   {
      clockWidth = width;
   }
   
   public void updateClockSize(Graphics g)
   {
      // calculate the clock height and width
      clockHeight = g.getFontMetrics().getAscent();
      clockWidth = g.getFontMetrics().stringWidth(getTime());
   }
   
   public int getX()
   {
      return locationX;
   }

   public int getY()
   {
      return locationY;
   }
   
   public void move()
   {
      
      // define the boundaries
      int rightWall = clockPanel.getWidth() - clockWidth;
      int leftWall = 0;
      int topWall = 0 + clockHeight;
      int bottomWall = clockPanel.getHeight();

      // TODO: Calculate a new location (Hint: the ball should move by directionX and directionY)
      
      this.locationX += this.directionX;
      this.locationY += this.directionY;

      // TODO: if ball hits left wall or the right wall, change the x direction

		if (this.getX() == leftWall || this.getX() == rightWall) {
         this.directionX *= -1;
      }
      // TODO: if ball hits top or bottom walls, change the y direction
		if (this.getY() == topWall || this.getY() == bottomWall) {
         this.directionY *= -1;
      }
		
		clockPanel.getSize();

   }

   public String getTime()
   {
      ZonedDateTime time = ZonedDateTime.now();
      String timeString = time.getMonthValue() + "-" + time.getDayOfMonth() + "-" + time.getYear() + " " + time.getHour()
            + ":" + time.getMinute() + ":" + String.format("%02d", time.getSecond());
      return timeString;
   }

   public void run()
   {
      // TODO: Forever, move the clock, repaint clockPanel, then sleep for some amount of time
	   while(true) {
		   
		   clockPanel.repaint();
		   move();
		   try
		   {
			   this.sleep(1000);
		   }
		   catch (InterruptedException e)
		   {
			   e.printStackTrace();
		   }
	   }

	
	
   }
}
