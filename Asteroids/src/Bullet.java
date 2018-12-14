
public class Bullet extends SpaceObject
	{

	public Bullet(double angle, int x, int y)
		{
			super(angle);
			pos = new Vector(0,0);
			pos.setX(x);
			pos.setY(y);
			speed = 10;
		}

	protected void updatePoints()
		{
			// TODO Auto-generated method stub
			
		}

	}
