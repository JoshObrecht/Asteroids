import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class AsteroidsRunner extends JPanel
	{
//		static Asteroid type1= new Asteroid(0.0, 10);
//		static Asteroid type2= new Asteroid(0.0, 10);
//		static Asteroid type3= new Asteroid(0.0, 10);
//		static Asteroid type4= new Asteroid(0.0, 10);
		
		static int [] shipXCord = {650, 600, 600};
		static int [] shipYCord = {450, 435, 465};
		public AsteroidsRunner()
		{
			setBackground(Color.BLACK);
		}
		
		@Override
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			
			Ship player = new Ship(0.00, 3, shipXCord, shipYCord);
			g.setColor(Color.WHITE);
			g.drawPolygon(player.getxCord(), player.getyCord(), player.getNumPoints());
			
		}
		
		public static void main(String[] args)
			{
				JFrame frame = new JFrame("Asteroids");
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.setSize(913, 813);
				frame.add(new AsteroidsRunner());
				frame.setVisible(true);
			}

	}
