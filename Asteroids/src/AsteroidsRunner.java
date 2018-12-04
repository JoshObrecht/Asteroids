import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class AsteroidsRunner extends JPanel
	{

		public AsteroidsRunner()
		{
			setBackground(Color.BLACK);
		}
		
		@Override
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			
			Ship player = new Ship();
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
