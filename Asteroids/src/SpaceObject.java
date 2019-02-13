import java.awt.Polygon;

public abstract class SpaceObject 
	{

		protected Vector pos;
		protected Vector vel;
		protected int[] xCord;
		protected int[] yCord;
		protected int numPoints;
		protected int tickCounter = 0;
		protected double rotationSpeed;
		protected double angle;
		protected Polygon bounds;
		protected Path path;
		
		public SpaceObject(double angle)
		{
			this.angle = angle;	
		}
		
		public int[] getxCord()
			{
				return xCord;
			}
		public void setxCord(int[] xCord)
			{
				this.xCord = xCord;
			}
		public int[] getyCord()
			{
				return yCord;
			}
		public void setyCord(int[] yCord)
			{
				this.yCord = yCord;
			}
		public int getNumPoints()
			{
				return numPoints;
			}
		public void setNumPoints(int numPoints)
			{
				this.numPoints = numPoints;
			}
		public Vector getPos()
			{
				return pos;
			}
		public void setPos(Vector pos)
			{
				this.pos = pos;
			}
		public Vector getVel()
			{
				return vel;
			}
		public void setVel(Vector vel)
			{
				this.vel = vel;
			}
		public double getAngle()
			{
				return angle;
			}
		public void setAngle(double angle)
			{
				this.angle = angle;
				vel.setO(angle);
				updatePoints();
			}
		public int getTickCounter()
			{
				return tickCounter;
			}
		public void setTickCounter(int tickCounter)
			{
				this.tickCounter = tickCounter;
			}
		public double getRotationSpeed() 
			{
				return rotationSpeed;
			}
		public void setRotationSpeed(double rotationSpeed) 
			{
				this.rotationSpeed = rotationSpeed;
			}
		public Polygon getAstBounds()
			{
				return bounds;
			}
		public void setBounds(Polygon bounds)
			{
				this.bounds = bounds;
			}
		public void tick()
		{
			pos = path.getNewPos();
			
			if(pos.getX() < 0 || pos.getX() > 1013 || pos.getY() < 0 || pos.getY() > 913)
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
					path = new Path(pos, vel.getR(), angle);
				}
			tickCounter++;
		}

		protected abstract void updatePoints();
		

		
		
	}
