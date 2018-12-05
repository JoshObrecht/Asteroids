import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;


@SuppressWarnings("serial")
public class AsteroidsRunner extends JPanel
	{
		static Ship player = new Ship(0.00, 3); 
		public AsteroidsRunner()
		{
			setBackground(Color.BLACK);
			addKeyListener(new KeyAdapter()
			{
				@Override
				public void keyPressed(KeyEvent e)
				{
					switch(e.getKeyCode())
					{
						case KeyEvent.VK_LEFT:
							System.out.println("ping");
							player.setAngle(0.7);
							repaint();
							break;
					}
				}
			});
			
		}
		
		@Override
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
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
