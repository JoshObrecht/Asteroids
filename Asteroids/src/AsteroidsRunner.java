import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.Timer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

@SuppressWarnings("serial")
public class AsteroidsRunner extends JPanel
	{		
		static int counter = 0;
		final static String [] alphaBET= {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
		final static int [] alphaBETCounter = {0, 0, 0};
		//score selection variables
		static ArrayList<Score> highScores = new ArrayList<Score>(10);
		static Ship player = new Ship(0.00);
		static Ship shimage = new Ship((Math.PI * 3) / 2);
		static ArrayList<Bullet> bullets = new ArrayList<Bullet>();
		static ArrayList<Bullet> enemyBullets = new ArrayList<Bullet>();
		static ArrayList<Asteroid> asteroids = new ArrayList<Asteroid>();
		static ArrayList<UFO> enemies = new ArrayList<UFO>();
		static ArrayList<Asteroid> shrapnel = new ArrayList<Asteroid>();
		static Scanner userInput = new Scanner(System.in);
		static boolean firing;
		static int level = 3;
		static int choice;
		static int tick=0;
		static int score =0;
		static int stage = 0;
		static boolean[] showingStrings = {false, false};
		
		public static void main(String[] args)
		{
			UploadScores.readScores();
			UploadScores.createDefaultScores();
			highScores.trimToSize();
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
							if(stage==1)
								player.setAcc(true);
							
							else if(stage == 3)
	                			{
	                				if(alphaBETCounter[counter]==25)
	                					{
	                						alphaBETCounter[counter] = 0;
	                					}
	                				else
	                					{
	                						alphaBETCounter[counter]+=1;
	                					}
	                			}
							break;
						case KeyEvent.VK_DOWN:
							if(stage == 3)
	                			{
	                				if(alphaBETCounter[counter]==0)
	                					{
	                						alphaBETCounter[counter] = 25;
	                					}
	                				else
	                					{
	                						alphaBETCounter[counter]-=1;
	                					}
	                			}
							break;
						case KeyEvent.VK_RIGHT:
							if(stage==1)
								player.setIsRot(1);
							
							else if(stage == 3)
	                			{
	                				if(counter == 2)
	                					{
	                						counter = 0;
	                					}
	                				else
	                					{
	                						counter+=1;
	                					}
	                			}
							break;
						case KeyEvent.VK_LEFT:
							if(stage==1)
								player.setIsRot(-1);
							
							else if(stage == 3)
	                			{
	                				if(counter == 0)
	                					{
	                						counter = 2;
	                					}
	                				else
	                					{
	                						counter-=1;
	                					}
	                			}
							break;
						case KeyEvent.VK_SPACE:
							if(stage==1)
								firing = true;
							break;
						case KeyEvent.VK_ENTER:

							switch(stage)
							{
								case 0:
									asteroids.clear();
									stage++;
									break;
								case 1:
									break;
								case 2:
									stage++;
									break;
								case 3:
									highScores.add(new Score(score, (alphaBET[alphaBETCounter[0]]+alphaBET[alphaBETCounter[1]]+alphaBET[alphaBETCounter[2]])));
									Collections.sort(highScores, new ScoreSorter());
									Collections.reverse(highScores);
									UploadScores.writeScores();
									stage++;
									break;
								case 4:
									stage=1;
									restart();
									tick = 0;
									score = 0;
									level = 3;
									break;		
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
	        			case 0:
	        				while(asteroids.size() < 12)
	        					{
	        						Asteroid.generateAsteroids();
	        					}
	        				for(int a = 0; a < asteroids.size(); a++)
	        					{
	        						asteroids.get(a).tick();
	        					}
	        				if(tick == 50)
	        					{
	        						showingStrings[0] = true;
	        					}
	        				if(tick == 100)
	        					{
	        						showingStrings[1] = true;
	        					}
	        				tick++;
	        				break;
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
	            							score+=1000;
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
	        			case 2:
	        			case 3:
	        			case 4:
	        				for(UFO u: enemies)
	        					{
	        						u.tick();
	        					}
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
			Font f = new Font("Arial", Font.PLAIN, 50);
			Font f2 = new Font("Arial", Font.PLAIN, 25);
			Font z=new Font("Arial", Font.PLAIN, 15);
			Font restart = new Font("Arial", Font.PLAIN, 40);
			Font scores = new Font("Arial", Font.PLAIN, 30);
			super.paintComponent(g);
			switch(stage)
			{
				case 0:
					g.setColor(Color.gray);
					for(Asteroid a: asteroids)
						{
							a.updatePoints();
							g.drawPolygon(a.getAstBounds());
						}
					g.setColor(Color.white);
					Font aFont = new Font("Arial", Font.BOLD, 70);
					g.setFont(aFont);
					g.drawString("ASTEROIDS", 300, 300);
					if(showingStrings[0])
						{
							Font bFont = new Font("HELVETICA", Font.PLAIN, 18);
							g.setFont(bFont);
							g.drawString("A GAME BY ANDREW AND JOSH", 360, 360);
						}
					if(showingStrings[1])
						{
							Font cFont = new Font("HELVETICA", Font.PLAIN, 15);
							g.setFont(cFont);
							String s = "PRESS ENTER TO START";
							int x = 230;
							for(int c = 0; c < s.length(); c++)
								{
									g.drawString(s.substring(c, c+1), x + (30 * c), 600);
								}
						}
					break;
				case 1:
					
					int scoreDigits=0;
					boolean run = true;
					int tempScore = score;
					while(run)
					{
						if(tempScore==0)
							run=false;
						else
							{
						tempScore/=10;
						scoreDigits+=12;
							}
					}
					
					g.setColor(Color.white);
					g.setFont(f2);
					g.drawString(String.valueOf(score), (990-scoreDigits), 30);
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
				case 2:
					while(enemies.size() < 6)
						{
							int x = (int) (Math.random() * 1013);
							int y = (int) (Math.random() * 913);
							enemies.add(new UFO(0.00, new Vector(x, y)));
						}
					 g.setColor(Color.white);
					 g.setFont(f);
					 g.drawString("GAME OVER", 328, 390);	
					 
					 g.setColor(Color.white);
					 g.setFont(z);
					 g.drawString("YOUR SCORE WAS: "+score, 400, 420);
					 for(UFO u: enemies)
						 {
							g.setColor(Color.gray);
							u.updatePoints();
							g.drawPolygon(u.getAstBounds());
							g.drawLine(u.getxCord()[0], u.getyCord()[0], u.getxCord()[3], u.getyCord()[3]);
							g.drawLine(u.getxCord()[4], u.getyCord()[4], u.getxCord()[7], u.getyCord()[7]);
						 }
					break;
				case 3:
					 g.setColor(Color.white);
					 g.setFont(f);
					 g.drawString("ENTER YOUR NAME", 218, 290);
					 
					 g.setColor(Color.white);
					 g.setFont(f2);
					 g.drawString(alphaBET[alphaBETCounter[0]], 420, 400);
					 
					 g.setColor(Color.white);
					 g.setFont(f2);
					 g.drawString(alphaBET[alphaBETCounter[1]], 445, 400);
					 
					 g.setColor(Color.white);
					 g.setFont(f2);
					 g.drawString(alphaBET[alphaBETCounter[2]], 470, 400);
					 
					 switch(counter)
					 {
						 case 0:
							 drawTriangle(g, 420, 400, true);
							 drawTriangle(g, 420, 400, false);
							 break;
						 case 1:
							 drawTriangle(g, 445, 400, true);
							 drawTriangle(g, 445, 400, false);
							 break;
						 case 2:
							 drawTriangle(g, 470, 400, true);
							 drawTriangle(g, 470, 400, false);
							 break;
					 }
					 for(UFO u: enemies)
						 {
							g.setColor(Color.gray);
							u.updatePoints();
							g.drawPolygon(u.getAstBounds());
							g.drawLine(u.getxCord()[0], u.getyCord()[0], u.getxCord()[3], u.getyCord()[3]);
							g.drawLine(u.getxCord()[4], u.getyCord()[4], u.getxCord()[7], u.getyCord()[7]);
						 }
					 break;
					 
				case 4:
					int tempY = 120;
					 
					 g.setColor(Color.white);
					 g.setFont(f);
					 g.drawString("HIGH SCORES", 270, 50);
					 
					 g.drawRect(50, 60, 800, 1);
					 
					 g.setColor(Color.white);
					 g.setFont(restart);
					 g.drawString("PRESS ENTER TO RESTART", 180, 750);
					 
					 for(int i=0 ; i<10; i++)
						 {
							 g.setColor(Color.white);
							 g.setFont(scores);
							 g.drawString(highScores.get(i).getName(), 366, tempY);
							 
							 g.setColor(Color.white);
							 g.setFont(scores);
							 g.drawString(String.valueOf(highScores.get(i).getScore()), 496, tempY);
							 
							 tempY+=50;
						 }
					 for(UFO u: enemies)
						 {
							g.setColor(Color.gray);
							u.updatePoints();
							g.drawPolygon(u.getAstBounds());
							g.drawLine(u.getxCord()[0], u.getyCord()[0], u.getxCord()[3], u.getyCord()[3]);
							g.drawLine(u.getxCord()[4], u.getyCord()[4], u.getxCord()[7], u.getyCord()[7]);
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
		 public void drawTriangle(Graphics g, int x, int y, boolean up)
			 {
				 if(up)
					 {
						 g.drawRect(x, y - 25, 15, 1);
						 g.drawRect(x + 2, y - 27, 11, 1); 
						 g.drawRect(x + 4, y - 29, 7, 1);
						 g.drawRect(x + 6, y - 31, 3, 1);
						 g.drawRect(x + 7, y - 32, 1, 1);
					 }
				 else
					 {
						 g.drawRect(x, y + 7, 15, 1);
						 g.drawRect(x + 2, y + 9, 11, 1); 
						 g.drawRect(x + 4, y + 11, 7, 1);
						 g.drawRect(x + 6, y + 13, 3, 1);
						 g.drawRect(x + 7, y + 14, 1, 1); 
					 }
			 }
		 public static void restart()
		 {
			 asteroids.clear();
			 enemies.clear();
			 bullets.clear();
			 enemyBullets.clear();
			 shrapnel.clear();
			 player = new Ship(0.00);
		 }
		

	}
