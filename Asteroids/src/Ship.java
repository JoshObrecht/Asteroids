
public class Ship extends SpaceObject
	{
	
	protected int[] xCoord;
	protected int[] yCoord;
	
	public Ship(double angle, int numPoints, int [] xCord, int []yCord)
	{
		super(angle, numPoints, xCord, yCord);
		pos = new Vector(0,0);
		pos.setX(xCord[0] - 27);
		pos.setY(yCord[0]);
	}


	
	
		
	}
