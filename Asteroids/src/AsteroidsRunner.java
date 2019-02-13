import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.Timer;
import java.util.ArrayList;
import java.util.Scanner;

@SuppressWarnings("serial")
public class AsteroidsRunner extends JPanel
	{		
		static Ship player = new Ship(0.00);
		static Ship shimage = new Ship((Math.PI * 3) / 2);
		static ArrayList<Bullet> bullets = new ArrayList<Bullet>();
		static ArrayList<Bullet> enemyBullets = new ArrayList<Bullet>();
		static ArrayList<Asteroid> asteroids = new ArrayList<Asteroid>();
		static ArrayList<UFO> enemies = new ArrayList<UFO>();
		static ArrayList<Asteroid> shrapnel = new ArrayList<Asteroid>();
		static Scanner userInput = new Scanner(System.in);
		static boolean firing;
		static int level = 4;
		static int choice;
		static int tick=0;
		static int score =0;
		static int stage = 0;
		
		public static void main(String[] args)
		{
			Asteroid.generateAsteroids();
			JFrame frame = new JFrame("Asteroids");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(1013, 913);
			AsteroidsRunner game = new AsteroidsRunner();
			frame.add(game);
			frame.setVisible(true);
			frame.setResizable(false);
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
							firing = true;
							break;
						case KeyEvent.VK_ENTER:
							if(!(stage == 1))
								{
									stage++;
								}
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
						firing = false;
						break;
					}
				}
			});
			Timer timer = new Timer(10, new ActionListener(){
				@Override
	        	public void actionPerformed(ActionEvent e)
	        	{
	        		switch(stage)
	        		{
	        			case 1:
	        				ArrayList<SpaceObject> gc = new ArrayList<SpaceObject>();
	    	        		ArrayList<SpaceObject> gc2 = new ArrayList<SpaceObject>();
	    	        		player.tick();
	    	        		for(int i=0; i<bullets.size();i++)
	    	        			{
	    	        				bullets.get(i).tick();
	    	        				if(bullets.get(0).getTickCounter()==60)
	    	        					{
	    	        						bullets.remove(bullets.get(0));
	    	        					}
	    	        			}
	    	        		for(int i=0; i<enemyBullets.size();i++)
	            				{
	            					enemyBullets.get(i).tick();
	            					if(enemyBullets.get(i).getTickCounter()==60)
	            						{
	            							enemyBullets.remove(enemyBullets.get(i));
	            						}
	            				}
	    	        		for(int a = 0; a < asteroids.size(); a++)
	    	        			{
	    							asteroids.get(a).tick();
	    	        			}       		
	    	        		tick++;
	    	        		if(tick==2000)
	    	        			{
	    	        				boolean isXValid = false;
	    	    					boolean isYValid = false;
	    	    					int randomX	= 0;	
	    	    					int randomY	= 0;
	    	        				while(!isXValid&&!isYValid)
	    	        					{
	    	        					randomX	= (int)Math.random()*1013;
	    	        					randomY	= (int)Math.random()*913;

	    	        					
	    	        					if((randomX<=300)||(randomX>=600))
	    	        						{
	    	        							isXValid=true;
	    	        						}
	    	        					if((randomY<=300)||(randomY>=600))
	    	        						{
	    	        							isXValid=true;
	    	        						}
	    	        					}
	    	        				enemies.add(new UFO((Math.random()*(Math.PI*2)), new Vector(randomX, randomY)));
	    	        				tick=0;
	    	        			}
	    	        		for(Asteroid s: shrapnel)
	    	        			{
	    	        				s.tick();
	    	        				if(s.getTickCounter() == 30)
	    	        					{
	    	        						gc.add(s);
	    	        					}
	    	        			}
	    	        		shrapnel.removeAll(gc);
	    	        		gc.clear();
	    	        		for(UFO u: enemies)
	    	        			{
	    	        				u.tick();
	    	        				int random = (int)((Math.random() * 100) + 1);
	    	        				if(random == 100)
	    	        				{
	    	        					enemyBullets.add(new Bullet(u.getAngle(), u.getxCord()[0], u.getyCord()[0], 0));
	    	        				}
	    	        			}
	    	        		for(int b = 0; b < enemyBullets.size(); b++)
	    	        		{
	    	        			if(player.getAstBounds().contains(enemyBullets.get(b).getPos().getX(), enemyBullets.get(b).getPos().getY()))
	    	        			{
	    	        				gc.add(enemyBullets.get(b));
	    		        			player.die();
	    		        			break;
	    	        			}
	    	        		}
	    	        		enemyBullets.removeAll(gc);
	    	        		gc.clear();
	    	        		for(int i = 0; i < asteroids.size(); i++)
	    	        			{
	    	        				for(int b = 0; b < bullets.size(); b++)
	    	        					{
	    	        						if(asteroids.get(i).getAstBounds().contains(bullets.get(b).getPos().getX(), bullets.get(b).getPos().getY()))
	    	        						{
	    	        							if(asteroids.get(i).getSize1()==50)
	    	        								{
	    	        								asteroids.add(new Asteroid((Math.random() * (Math.PI * 2)), 40, 25, new Vector(asteroids.get(i).getPos().getX(), asteroids.get(i).getPos().getY())));
	    	        		
	    	        										boolean isAngleValid = false;
	    	    	        								double randAngle = 0;
	    	        										while(!isAngleValid)
	    	        											{
	    	        											randAngle = (Math.random() * (Math.PI * 2));
	    	        											int counter=0;
	    	        								
	    	        												if(asteroids.get(asteroids.size()-1).getAngle()==randAngle)
	    	        													{
	    	        														counter+=1;
	    	        													}
	    	        												
	    	        											if(counter<1)
	    	        												{
	    	        												isAngleValid=true;	
	    	        												}
	    	        											
	    	        											}
	    	        								
	    	        								asteroids.add(new Asteroid(randAngle, 40, 25, new Vector(asteroids.get(i).getPos().getX(), asteroids.get(i).getPos().getY())));
	    	        								score+=20;
	    	        								}
	    	        							if(asteroids.get(i).getSize1()==40)
	    	        								{
	    	        									asteroids.add(new Asteroid((Math.random() * (Math.PI * 2)), 25, 10, new Vector(asteroids.get(i).getPos().getX(), asteroids.get(i).getPos().getY())));
	    	        									
	    	        									boolean isAngleValid = false;
	        	        								double randAngle = 0;
	            										while(!isAngleValid)
	            											{
	            											randAngle = (Math.random() * (Math.PI * 2));
	            											int counter=0;
	            								
	            												if(asteroids.get(asteroids.size()-1).getAngle()==randAngle)
	            													{
	            														counter+=1;
	            													}
	            												
	            											if(counter<1)
	            												{
	            												isAngleValid=true;	
	            												}
	            											
	            											}
	    	        								
	    	        								asteroids.add(new Asteroid(randAngle, 25, 10, new Vector(asteroids.get(i).getPos().getX(), asteroids.get(i).getPos().getY())));
	    	        								score+=50;
	    	        								}
	    	        							else if(asteroids.get(i).getSize1()==25)
	    	        								{
	    	        									score+=100;
	    	        								}
	    	        							gc.add(asteroids.get(i));
	    	        							gc2.add(bullets.get(b));
	    	        							
	    	        							break;
	    	        						}
	    	        					}
	    	        				if(checkPolyIntersect(player.getAstBounds(), asteroids.get(i).getAstBounds()))
	    	        					{
	    	        						if(asteroids.get(i).getSize1()==50)
	            								{
	            								asteroids.add(new Asteroid((Math.random() * (Math.PI * 2)), 40, 25, new Vector(asteroids.get(i).getPos().getX(), asteroids.get(i).getPos().getY())));
	            		
	            										boolean isAngleValid = false;
	        	        								double randAngle = 0;
	            										while(!isAngleValid)
	            											{
	            											randAngle = (Math.random() * (Math.PI * 2));
	            											int counter=0;
	            								
	            												if(asteroids.get(asteroids.size()-1).getAngle()==randAngle)
	            													{
	            														counter+=1;
	            													}
	            												
	            											if(counter<1)
	            												{
	            												isAngleValid=true;	
	            												}
	            											
	            											}
	            								
	            								asteroids.add(new Asteroid(randAngle, 40, 25, new Vector(asteroids.get(i).getPos().getX(), asteroids.get(i).getPos().getY())));
	            								}
	            							if(asteroids.get(i).getSize1()==40)
	            								{
	            									asteroids.add(new Asteroid((Math.random() * (Math.PI * 2)), 25, 10, new Vector(asteroids.get(i).getPos().getX(), asteroids.get(i).getPos().getY())));
	            									
	            									boolean isAngleValid = false;
	    	        								double randAngle = 0;
	        										while(!isAngleValid)
	        											{
	        											randAngle = (Math.random() * (Math.PI * 2));
	        											int counter=0;
	        								
	        												if(asteroids.get(asteroids.size()-1).getAngle()==randAngle)
	        													{
	        														counter+=1;
	        													}
	        												
	        											if(counter<1)
	        												{
	        												isAngleValid=true;	
	        												}
	        											
	        											}
	            								
	            								asteroids.add(new Asteroid(randAngle, 25, 10, new Vector(asteroids.get(i).getPos().getX(), asteroids.get(i).getPos().getY())));
	            								}
	            							gc.add(asteroids.get(i));
	    	        						player.die();
	    	        					}
	    	        			}
	    	        		for(SpaceObject a: gc)
	    	        			{
	    							for(int i = 0; i < 5; i++)
	    								{
	    									shrapnel.add(new Asteroid((Math.random() * (Math.PI * 2)), 1, 0, new Vector(a.getPos().getX(), a.getPos().getY())));
	    								}
	    	        			}
	    	        		asteroids.removeAll(gc);
	    	        		bullets.removeAll(gc2);
	    	        		gc.clear();
	    	        		gc2.clear();
	    	        		
	    	        		if(asteroids.size()==0)
	    	        			{
	    	        				level++;
	    	        				for(int i = 0; i < level; i++)
	    	        					{
//	    	        						System.out.println(level);
	    	        						Asteroid.generateAsteroids();
	    	        					}
//	    	        				Asteroid.generateAsteroids();
	    	        			}
	    	        		
	    	        		for(int i = 0; i < enemies.size(); i++)
	            			{
	            				for(int b = 0; b < bullets.size(); b++)
	            					{
	            						if(enemies.get(i).getAstBounds().contains(bullets.get(b).getPos().getX(), bullets.get(b).getPos().getY()))
	            						{
	            							gc.add(enemies.get(i));
	            							gc2.add(bullets.get(b));
	            						}
	            					}
	            			}
	    	        		enemies.removeAll(gc);
	    	        		bullets.removeAll(gc2);
	    	        		gc.clear();
	    	        		gc2.clear();
	        				break;
	        		}
	        		repaint();
	        	}
	        });
	        timer.start();
	        Timer bulletTimer = new Timer(100, new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) 
				{
					if(firing && stage == 1)
						bullets.add(new Bullet(player.getAngle(), player.getPoint(true), player.getPoint(false), player.getVel().getR()));
				}
	        });
	        bulletTimer.start();
			
		}
		
		@Override
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			switch(stage)
			{
				case 0:
					
					break;
				case 1:
					Font f = new Font("HELVETICA", Font.PLAIN, 25);
					g.setColor(Color.white);
					g.setFont(f);
					g.drawString(String.valueOf(score), 950, 30);
					g.setColor(Color.WHITE);
					g.drawPolygon(player.getAstBounds());
//					g.drawRect(asteroids.get(0).getPos().getX(), asteroids.get(0).getPos().getY(), 1, 1);

					if(player.isAcc() == true && !player.isRespawning())
						{
							g.drawPolygon(player.getFireX(), player.getFireY(), 3);
						}
					for(Bullet b: bullets)
						{
							g.drawOval(b.getPos().getX(), b.getPos().getY(), 5, 5);
						}
					for(Bullet b: enemyBullets)
						{
							g.drawOval(b.getPos().getX(), b.getPos().getY(), 5, 5);
						}
					for(Asteroid a: asteroids)
						{
							a.updatePoints();
//							g.drawString("" + asteroids.indexOf(a) + "", a.getPos().getX(), a.getPos().getY());
							g.drawPolygon(a.getAstBounds());
						}
					for(Asteroid s: shrapnel)
						{
							s.updatePoints();
							g.drawPolygon(s.getAstBounds());
						}
					for(UFO u: enemies)
						{
							u.updatePoints();
							g.drawPolygon(u.getAstBounds());
							g.drawLine(u.getxCord()[0], u.getyCord()[0], u.getxCord()[3], u.getyCord()[3]);
							g.drawLine(u.getxCord()[4], u.getyCord()[4], u.getxCord()[7], u.getyCord()[7]);
						}
					for(int i = 0; i < player.getLives() - 1; i++)
						{
							shimage.setPos(new Vector(50 + (i * 40), 50));
							shimage.tick();
							g.drawPolygon(shimage.getAstBounds());
						}
					break;
			}
			
		}
		public boolean checkPolyIntersect(Polygon p1, Polygon p2)
	    {
	        Point p;
	        for(int i = 0; i < p2.npoints;i++)
	        {
	            p = new Point(p2.xpoints[i],p2.ypoints[i]);
	            if(p1.contains(p))
	                return true;
	        }
	        for(int i = 0; i < p1.npoints;i++)
	        {
	            p = new Point(p1.xpoints[i],p1.ypoints[i]);
	            if(p2.contains(p))
	                return true;
	        }
	        return false;
	    }
		

	}
