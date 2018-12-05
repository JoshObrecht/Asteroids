
public abstract class SpaceObject 
	{
		protected int xCord[] = {650, 600, 600};
		protected int yCord[] = {450, 435, 465};
		protected int numPoints=3;
		
		Vector pos;
		Vector vel;
		Vector acc;
		double angle;
		
		public SpaceObject()
		{
		angle = 0;	
		}
		
		public int[] coordToPolar(int xVect, int yVect)
		{
			return null;
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
	}
