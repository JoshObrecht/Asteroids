
public class Ship extends SpaceObject
	{
	
	public Ship(double angle, int numPoints, int [] xCord, int []yCord)
	{
		super(angle, numPoints, xCord, yCord);
		pos = new Vector(0,0);
		pos.setX(xCord[0] - 25);
		pos.setY(yCord[0]);
		vel = new Vector(0,0);
		acc = new Vector(0,0);
	}

	public void tick()
	{
		pos.setX(pos.getX() + vel.getX());
		pos.setY(pos.getY() + vel.getY());
		updatePoints();
		
	}
		
	}
