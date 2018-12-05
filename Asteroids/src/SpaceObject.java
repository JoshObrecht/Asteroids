
public abstract class SpaceObject 
	{

		protected Vector pos;
		protected Vector vel;
		protected Vector acc;

		protected int xCord[] = {650, 600, 600};
		protected int yCord[] = {450, 435, 465};
		protected int numPoints=3;

		double angle;
		
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

	}
