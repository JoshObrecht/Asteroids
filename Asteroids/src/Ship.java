import java.awt.Polygon;

public class Ship extends SpaceObject
	{
	
		private final double ROTATION_SPEED = 0.05;
		private boolean isAcc;
		private int isRot;
		private int[] fireX;
		private int[] fireY;
		private int lives;
		private int delayTicks;
		private boolean respawning;
		
	public Ship(double angle)
	{
		super(angle);
		pos = new Vector(432,407);
		vel = new Vector(0,0);
		xCord = new int[5];
		yCord = new int[5];
		numPoints = 5;
		fireX = new int[3];
		fireY = new int[3];
		bounds = new Polygon();
		isAcc = false;
		isRot = 0;
		lives = 4;
		respawning = false;
		delayTicks = 0;
		updatePoints();
	}

	public boolean isRespawning()
		{
			return respawning;
		}
	public void setRespawning(boolean respawning)
		{
			this.respawning = respawning;
		}
	public int getLives() 
		{
			return lives;
		}
	public void setLives(int newLives) 
		{
			lives = newLives;
		}
	public boolean isAcc()
		{
			return isAcc;
		}
	public void setAcc(boolean isAcc)
		{
			this.isAcc = isAcc;
		}
	public int getIsRot()
		{
			return isRot;
		}
	public void setIsRot(int isRot)
		{
			this.isRot = isRot;
		}
	public int[] getFireX()
		{
			return fireX;
		}
	public void setFireX(int[] fireX)
		{
			this.fireX = fireX;
		}
	public int[] getFireY()
		{
			return fireY;
		}
	public void setFireY(int[] fireY)
		{
			this.fireY = fireY;
		}
	public int getPoint(boolean x)
	{
		if(x)
			{
				return xCord[0];
			}
		else
			{
				return yCord[0];
			}
	}
	protected void updatePoints()
		{
			Vector v = new Vector(25.00, angle);
			xCord[0] = v.getX() + pos.getX();
			yCord[0] = v.getY() + pos.getY();
			v = new Vector(29.15476, angle + 2.60117);
			xCord[1] = v.getX() + pos.getX();
			yCord[1] = v.getY() + pos.getY();
			v = new Vector(22.15476, angle + 2.49117);
			xCord[2] = v.getX() + pos.getX();
			yCord[2] = v.getY() + pos.getY();
			v = new Vector(22.15476, angle - 2.49117);
			xCord[3] = v.getX() + pos.getX();
			yCord[3] = v.getY() + pos.getY();
			v = new Vector(29.15476, angle - 2.60117);
			xCord[4] = v.getX() + pos.getX();
			yCord[4] = v.getY() + pos.getY();
			
			v = new Vector(20.15476, angle + 2.79117);
			fireX[0] = v.getX() + pos.getX();
			fireY[0] = v.getY() + pos.getY();
			v = new Vector((Math.random() * 12) + 32, angle + Math.PI);
			fireX[1] = v.getX() + pos.getX();
			fireY[1] = v.getY() + pos.getY();
			v = new Vector(20.15476, angle - 2.79117);
			fireX[2] = v.getX() + pos.getX();
			fireY[2] = v.getY() + pos.getY();
			
			bounds = new Polygon(xCord, yCord, xCord.length);
		}
	public void tick()
	{
		if(respawning && (tickCounter - delayTicks >= 200))
			{
				delayTicks = 0;
				pos = new Vector(432, 407);
				vel = new Vector(0,0);
				angle = 0.00;
				respawning = false;
			}
		if(respawning)
			AsteroidsRunner.firing = false;
		
		if(!respawning)
			{
				if(isRot > 0)
					{
						angle += ROTATION_SPEED;
					}
				else if(isRot < 0)
					{
						angle -= ROTATION_SPEED;
					}
				if(isAcc)
					{
		   			    vel.addVects(new Vector(0.1, angle));
		   			    if(vel.getR() >= 10)
		   			    	{
		   			    		vel.setR(10);
		   			    	}
					}
				else
					{
						if(vel.getR() > 0)
							{
								vel.setR(vel.getR() - (vel.getR() / 140));
							}
					}
				
				pos.setX(pos.getX() + vel.getX());
				pos.setY(pos.getY() + vel.getY());
				
				if(pos.getX() < 0 || pos.getX() > 913 || pos.getY() < 0 || pos.getY() > 813)
					{
						if(pos.getX() < 0)
							{
								pos.setX(1013);
							}
						else if(pos.getX() > 1013)
							{
								pos.setX(0);
							}
						if(pos.getY() < 0)
							{
								pos.setY(913);
							}
						else if(pos.getY() > 913)
							{
								pos.setY(0);
							}
					}
				updatePoints();
			}
		tickCounter++;
		
	}
	public void die()
	{
		int[] deathX = {-100,-101};
		int[] deathY = {-100, -101};
		delayTicks = getTickCounter();
		lives--;
		bounds = new Polygon(deathX, deathY, 2);
		respawning = true;
		if(lives <= 0)
			{
				delayTicks = Integer.MAX_VALUE;
				AsteroidsRunner.stage=2;
				AsteroidsRunner.restart();
			}
	}
	}
