import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.Timer;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class AsteroidsRunner extends JPanel
	{
//		static Asteroid type1= new Asteroid(0.0, 10);
//		static Asteroid type2= new Asteroid(0.0, 10);
//		static Asteroid type3= new Asteroid(0.0, 10);
//		static Asteroid type4= new Asteroid(0.0, 10);
		
		static Ship player = new Ship(0.00);

		static ArrayList<Bullet> bullets = new ArrayList<Bullet>();
		
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
							player.setAcc(true);
							player.setSpeed(player.getSpeed() + 0.3);
							break;
						case KeyEvent.VK_RIGHT:
							player.setIsRot(1);
							break;
						case KeyEvent.VK_LEFT:
							player.setIsRot(-1);
							break;
						case KeyEvent.VK_SPACE:
							player.fire();
							bullets.add(new Bullet(player.getAngle(), player.getPoint(true), player.getPoint(false)));
							break;
					}
				}
				public void keyReleased(KeyEvent e)
				{
					switch(e.getKeyCode())
					{
					case KeyEvent.VK_UP:
						player.setAcc(false);
						break;
					case KeyEvent.VK_RIGHT:
						player.setIsRot(0);
						break;
					case KeyEvent.VK_LEFT:
						player.setIsRot(0);
						break;
					case KeyEvent.VK_SPACE:
						break;
					}
				}
			});
			Timer timer = new Timer(10, new ActionListener(){
	        	@Override
	        	public void actionPerformed(ActionEvent e)
	        	{
	        		player.tick();
	        		for(int i=0; i<bullets.size();i++)
	        			{
	        				bullets.get(i).tick();
	        				if(bullets.get(0).getTickCounter()==60)
	        					{
	        						bullets.remove(bullets.get(0));
	        					}
	        			}
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
			g.drawPolygon(a.getxCord(), a.getyCord(), 10);
			for(Bullet b: bullets)
				{
					g.drawOval(b.getPos().getX(), b.getPos().getY(), 5, 5);
				}
//			g.drawRect(player.getPos().getX(), player.getPos().getY(), 1, 1);
		}
		
		

	}
