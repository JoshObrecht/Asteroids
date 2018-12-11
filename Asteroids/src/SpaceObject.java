
public abstract class SpaceObject 
	{

		protected Vector pos;
		protected Vector vel;
		protected Vector acc;

		protected int[] xCord;
		protected int[] yCord;
		protected int numPoints;


		protected double angle;
		
		public SpaceObject(double angle, int numPoints, int[]xCord, int[]yCord)
		{
			this.angle = angle;	
			this.numPoints = numPoints;
			this.xCord = xCord;
			this.yCord = yCord;
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
		public Vector getAcc()
			{
				return acc;
			}
		public void setAcc(Vector acc)
			{
				this.acc = acc;
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
		protected void updatePoints()
		{
//			for(int i = 0; i < xCord.length; i++)
//				{
//					double x1 = (double) (xCord[i] - pos.getX());
//					double y1 = (double) (yCord[i] - pos.getY());
//					x1 = ((x1 * Math.cos(angle)) + (y1 * Math.sin(angle)));
//					y1 = ((x1 * Math.sin(angle)) - (y1 * Math.cos(angle)));
//					x1 = Math.floor((x1 + 0.5));
//					y1 = Math.floor((y1 + 0.5));
//					xCord[i] = (int) x1 + pos.getX();
//					yCord[i] = (int) y1 + pos.getY();
//					
//				}
			for(int j = 0; j < xCord.length; j++)
				{
					Vector v = new Vector(xCord[j] - pos.getX(), yCord[j] - pos.getY());
					v.setO(angle);
					xCord[j] = v.getX() + pos.getX();
					yCord[j] = v.getY() + pos.getY();
				}
		}
		
		
	}
