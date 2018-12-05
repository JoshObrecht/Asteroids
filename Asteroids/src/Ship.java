
public class Ship extends SpaceObject
	{
	private int xCord[] = {400, 300, 300};
	private int yCord[] = {400, 300, 500};
	private int numPoints=3;
	
	public Ship(double angle)
	{
		super(angle);
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
