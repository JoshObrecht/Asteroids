
public class Bullet extends SpaceObject
	{

	public Bullet(double angle, int numPoints, int[] xCord, int[] yCord)
		{
			super(angle, numPoints, xCord, yCord);
			pos = new Vector(0,0);
			pos.setX(xCord[0]);
			pos.setY(yCord[0]);
			speed = 10;
		}

	}
