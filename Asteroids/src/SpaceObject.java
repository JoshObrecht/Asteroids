
public abstract class SpaceObject 
	{

		protected Vector pos;
		protected Vector vel;
		protected Vector acc;

		protected int xCord[];
		protected int yCord[];
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
				System.out.println("called");
				rotatePoints();
			}
		protected void rotatePoints()
		{
			for(int i = 0; i < xCord.length; i++)
				{
					Vector v = new Vector(xCord[i], yCord[i]);
					v.setO(angle);
					xCord[i] = (int) v.getX();
					yCord[i] = (int) v.getY();
					System.out.println(xCord[i]);
					System.out.println(yCord[i]);
				}
		}
		
		
	}
