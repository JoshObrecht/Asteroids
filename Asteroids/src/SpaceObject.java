
public abstract class SpaceObject 
	{

		protected Vector pos;
		protected Vector vel;
		protected Vector acc;

		protected int xCord[];
		protected int yCord[];
		protected int numPoints=3;

		double angle;
		
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

	}
