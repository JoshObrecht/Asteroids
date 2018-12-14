
public class Ship extends SpaceObject
	{
	
		private final double ROTATION_SPEED = 0.05;
		private boolean isAcc = false;
		private int isRot = 0;
		
	public Ship(double angle)
	{
		super(angle);
		pos = new Vector(0,0);
		pos.setX(432);
		pos.setY(407);
		vel = new Vector(0,0);
		acc = new Vector(0,0);
		xCord = new int[5];
		yCord = new int[5];
		numPoints = 5;
		updatePoints();
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
			v = new Vector(21.15476, angle + 2.60117);
			xCord[2] = v.getX() + pos.getX();
			yCord[2] = v.getY() + pos.getY();
			v = new Vector(21.15476, angle - 2.60117);
			xCord[3] = v.getX() + pos.getX();
			yCord[3] = v.getY() + pos.getY();
			v = new Vector(29.15476, angle - 2.60117);
			xCord[4] = v.getX() + pos.getX();
			yCord[4] = v.getY() + pos.getY();
		}
	public void tick()
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
				if(speed < 15)
					{
						vel = vel.addVects(new Vector(0.1, angle));
					}
						
			}
		else
			{
				if(speed > 0)
					{
						speed -= (speed / 55);
						vel.setR(speed);
					}
			}
		
		pos.setX(pos.getX() + vel.getX());
		pos.setY(pos.getY() + vel.getY());
		
		if(pos.getX() < 0 || pos.getX() > 913 || pos.getY() < 0 || pos.getY() > 813)
			{
				if(pos.getX() < 0)
					{
						pos.setX(913);
					}
				else if(pos.getX() > 913)
					{
						pos.setX(0);
					}
				if(pos.getY() < 0)
					{
						pos.setY(813);
					}
				else if(pos.getY() > 813)
					{
						pos.setY(0);
					}
			}
		
		updatePoints();
	}
	public void fire()
	{
		
	}
		
	}
