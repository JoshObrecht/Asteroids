import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.Timer;


@SuppressWarnings("serial")
public class AsteroidsRunner extends JPanel
	{
//		static Asteroid type1= new Asteroid(0.0, 10);
//		static Asteroid type2= new Asteroid(0.0, 10);
//		static Asteroid type3= new Asteroid(0.0, 10);
//		static Asteroid type4= new Asteroid(0.0, 10);
		
		static int [] shipXCord = {457, 407, 407};
		static int [] shipYCord = {407, 392, 422};
		
		static Ship player = new Ship(0.00, 3, shipXCord, shipYCord);
		
		public static void main(String[] args)
		{
			JFrame frame = new JFrame("Asteroids");
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame.setSize(913, 813);
			AsteroidsRunner game = new AsteroidsRunner();
			frame.add(game);
			frame.setVisible(true);
			game.setFocusable(true);
		}
		
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
						case KeyEvent.VK_UP:
							player.setVel(new Vector(1,player.getAngle()));
							break;
						case KeyEvent.VK_RIGHT:
							player.setAngle(player.getAngle() + (Math.PI / 8));
							break;
						case KeyEvent.VK_LEFT:
							player.setAngle(player.getAngle() - (Math.PI / 8));
							break;
					}
				}
				public void keyReleased(KeyEvent e)
				{
					switch(e.getKeyCode())
					{
						
					}
				}
			});
			Timer timer = new Timer(10, new ActionListener(){
	        	@Override
	        	public void actionPerformed(ActionEvent e)
	        	{
	        		player.tick();
	        		repaint();
	        	}
	        
	        });
	        timer.start();
			
		}
		
		@Override
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			
			g.setColor(Color.WHITE);
			g.drawPolygon(player.getxCord(), player.getyCord(), player.getNumPoints());
			g.drawRect(player.getPos().getX(), player.getPos().getY(), 1, 1);
		}
		
		

	}
