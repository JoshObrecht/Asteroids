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
		static ArrayList<Asteroid> asteroids = new ArrayList<Asteroid>();
		
		public static void main(String[] args)
		{
			JFrame frame = new JFrame("Asteroids");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(1013, 913);
			asteroids.add(new Asteroid(0.00));
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
							break;
						case KeyEvent.VK_RIGHT:
							player.setIsRot(1);
							break;
						case KeyEvent.VK_LEFT:
							player.setIsRot(-1);
							break;
						case KeyEvent.VK_SPACE:
							player.fire();
							bullets.add(new Bullet(player.getAngle(), player.getPoint(true), player.getPoint(false), player.getVel().getR()));
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
	        		for(Asteroid a: asteroids)
		        		{
		        			a.tick();
		        		}
	        		for(int i = 0; i < asteroids.size(); i++)
	        			{
	        				for(int b = 0; b < bullets.size(); b++)
	        					{
	        						if(asteroids.get(i).getAstBounds().contains(bullets.get(b).getPos().getX(), bullets.get(b).getPos().getY()))
	        						{
	        							asteroids.remove(i);
	        							bullets.remove(b);
	        							break;
	        						}
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
//			g.drawRect(asteroids.get(0).getPos().getX(), asteroids.get(0).getPos().getY(), 1, 1);

			if(player.isAcc() == true)
				{
					g.drawPolygon(player.getFireX(), player.getFireY(), 3);
				}
			for(Bullet b: bullets)
				{
					g.drawOval(b.getPos().getX(), b.getPos().getY(), 5, 5);
				}
			for(Asteroid a: asteroids)
				{
					a.updatePoints();
					g.drawPolygon(a.getAstBounds());
				}
//			g.drawRect(player.getPos().getX(), player.getPos().getY(), 1, 1);
		}
		
		

	}
